package es.upsa.dasi.videojuegosws.adapter.rest.mapper;


import es.upsa.dasi.adapter.rest.VideojuegoDto;
import es.upsa.dasi.adapter.rest.VideojuegoShortDto;
import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.adapter.rest.dto.VideojuegoPostRequest;
import es.upsa.dasi.videojuegosws.adapter.rest.dto.VideojuegoPutRequest;
import es.upsa.dasi.videojuegosws.domain.AddVideojuegoCommand;
import es.upsa.dasi.videojuegosws.domain.ReplaceVideojuegoCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface ResponseMapper {
    VideojuegoShortDto toVideojuegoShortDto(VideoJuego videoJuego);
    VideojuegoDto toVideojuegoDto(VideoJuego videoJuego);
    AddVideojuegoCommand toAddVideoJuegoCommand(VideojuegoPostRequest videojuegoPostRequest);
    ReplaceVideojuegoCommand toReplaceVideojuegoCommand(VideojuegoPutRequest videojuegoPutRequest);
}
