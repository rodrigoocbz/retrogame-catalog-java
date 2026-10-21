package es.upsa.dasi.videojuegosws.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideojuegoRow {
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
