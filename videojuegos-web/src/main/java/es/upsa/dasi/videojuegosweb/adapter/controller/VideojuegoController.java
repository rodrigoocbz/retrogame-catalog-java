package es.upsa.dasi.videojuegosweb.adapter.controller;


import es.upsa.dasi.adapter.rest.VideojuegoDto;
import es.upsa.dasi.adapter.rest.VideojuegoShortDto;
import es.upsa.dasi.videojuegosweb.adapter.controller.dto.Action;
import es.upsa.dasi.videojuegosweb.adapter.controller.dto.VideojuegoForm;
import es.upsa.dasi.videojuegosweb.infrastructure.restclient.VideojuegoRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.*;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.mvc.security.CsrfProtected;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/videojuegos")
@ApplicationScoped
public class VideojuegoController {
    @Inject
    @RestClient
    VideojuegoRestClient videojuegoRestClient;

    @Inject
    Models models;

    @Inject
    MvcContext mvcContext;

    @Inject
    BindingResult bindingResult;

    @GET
    @Controller
    @View("/jsps/videojuegos.jsp")
    @UriRef("getVideojuegos")
    public void getVideojuego(){
        List<VideojuegoShortDto> videojuegoShortDtos = videojuegoRestClient.fetchAll();
        models.put("videojuegos", videojuegoShortDtos);
    }

    @GET
    @Path("/{codigo}")
    @Controller
    @View("/jsps/videojuego.jsp")
    @UriRef("getVideojuego")
    public String getVideojuego(@PathParam("codigo") long codigo){
        try{
            VideojuegoDto videojuegoDto = videojuegoRestClient.fetchVideojuego(codigo);
            models.put("videojuego", videojuegoDto);
            return "/jsps/videojuego.jsp";
        }catch (Exception e){
            models.put("error", codigo);
            return "/jsps/errores/errores.jsp";
        }
    }

    @POST
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @CsrfProtected
    @UriRef("insertVideojuego")
    public Response insertVideojuego(@BeanParam @Valid VideojuegoForm form) {
        if (bindingResult.isFailed()){
            Set<ParamError> allerrors = bindingResult.getAllErrors();
            Map<String, List<String>> errores = allerrors.stream()
                    .collect(Collectors.groupingBy(ParamError::getParamName,
                            Collectors.mapping(ParamError::getMessage,Collectors.toList())));

            models.put("action", Action.INSERT);
            models.put("errores", errores);
            models.put("form", form);
            return Response.ok().entity("/jsps/formulario/formulario.jsp").build();
        }
        VideojuegoDto videojuegoDto = videojuegoRestClient.addVideojuego(form);
        URI uri = mvcContext.uri("getVideojuego",Map.of("codigo",videojuegoDto.getCodigo()));
        return Response.seeOther(uri).build();
    }


    @PUT
    @Path("/{codigo}")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @CsrfProtected
    @UriRef("updateVideojuego")
    public Response updateVideojuego(@BeanParam @Valid VideojuegoForm form,@PathParam("codigo")long codigo) {
        if (bindingResult.isFailed()){
            Set<ParamError> allerrors = bindingResult.getAllErrors();
            Map<String , List<String>> errores = allerrors.stream()
                    .collect(Collectors.groupingBy(ParamError::getParamName,Collectors.mapping(ParamError::getMessage,Collectors.toList())));
            models.put("action",Action.UPDATE);
            models.put("errores", errores);
            models.put("form", form);
            return  Response.ok().entity("/jsps/formulario/formulario.jsp").build();
        }
        videojuegoRestClient.update(codigo,form);
        URI uri = mvcContext.uri("getVideojuego",Map.of("codigo",codigo));
        return  Response.seeOther(uri).build();
    }

    @DELETE
    @Path("/{codigo}")
    @Controller
    @CsrfProtected
    @UriRef("deleteGame")
    public Response deleteGame(@PathParam("codigo") long codigo) {
        videojuegoRestClient.delete(codigo);
        URI uri = mvcContext.uri("getVideojuegos");
        return  Response.seeOther(uri).build();
    }
}
