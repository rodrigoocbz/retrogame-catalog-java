package es.upsa.dasi.videojuegosws.application.usecases.impl;

import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.application.usecases.GetAll;
import es.upsa.dasi.videojuegosws.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetAllImpl implements GetAll {


    Repository repository;
    @Inject
    public  GetAllImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<VideoJuego> execute() {
        return repository.findAll();
    }
}
