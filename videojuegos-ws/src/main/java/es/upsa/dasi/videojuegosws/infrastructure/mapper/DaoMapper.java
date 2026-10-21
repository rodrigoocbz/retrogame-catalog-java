package es.upsa.dasi.videojuegosws.infrastructure.mapper;

import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.infrastructure.dto.VideojuegoRow;
import jakarta.ws.rs.core.UriInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface DaoMapper {
    VideoJuego toVideoJuego(VideojuegoRow videojuegoRow);
    VideojuegoRow toVideojuegoRow(VideoJuego videojuego);
}
