package es.upsa.dasi.videojuegosws.application.usecases.impl;

import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.application.usecases.AddVideojuego;
import es.upsa.dasi.videojuegosws.application.usecases.mapper.UseCaseMapper;
import es.upsa.dasi.videojuegosws.domain.AddVideojuegoCommand;
import es.upsa.dasi.videojuegosws.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;

@ApplicationScoped
public class AddVideoJuegoImpl implements AddVideojuego {


    Repository repository;
    UseCaseMapper useCaseMapper;
    @Inject

    public AddVideoJuegoImpl(Repository repository, UseCaseMapper useCaseMapper) {
        this.repository = repository;
        this.useCaseMapper = useCaseMapper;
    }

    @Override
    public VideoJuego execute(AddVideojuegoCommand command) {
        return repository.addVideojuego(useCaseMapper.toVideojuego(command));
    }

}
