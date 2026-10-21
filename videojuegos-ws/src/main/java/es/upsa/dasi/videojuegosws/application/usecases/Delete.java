package es.upsa.dasi.videojuegosws.application.usecases;

import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;

public interface Delete {
    void execute(long codigo) throws VideoJuegoNotFoundException;
}
