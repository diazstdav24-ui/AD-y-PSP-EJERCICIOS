package com.salesianos.triana.ejercicio0710.ejercicio05.dto;

import com.salesianos.triana.ejercicio0710.ejercicio05.model.Serie;
import org.springframework.util.CollectionUtils;

public record SerieDTO(

        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal

) {

    public static SerieDTO of(Serie s){

        if (s == null){

            return null;

        }

        return new SerieDTO(

                s.getTitulo(),
                s.getNumeroTemporadas(),
                s.getCreador() != null ? s.getCreador().getNombre() + " "+ s.getCreador().getApellidos() : "Sin creador" ,
                s.getCategoria() != null ? s.getCategoria().getNombre() : "No tiene categoría",
                CollectionUtils.isEmpty(s.getImagenes()) ? "Sin imagen" : s.getImagenes().get(0)
        );
    }







}
