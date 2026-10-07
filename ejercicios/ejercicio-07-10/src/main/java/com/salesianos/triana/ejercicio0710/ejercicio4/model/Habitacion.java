package com.salesianos.triana.ejercicio0710.ejercicio4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {


    private Long id;

    private String numero;

    private String tipo;
    private double precioNoche;

    private int planta;



}
