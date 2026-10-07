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
                //Aqui le digo que si es diferente de null que coja el nombre y los apellidos, si no que lance ese msj
                l.getAutor() != null ? l.getAutor().getNombre() + " " + l.getAutor().formatearApellidos() :
                        "Autor desconocido",
                l.getAnioPublicacion()
        );


    }



}
