package es.upsa.dasi.videojuegosws.domain;

import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import es.upsa.dasi.domain.model.VideoJuego;

import java.util.List;
import java.util.Optional;

public interface Repository {
    VideoJuego addVideojuego(VideoJuego videojuego);
    List<VideoJuego> findAll();
    Optional<VideoJuego> findById(long codigo);
    VideoJuego updateVideojuego(VideoJuego videojuego) throws VideoJuegoNotFoundException;
    void delete(long codigo) throws VideoJuegoNotFoundException;
}
