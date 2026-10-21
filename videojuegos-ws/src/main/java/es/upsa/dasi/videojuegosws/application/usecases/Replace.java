package es.upsa.dasi.videojuegosws.application.usecases;

import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.domain.ReplaceVideojuegoCommand;

public interface Replace {
   VideoJuego execute(long codigo, ReplaceVideojuegoCommand command) throws VideoJuegoNotFoundException;
}
