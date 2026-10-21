package es.upsa.dasi.videojuegosws.adapter.rest.provider;


import es.upsa.dasi.adapter.rest.ErrorDto;
import es.upsa.dasi.domain.exceptions.VideoJuegoRunTimeException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class VideojuegoRunTimeExceptionMapper implements ExceptionMapper<VideoJuegoRunTimeException> {
    @Override
    public Response toResponse(VideoJuegoRunTimeException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ErrorDto.builder().message("No se pudo completar la operación")
                        .status("500").build()).build();
    }
}
