package es.upsa.dasi.videojuegosws.application.usecases.impl;

import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.application.usecases.Replace;
import es.upsa.dasi.videojuegosws.application.usecases.mapper.UseCaseMapper;
import es.upsa.dasi.videojuegosws.domain.ReplaceVideojuegoCommand;
import es.upsa.dasi.videojuegosws.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ReplaceImpl implements Replace {
    Repository repository;
    UseCaseMapper mapper;
    @Inject
    public  ReplaceImpl(Repository repository, UseCaseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VideoJuego execute(long codigo, ReplaceVideojuegoCommand command) throws VideoJuegoNotFoundException {
        return repository.updateVideojuego(mapper.toVidepJuego(command,codigo));
    }
}
