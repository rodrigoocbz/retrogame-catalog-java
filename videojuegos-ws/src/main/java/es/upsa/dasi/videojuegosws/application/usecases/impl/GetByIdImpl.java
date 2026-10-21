package es.upsa.dasi.videojuegosws.application.usecases.impl;

import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.application.usecases.GetById;
import es.upsa.dasi.videojuegosws.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class GetByIdImpl implements GetById {
    Repository repository;
    @Inject
    public  GetByIdImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<VideoJuego> execute(long codigo) {
        return repository.findById(codigo);
    }
}
