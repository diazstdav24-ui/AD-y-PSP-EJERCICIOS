package com.salesianos.triana.ejercicio0710.ejercicio03;

import com.salesianos.triana.ejercicio0710.ejercicio03.Dtos.LibroDTO;
import com.salesianos.triana.ejercicio0710.ejercicio03.model.Autor;
import com.salesianos.triana.ejercicio0710.ejercicio03.model.Libro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MainMentira {

    @PostConstruct
    public void main() {


        Autor autor1 =  Autor.builder()
                            .id(1L)
                            .nombre("Franz")
                            .apellido1("Kafka")
                            .apellido2("")
                            .nacionalidad("Checo")
                            .build();


        Autor autor2 =  Autor.builder()
                .id(2L)
                .nombre("Federico")
                .apellido1("García")
                .apellido2("Lorca")
                .nacionalidad("Español")
                .build();

        Autor autor3 = Autor.builder()
                .id(3L)
                .nombre("Carlos")
                .apellido1("Ruíz")
                .apellido2("Zafón")
                .nacionalidad("Español")
                .build();

        Libro libro1 = Libro.builder()
                .id(1L)
                .titulo("La metamorfosis")
                .isbn("978-0-00-000001-1")
                .anioPublicacion(1915)
                .numeroPaginas(96)
                .autor(autor1)
                .build();

        Libro libro2 = Libro.builder()
                .id(2L)
                .titulo("Bodas de sangre")
                .isbn("978-0-00-000002-2")
                .anioPublicacion(1933)
                .numeroPaginas(120)
                .autor(autor2)
                .build();

        Libro libro3 = Libro.builder()
                .id(3L)
                .titulo("El Cantar del Mio Cid")
                .isbn("978-0-00-000003-3")
                .anioPublicacion(1207)
                .numeroPaginas(576)
                .autor(null)
                .build();


        System.out.print(LibroDTO.of(libro1));
        System.out.print(LibroDTO.of(libro2));
        System.out.print(LibroDTO.of(libro3));







    }
}
