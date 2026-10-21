package es.upsa.dasi.videojuegosws.infrastructure;

import es.upsa.dasi.videojuegosws.infrastructure.dto.VideojuegoRow;

import java.util.List;
import java.util.Optional;

public interface Dao {
    VideojuegoRow insert(VideojuegoRow videojuegoRow);
    List<VideojuegoRow> getAll();
    Optional<VideojuegoRow> getById(long codigo);
    Optional<VideojuegoRow> updateGame(VideojuegoRow videojuegoRow);
    int delete(long codigo) ;
}
