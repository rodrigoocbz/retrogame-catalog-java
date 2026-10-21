package es.upsa.dasi.adapter.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VideojuegoDto {
    Long codigo;
    String titulo;
    double precio;
    int stock;
    LocalDate fechaLanzamiento;
    String codigoSerial;
    String correoProveedor;
    double valoracion;
    String categoria;
    String urlImagen;
}
