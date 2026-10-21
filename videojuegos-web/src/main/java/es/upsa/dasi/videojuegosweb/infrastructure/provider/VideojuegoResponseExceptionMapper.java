package es.upsa.dasi.videojuegosweb.infrastructure.provider;

import es.upsa.dasi.adapter.rest.ErrorDto;
import es.upsa.dasi.domain.exceptions.VideoJuegoException;
import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class VideojuegoResponseExceptionMapper implements ResponseExceptionMapper<VideoJuegoException> {


    @Override
    public VideoJuegoException toThrowable(Response response) {
        return switch (response.getStatusInfo().toEnum()){
            case NOT_FOUND -> new VideoJuegoNotFoundException(response.readEntity(String.class));
            default ->  new VideoJuegoException(response.readEntity(ErrorDto.class).getMessage());
        };
    }
}
