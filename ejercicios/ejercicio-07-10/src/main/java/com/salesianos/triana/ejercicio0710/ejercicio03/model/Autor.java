package com.salesianos.triana.ejercicio0710.ejercicio03.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autor {

    private Long id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nacionalidad;


}
