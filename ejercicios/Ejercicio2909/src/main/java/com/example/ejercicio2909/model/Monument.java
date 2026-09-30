package com.example.ejercicio2909.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monument {

    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "^[A-Z]{2}$", message = "no valido")
    private String codigoPais;

    private String nombrePais;
    private String nombreCiudad;

    @Pattern(regexp = "^[-+]?\\d{1,2}(\\.\\d+)?,[-+]?\\d{1,3}(\\.\\d+)?$", message = "no valido")
    private String localizacion;

    private String nombreMonumento;
    private String descripcion;
    private String urlFoto;




}
