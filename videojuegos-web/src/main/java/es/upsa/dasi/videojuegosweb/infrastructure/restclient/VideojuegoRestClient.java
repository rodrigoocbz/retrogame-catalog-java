package es.upsa.dasi.videojuegosweb.infrastructure.restclient;


import es.upsa.dasi.adapter.rest.VideojuegoDto;
import es.upsa.dasi.adapter.rest.VideojuegoShortDto;
import es.upsa.dasi.videojuegosweb.adapter.controller.dto.VideojuegoForm;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "rest.videojuegos.url")
public interface VideojuegoRestClient {


    @GET
    @Path("/videojuegos")
    @Produces(MediaType.APPLICATION_JSON)
    List<VideojuegoShortDto> fetchAll();

    @GET
    @Path("/videojuegos/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    VideojuegoDto fetchVideojuego(@PathParam("codigo") long codigo);

    @POST
    @Path("/videojuegos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    VideojuegoDto addVideojuego(VideojuegoForm form);

    @PUT
    @Path("/videojuegos/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void update(@PathParam("codigo") long codigo,VideojuegoForm form);

    @DELETE
    @Path("/videojuegos/{codigo}")
    void delete(@PathParam("codigo") long codigo);
}
