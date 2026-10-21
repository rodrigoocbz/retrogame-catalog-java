"""Integration checks against a LOCAL demo backend. Creates and removes its own row."""
import json
import os
import urllib.error
import urllib.request

BASE = os.environ.get('API_URL', 'http://localhost:8081').rstrip('/')

def call(method, path, body=None):
    request = urllib.request.Request(BASE + path, method=method,
        data=json.dumps(body).encode() if body is not None else None,
        headers={'Content-Type': 'application/json'})
    try:
        with urllib.request.urlopen(request, timeout=20) as response:
            return response.status, response.read().decode()
    except urllib.error.HTTPError as error:
        return error.code, error.read().decode()

sample = dict(titulo='Portfolio integration check', precio=24.99, stock=3,
    fechaLanzamiento='2005-04-30', codigoSerial='TST-2026-EUR',
    correoProveedor='demo@example.com', valoracion=8.5, categoria='RPG',
    urlImagen='https://example.com/cover.png')
created_id = None
try:
    status, body = call('GET', '/videojuegos')
    assert status == 200 and isinstance(json.loads(body), list), (status, body)
    status, body = call('POST', '/videojuegos', sample)
    assert status == 201, (status, body)
    created_id = json.loads(body)['codigo']
    path = f'/videojuegos/{created_id}'
    status, body = call('GET', path)
    assert status == 200 and json.loads(body)['titulo'] == sample['titulo']
    updated = dict(sample, titulo='Updated portfolio check', stock=5)
    status, body = call('PUT', path, updated)
    assert status == 204, (status, body)
    status, body = call('GET', path)
    assert json.loads(body)['stock'] == 5 and json.loads(body)['titulo'] == updated['titulo']
    for method, endpoint in [('POST', '/videojuegos'), ('PUT', path)]:
        for field, bad in [('stock', -1), ('correoProveedor', 'invalid'), ('urlImagen', 'file:///tmp/image.png'), ('codigoSerial', 'invalid')]:
            status, body = call(method, endpoint, dict(updated, **{field: bad}))
            assert status == 400, (method, field, status, body)
        missing = dict(updated)
        del missing['stock']
        status, body = call(method, endpoint, missing)
        assert status == 400, (method, 'missing stock', status, body)
    status, body = call('GET', path)
    assert json.loads(body)['stock'] == 5, 'Invalid edits must not change persisted data'
    status, body = call('DELETE', path)
    assert status == 204, (status, body)
    created_id = None
    status, body = call('GET', path)
    assert status == 404, (status, body)
    print('PASS: list, create, read, update, delete, 404, POST/PUT validation, rejected edits preserve data')
finally:
    if created_id is not None:
        call('DELETE', f'/videojuegos/{created_id}')
