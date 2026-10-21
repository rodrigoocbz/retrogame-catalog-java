package es.upsa.dasi.videojuegosweb.adapter.controller.dto;

import es.upsa.dasi.videojuegosweb.infrastructure.url.Url;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.*;
import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideojuegoForm {

    @FormParam("codigo")
    Long codigo;

    @Size(min = 1, max = 100)
    @NotBlank
    @MvcBinding
    @FormParam("titulo")
    String titulo;

    @Min(1)
    @Max(1500)
    @Digits(integer = 4, fraction = 2)
    @NotNull
    @MvcBinding
    @FormParam("precio")
    double precio;

    @PositiveOrZero
    @NotNull
    @Max(99)
    @MvcBinding
    @FormParam("stock")
    int stock;

    @NotNull
    @MvcBinding
    @FormParam("fechaLanzamiento")
    String fechaLanzamiento;


    @NotBlank
    @Size(min = 1, max = 12)
    @MvcBinding
    @FormParam("codigoSerial")
    @Pattern(regexp = "[A-Z]{3}-[0-9]{4}-[A-Z]{3}")
    String codigoSerial;

    @Size(min = 1, max = 100)
    @NotBlank
    @Email
    @MvcBinding
    @FormParam("correoProveedor")
    String correoProveedor;

    @Digits(integer = 2, fraction = 1)
    @NotNull
    @Min(0)
    @Max(10)
    @MvcBinding
    @FormParam("valoracion")
    double valoracion;

    @NotBlank
    @Size(min = 1, max = 20)
    @Pattern(regexp = "PLATAFORMAS|RPG|ACCION|AVENTURA")
    @MvcBinding
    @FormParam("categoria")
    String categoria;

    @Size(min = 1, max = 500)
    @NotBlank
    @Url
    @MvcBinding
    @FormParam("urlImagen")
    String urlImagen;
}
