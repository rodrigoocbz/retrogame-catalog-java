package es.upsa.dasi.videojuegosws.application.usecases.impl;

import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import es.upsa.dasi.videojuegosws.application.usecases.Delete;
import es.upsa.dasi.videojuegosws.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class DeleteImpl implements Delete {
    Repository repository;
    @Inject
    public  DeleteImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(long codigo) throws VideoJuegoNotFoundException {
        repository.delete(codigo);
    }
}
