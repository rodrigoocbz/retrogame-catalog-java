package es.upsa.dasi.videojuegosws.application.usecases;

import es.upsa.dasi.domain.model.VideoJuego;

import java.util.Optional;

public interface GetById {
    Optional<VideoJuego> execute(long codigo);
}
