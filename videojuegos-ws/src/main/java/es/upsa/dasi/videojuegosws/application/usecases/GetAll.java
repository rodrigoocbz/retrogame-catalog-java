package es.upsa.dasi.videojuegosws.application.usecases;

import es.upsa.dasi.domain.model.VideoJuego;

import java.util.List;

public interface GetAll {
    List<VideoJuego> execute();
}
