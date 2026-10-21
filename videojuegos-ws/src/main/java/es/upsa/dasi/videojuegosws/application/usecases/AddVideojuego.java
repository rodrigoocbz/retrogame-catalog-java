package es.upsa.dasi.videojuegosws.application.usecases;

import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.domain.AddVideojuegoCommand;

public interface AddVideojuego {
    VideoJuego execute(AddVideojuegoCommand command);
}
