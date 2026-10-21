package es.upsa.dasi.videojuegosws.application.usecases.mapper;


import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.adapter.rest.dto.VideojuegoPostRequest;
import es.upsa.dasi.videojuegosws.domain.AddVideojuegoCommand;
import es.upsa.dasi.videojuegosws.domain.ReplaceVideojuegoCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface UseCaseMapper {
    VideoJuego toVideojuego(AddVideojuegoCommand command);

    @Mapping(target = "codigo",source = "codigo")
    @Mapping(target = ".",source = "command")

VideoJuego toVidepJuego(ReplaceVideojuegoCommand command, long codigo);

}
