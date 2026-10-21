package es.upsa.dasi.videojuegosws.adapter.rest.provider;

import es.upsa.dasi.adapter.rest.ErrorDto;
import es.upsa.dasi.domain.exceptions.VideoJuegoException;
import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class VideojuegoExceptionMapper implements ExceptionMapper<VideoJuegoException> {
    @Override
    public Response toResponse(VideoJuegoException exception) {
        return switch (exception){
            case VideoJuegoNotFoundException notFoundException -> Response.status(Response.Status.NOT_FOUND)
                    .entity(ErrorDto.builder().message(notFoundException.getMessage()).build()).build();
            default ->  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorDto.builder().message(exception.getMessage()).build()).build();
        };
    }
}
