package com.salesianos.triana.ejercicio0710.ejercicio4;

import com.salesianos.triana.ejercicio0710.ejercicio4.Dtos.ReservaDTO;
import com.salesianos.triana.ejercicio0710.ejercicio4.model.Cliente;
import com.salesianos.triana.ejercicio0710.ejercicio4.model.Habitacion;
import com.salesianos.triana.ejercicio0710.ejercicio4.model.Reserva;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MainMentira2 {

    @PostConstruct
    public void main() {

    Cliente cl1 = Cliente.builder()
            .nombre("Jeronimo")
            .apellidos("Stilton gonzales")
            .tlf("1234")
            .email("qqqqq")
            .build();



        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nombre("Lucía")
                .apellidos("Moreno Díaz")
                .email("lucia@mail.com")
                .tlf("600111222")
                .build();

        Habitacion hab1 = Habitacion.builder()
                .id(1L)
                .numero("101")
                .tipo("Doble")
                .precioNoche(80.0)
                .planta(1)
                .build();

        Habitacion habSinPrecio = Habitacion.builder()
                .id(2L)
                .numero("202")
                .tipo("Individual")
                .precioNoche(1.2)
                .planta(2)
                .build();

// 1. Reserva completa
        Reserva completa = Reserva.builder()
                .id(1L).codigo("R-001").numeroNoches(3)
                .cliente(cliente1).habitacion(hab1)
                .build();

// 2. Sin cliente
        Reserva sinCliente = Reserva.builder()
                .id(2L).codigo("R-002").numeroNoches(2)
                .cliente(null).habitacion(hab1)
                .build();

// 3. Sin habitación
        Reserva sinHabitacion = Reserva.builder()
                .id(3L).codigo("R-003").numeroNoches(2)
                .cliente(cliente1).habitacion(null)
                .build();

// 4. Sin número de noches
        Reserva sinNoches = Reserva.builder()
                .id(4L).codigo("R-004").numeroNoches(2)
                .cliente(cliente1).habitacion(hab1)
                .build();

// 5. Habitación sin precio
        Reserva sinPrecio = Reserva.builder()
                .id(5L).codigo("R-005").numeroNoches(4)
                .cliente(cliente1).habitacion(habSinPrecio)
                .build();

        System.out.println(ReservaDTO.of(completa));
        System.out.println(ReservaDTO.of(sinCliente));
        System.out.println(ReservaDTO.of(sinHabitacion));
        System.out.println(ReservaDTO.of(sinNoches));
        System.out.println(ReservaDTO.of(sinPrecio));
        System.out.println(ReservaDTO.of(null)); // 6. Reserva null



    }
}
