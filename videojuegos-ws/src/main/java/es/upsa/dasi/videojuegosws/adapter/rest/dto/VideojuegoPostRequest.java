package es.upsa.dasi.videojuegosws.adapter.rest.dto;

import es.upsa.dasi.videojuegosws.infrastructure.validation.Url;
import jakarta.validation.constraints.*;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideojuegoPostRequest {
    @Size(min = 1,max = 100)
    @NotBlank
    String titulo;

    @Min(1)
    @Max(1500)
    @Digits(integer = 4,fraction = 2)
    @NotNull
    Double precio;

    @PositiveOrZero
    @NotNull
    @Max(99)
    Integer stock;

    @NotNull
    LocalDate fechaLanzamiento;

    @NotBlank
    @Size(min = 1,max = 12)
    @Pattern(regexp = "[A-Z]{3}-[0-9]{4}-[A-Z]{3}")
    String codigoSerial;

    @Size(min = 1, max = 100)
    @NotBlank
    @Email
    String correoProveedor;

    @Digits(integer = 2, fraction = 1)
    @NotNull
    @Min(0)
    @Max(10)
    Double valoracion;

    @NotBlank
    @Size(min = 1, max = 20)
    @Pattern(regexp = "PLATAFORMAS|RPG|ACCION|AVENTURA")
    String categoria;

    @Size(min = 1, max = 500)
    @NotBlank
    @Url
    String urlImagen;
}
