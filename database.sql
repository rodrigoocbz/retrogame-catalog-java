-- Run only when initializing the isolated demo database.

CREATE TABLE videojuegos_retro
(
    codigo             BIGINT GENERATED ALWAYS AS IDENTITY,
    titulo             VARCHAR(100),
    precio             NUMERIC(6, 2),
    stock              NUMERIC(3),
    fecha_lanzamiento  DATE,
    codigo_serial      VARCHAR(12),
    correo_proveedor   VARCHAR(100),
    valoracion         NUMERIC(3, 1),
    categoria          VARCHAR(20),
    url_imagen         VARCHAR(500),

    CONSTRAINT "PK_VIDEOJUEGOS"            PRIMARY KEY (codigo),
    CONSTRAINT "NN_VIDEOJUEGOS.TITULO"     CHECK (titulo IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.PRECIO"     CHECK (precio IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.STOCK"      CHECK (stock IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.FECHA"      CHECK (fecha_lanzamiento IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.SERIAL"     CHECK (codigo_serial IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.CORREO"     CHECK (correo_proveedor IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.VALORACION" CHECK (valoracion IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.CATEGORIA"  CHECK (categoria IS NOT NULL),
    CONSTRAINT "NN_VIDEOJUEGOS.URL_IMAGEN" CHECK (url_imagen IS NOT NULL),

    CONSTRAINT "CH_VIDEOJUEGOS.PRECIO"     CHECK (precio BETWEEN 1.00 AND 1500.00),
    CONSTRAINT "CH_VIDEOJUEGOS.STOCK"      CHECK (stock >= 0),
    CONSTRAINT "CH_VIDEOJUEGOS.VALORACION" CHECK (valoracion BETWEEN 0.0 AND 10.0),
    CONSTRAINT "CH_VIDEOJUEGOS.CATEGORIA"  CHECK (categoria IN ('PLATAFORMAS', 'RPG', 'ACCION', 'AVENTURA')),
    CONSTRAINT "CH_VIDEOJUEGOS.SERIAL"     CHECK (codigo_serial ~ '^[A-Z]{3}-[0-9]{4}-[A-Z]{3}$'),
    CONSTRAINT "CH_VIDEOJUEGOS.CORREO"     CHECK (correo_proveedor ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'),
    CONSTRAINT "CH_VIDEOJUEGOS.URL_IMAGEN" CHECK (url_imagen ~ '^https?://.*')
);

INSERT INTO videojuegos_retro (titulo, precio, stock, fecha_lanzamiento, codigo_serial, correo_proveedor, valoracion, categoria, url_imagen)
VALUES ('Pokémon Edición Esmeralda', 89.95, 4, '2005-04-30', 'GBA-2005-EUR', 'nintendo@example.com', 9.8, 'RPG', 'https://m.media-amazon.com/images/I/71sILUUf3jL._AC_SY879_.jpg');

INSERT INTO videojuegos_retro (titulo, precio, stock, fecha_lanzamiento, codigo_serial, correo_proveedor, valoracion, categoria, url_imagen)
VALUES ('The Legend of Zelda: Minish Cap', 75.00, 2, '2004-11-12', 'GBA-2004-EUR', 'capcom@example.com', 9.5, 'AVENTURA', 'https://m.media-amazon.com/images/I/71JLhcez40L._AC_SY879_.jpg');

INSERT INTO videojuegos_retro (titulo, precio, stock, fecha_lanzamiento, codigo_serial, correo_proveedor, valoracion, categoria, url_imagen)
VALUES ('Super Mario Advance 4', 35.50, 12, '2003-10-17', 'GBA-2003-USA', 'mario@example.com', 8.9, 'PLATAFORMAS', 'https://m.media-amazon.com/images/I/81kN3ZgSSGL._AC_SY879_.jpg');

INSERT INTO videojuegos_retro (titulo, precio, stock, fecha_lanzamiento, codigo_serial, correo_proveedor, valoracion, categoria, url_imagen)
VALUES ('Metroid Fusion', 120.00, 1, '2002-11-22', 'GBA-2002-EUR', 'samus@example.com', 9.6, 'ACCION', 'https://m.media-amazon.com/images/I/71B+DjKegPL._AC_SY879_.jpg');