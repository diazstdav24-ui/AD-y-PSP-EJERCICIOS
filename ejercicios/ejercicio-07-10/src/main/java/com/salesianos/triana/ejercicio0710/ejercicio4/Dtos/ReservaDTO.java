package com.salesianos.triana.ejercicio0710.ejercicio4.Dtos;

import com.salesianos.triana.ejercicio0710.ejercicio4.model.Reserva;

public record ReservaDTO(

        String codigo,
        String cliente,
        String habitacion,
        double precioTotal,
        int numeroNoches

) {


    public static ReservaDTO of(Reserva r){

        double total = 0.0;

        if (r == null){

            return null;
        }

        if (r.getHabitacion() != null) {

            total = r.getNumeroNoches() * r.getHabitacion().getPrecioNoche();
        }

        return new ReservaDTO(

                r.getCodigo(),
                r.getCliente() != null ? r.getCliente()
                                            .getNombre() + " " +
                                            r.getCliente().getApellidos() : "No hay nombre" ,
                r.getHabitacion() != null ? r.getHabitacion().getNumero() + "-" + r.getHabitacion().getTipo():
                "La habitación no se encuentra",
                total,
                r.getNumeroNoches()
        );


    }



}
