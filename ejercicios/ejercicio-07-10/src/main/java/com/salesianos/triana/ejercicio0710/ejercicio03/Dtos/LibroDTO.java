package com.salesianos.triana.ejercicio0710.ejercicio03.Dtos;

import com.salesianos.triana.ejercicio0710.ejercicio03.model.Libro;

public record LibroDTO(

        String titulo,
        String isbn,
        String autor,
        int anioPublicacion

) {


    public static LibroDTO of(Libro l){

        if (l == null){

            return null;
        }

        return new LibroDTO(

                l.getTitulo(),
                l.getIsbn(),
                l.getAutor() != null ? l.getAutor().getNombre() : null,
                l.getAnioPublicacion()
        );


    }



}
