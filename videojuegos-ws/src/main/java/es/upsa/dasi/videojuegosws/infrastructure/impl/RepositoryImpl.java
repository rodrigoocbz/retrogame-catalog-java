package es.upsa.dasi.videojuegosws.infrastructure.impl;

import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.domain.Repository;
import es.upsa.dasi.videojuegosws.infrastructure.Dao;
import es.upsa.dasi.videojuegosws.infrastructure.mapper.DaoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositoryImpl implements Repository {
    Dao dao;
    DaoMapper daoMapper;

    @Inject
    public RepositoryImpl(Dao dao, DaoMapper daoMapper) {
        this.dao = dao;
        this.daoMapper = daoMapper;
    }



    @Override
    public VideoJuego addVideojuego(VideoJuego videojuego) {
        return daoMapper.toVideoJuego(dao.insert(daoMapper.toVideojuegoRow(videojuego)));
    }

    @Override
    public List<VideoJuego> findAll() {
        return dao.getAll().stream().map(daoMapper::toVideoJuego).toList();
    }

    @Override
    public Optional<VideoJuego> findById(long codigo) {
        return dao.getById(codigo).map(daoMapper::toVideoJuego);
    }

    @Override
    public VideoJuego updateVideojuego(VideoJuego videojuego) throws VideoJuegoNotFoundException {
        return dao.updateGame(daoMapper.toVideojuegoRow(videojuego))
                .map(daoMapper::toVideoJuego)
                .orElseThrow(VideoJuegoNotFoundException::new);
    }

    @Override
    public void delete(long codigo) throws VideoJuegoNotFoundException {
        dao.delete(codigo);
    }
}
