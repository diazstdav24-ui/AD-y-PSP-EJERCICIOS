package com.salesianos.triana.ejercicio0710.ejercicio05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Creador {

    private Long id;

    private String nombre;
    private String apellidos;
    private String pais;
}