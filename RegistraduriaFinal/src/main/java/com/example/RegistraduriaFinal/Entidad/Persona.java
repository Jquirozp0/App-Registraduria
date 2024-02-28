package com.example.RegistraduriaFinal.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String id;
    private String primerNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private String tipoDocumento;
    private String nombrePadre;
    private String apellidoPadre;
    private String apellido2Padre;
    private String nombreMadre;
    private String apellidoMadre;
    private String apellido2Madre;

    public String toString() {
        return "Identificacion:" + id + ",Nombre:" + primerNombre + ",Apellido 1:" + primerApellido + ",Apellido 2:" + segundoApellido +
                ",Fecha de Nacimiento:" + fechaNacimiento + ",Tipo de Documento:" + tipoDocumento +
                ",Nombre del Padre: " + nombrePadre + ",Apellido 1 del Padre:" + apellidoPadre +
                ",Apellido 2 del Padre: " + apellido2Padre + ",Nombre de la Madre:" + nombreMadre +
                ",Apellido 1 de la Madre: " + apellidoMadre + ",Apellido 2 de la Madre:" + apellido2Madre;
    }
}
