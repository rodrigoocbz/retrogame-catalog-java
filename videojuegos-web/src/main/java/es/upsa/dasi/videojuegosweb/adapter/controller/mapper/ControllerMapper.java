package es.upsa.dasi.videojuegosweb.adapter.controller.mapper;

import es.upsa.dasi.adapter.rest.VideojuegoDto;
import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosweb.adapter.controller.dto.VideojuegoForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ControllerMapper {
    VideojuegoForm toVideojuegoform(VideojuegoDto videojuegoDto);
}
