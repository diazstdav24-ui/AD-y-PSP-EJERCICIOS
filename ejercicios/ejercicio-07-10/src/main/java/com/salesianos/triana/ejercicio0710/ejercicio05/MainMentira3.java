package com.salesianos.triana.ejercicio0710.ejercicio05;

import com.salesianos.triana.ejercicio0710.ejercicio05.dto.SerieDTO;
import com.salesianos.triana.ejercicio0710.ejercicio05.model.Categoria;
import com.salesianos.triana.ejercicio0710.ejercicio05.model.Creador;
import com.salesianos.triana.ejercicio0710.ejercicio05.model.Serie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainMentira3 {

    @PostConstruct
    public void main() {

        Creador creador1 = Creador.builder()
                .id(1L)
                .nombre("Vince")
                .apellidos("Gilligan")
                .pais("Estados Unidos")
                .build();

        Categoria categoria1 = Categoria.builder()
                .id(1L)
                .nombre("Drama")
                .descripcion("Series de tono dramático")
                .build();

// 1. Serie completa
        Serie completa = Serie.builder()
                .id(1L)
                .titulo("Breaking Bad")
                .sinopsis("Un profesor de química se mete en el narcotráfico")
                .numeroTemporadas(5)
                .creador(creador1)
                .categoria(categoria1)
                .imagenes(List.of("bb1.jpg", "bb2.jpg"))
                .build();

// 2. Sin categoría
        Serie sinCategoria = Serie.builder()
                .id(2L)
                .titulo("Better Call Saul")
                .sinopsis("Los inicios de un abogado")
                .numeroTemporadas(6)
                .creador(creador1)
                .categoria(null)
                .imagenes(List.of("bcs1.jpg"))
                .build();

// 3. Sin imágenes (lista null)
        Serie sinImagenes = Serie.builder()
                .id(3L)
                .titulo("El Ministerio del Tiempo")
                .sinopsis("Agentes que viajan por la historia de España")
                .numeroTemporadas(3)
                .creador(creador1)
                .categoria(categoria1)
                .imagenes(null)
                .build();

// 4. Lista de imágenes vacía
        Serie imagenesVacias = Serie.builder()
                .id(4L)
                .titulo("La Casa de Papel")
                .sinopsis("Un atraco a la Fábrica de Moneda")
                .numeroTemporadas(5)
                .creador(creador1)
                .categoria(categoria1)
                .imagenes(List.of())
                .build();

        System.out.println(SerieDTO.of(completa));
        System.out.println(SerieDTO.of(sinCategoria));
        System.out.println(SerieDTO.of(sinImagenes));
        System.out.println(SerieDTO.of(imagenesVacias));
        System.out.println(SerieDTO.of(null)); // 5. Llamada con null

    }
}
