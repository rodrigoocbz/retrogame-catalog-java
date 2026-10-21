package es.upsa.dasi.adapter.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VideojuegoShortDto {
    private long codigo;
    private String titulo;
    private String urlImagen;
}
