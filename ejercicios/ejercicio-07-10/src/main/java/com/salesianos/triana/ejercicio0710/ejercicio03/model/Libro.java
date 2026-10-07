package com.salesianos.triana.ejercicio0710.ejercicio03.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {


    private Long id;

    private String titulo;
    private String isbn;

    private int anioPublicacion;
    private int numeroPaginas;

    private Autor autor;

}
