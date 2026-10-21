package es.upsa.dasi.videojuegosweb.adapter.controller;


import es.upsa.dasi.adapter.rest.VideojuegoDto;
import es.upsa.dasi.videojuegosweb.adapter.controller.dto.Action;
import es.upsa.dasi.videojuegosweb.adapter.controller.dto.VideojuegoForm;
import es.upsa.dasi.videojuegosweb.adapter.controller.mapper.ControllerMapper;
import es.upsa.dasi.videojuegosweb.infrastructure.restclient.VideojuegoRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/formulario")
@ApplicationScoped
public class FormularioController {
    @Inject
    @RestClient
    VideojuegoRestClient videojuegoRestClient;

    @Inject
    Models models;

    @Inject
    ControllerMapper controllerMapper;

    @GET
    @Path("/insert")
    @Controller
    @View("/jsps/formulario/formulario.jsp")
    @UriRef("getFormularioInsert")
    public void getFormularioInsert(){
        models.put("action", Action.INSERT);
    }

    @GET
    @Path("/update/{codigo}")
    @Controller
    @View("/jsps/formulario/formulario.jsp")
    @UriRef("getFormularioUpdate")
    public void getFormularioUpdate(@PathParam("codigo") long codigo){
        VideojuegoDto videojuegoDto = videojuegoRestClient.fetchVideojuego(codigo);
        VideojuegoForm videojuegoForm = controllerMapper.toVideojuegoform(videojuegoDto);
        models.put("action", Action.UPDATE);
        models.put("form", videojuegoForm);
    }
    @GET
    @Path("/delete/{codigo}")
    @Controller
    @View("/jsps/formulario/formulario.jsp")
    @UriRef("getFormularioDelete")
    public void getFormularioDelete(@PathParam("codigo") long codigo){
        VideojuegoDto videojuegoDto = videojuegoRestClient.fetchVideojuego(codigo);
        VideojuegoForm videojuegoForm = controllerMapper.toVideojuegoform(videojuegoDto);
        models.put("action", Action.DELETE);
        models.put("form", videojuegoForm);
    }


}
