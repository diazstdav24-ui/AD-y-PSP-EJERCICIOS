package com.salesianos.triana.ejercicio0710.ejercicio4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    private Long id;

    private String codigo;
    private int numeroNoches;

    private Cliente cliente;
    private Habitacion habitacion;


}
