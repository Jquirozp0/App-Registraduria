package com.example.RegistraduriaFinal.Repositorio;

import com.example.RegistraduriaFinal.Entidad.Persona;

import java.time.LocalDate;
import java.util.List;

public interface RegistroRepositorio {
    void agregarRegistro(String id, String nombre1, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String tipoDocumento, String nombrePadre, String apellido1Padre, String apellido2Padre, String nombreMadre, String apellido1Madre, String apellido2Madre);
    String leerRegistro(String nombreArchivo);
    void modificarRegistro(String ID);
    void eliminarRegistro(String ID);
}
