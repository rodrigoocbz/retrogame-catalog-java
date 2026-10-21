package es.upsa.dasi.videojuegosws.adapter.rest;

import es.upsa.dasi.adapter.rest.VideojuegoDto;
import es.upsa.dasi.adapter.rest.VideojuegoShortDto;
import es.upsa.dasi.domain.exceptions.VideoJuegoNotFoundException;
import es.upsa.dasi.domain.model.VideoJuego;
import es.upsa.dasi.videojuegosws.adapter.rest.dto.VideojuegoPostRequest;
import es.upsa.dasi.videojuegosws.adapter.rest.dto.VideojuegoPutRequest;
import es.upsa.dasi.videojuegosws.adapter.rest.mapper.ResponseMapper;
import es.upsa.dasi.videojuegosws.application.usecases.*;
import es.upsa.dasi.videojuegosws.domain.AddVideojuegoCommand;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("/videojuegos")
public class VideojuegoResource {
    ResponseMapper mapper;
    Validator validator;
    AddVideojuego addVideojuego;
    GetAll getAll;
    GetById getById;
    Replace replace;
    Delete delete;

    @Inject
    public VideojuegoResource(ResponseMapper mapper,Validator validator,AddVideojuego addVideojuego,GetAll getAll,GetById getById,Replace replace,Delete delete) {
        this.mapper = mapper;
        this.validator = validator;
        this.addVideojuego = addVideojuego;
        this.getAll = getAll;
        this.getById = getById;
        this.replace = replace;
        this.delete = delete;



    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<VideoJuego> execute = getAll.execute();
        List<VideojuegoShortDto> videojuegoShortDtos = execute.stream().map(mapper::toVideojuegoShortDto).toList();
        return Response.ok().entity(videojuegoShortDtos).build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideojuego(@PathParam("codigo") Long codigo) throws VideoJuegoNotFoundException {
        Optional<VideoJuego> optionalVideoJuego = getById.execute(codigo);
        return optionalVideoJuego.map(mapper::toVideojuegoDto)
                .map(videojuegoDto -> Response.ok().entity(videojuegoDto).build())
                .orElseThrow(VideoJuegoNotFoundException::new);

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createVideojuego(@Valid @NotNull VideojuegoPostRequest videojuegoPostRequest, @Context UriInfo uriInfo) {
        Set<ConstraintViolation<VideojuegoPostRequest>> violations = validator.validate(videojuegoPostRequest);
        if (!violations.isEmpty()) throw  new ConstraintViolationException(violations);

        AddVideojuegoCommand command = mapper.toAddVideoJuegoCommand(videojuegoPostRequest);
        VideoJuego videoJuego = addVideojuego.execute(command);
        VideojuegoDto videojuegoDto = mapper.toVideojuegoDto(videoJuego);
        return Response.created(uriInfo.getBaseUriBuilder()
                .path("/videojuegos/{codigo}")
                .resolveTemplate("codigo",videojuegoDto.getCodigo())
                .build())
                .entity(videojuegoDto)
                .build();

    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("codigo") long codigo, @Valid @NotNull VideojuegoPutRequest videojuegoPutRequest) throws  VideoJuegoNotFoundException {
        try{
            replace.execute(codigo,mapper.toReplaceVideojuegoCommand(videojuegoPutRequest));
        }catch (VideoJuegoNotFoundException e){
            throw  new VideoJuegoNotFoundException();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{codigo}")
    public  Response delete(@PathParam("codigo") Long codigo) throws VideoJuegoNotFoundException {
        try{
            delete.execute(codigo);
        }catch (VideoJuegoNotFoundException e){
            throw   new VideoJuegoNotFoundException();
        }
        return  Response.noContent().build();
    }
}
