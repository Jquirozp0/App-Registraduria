package com.example.RegistraduriaFinal.Utilidad;
import com.example.RegistraduriaFinal.Entidad.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class ArchivoUtilidad {

    private String primerApellido;
    private String segundoApellido;

    public ArchivoUtilidad() {
    }

    public void asignarApellidos(int tipo, String apellido1Padre, String apellido2Padre, String apellido1Madre, String apellido2Madre) {
        switch (tipo) {
            case 0:
                primerApellido = apellido1Padre;
                segundoApellido = apellido1Madre;
                break;
            case 1:
                primerApellido = apellido1Padre;
                segundoApellido = apellido2Padre;
                break;
            case 2:
                primerApellido = apellido1Madre;
                segundoApellido = apellido2Madre;
                break;
        }
    }

    public String asignarTipoDocumento(LocalDate fechaNacimiento) {
        LocalDate hoy = LocalDate.now();
        int edad = Period.between(fechaNacimiento, hoy).getYears();
        if (edad < 7) {
            return "Registro Civil";
        } else if (edad >= 7 && edad < 18) {
            return "Tarjeta de Identidad";
        } else {
            return "Cédula de Ciudadanía";
        }
    }
    public long generarId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        // Genera 10 dígitos aleatorios
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10)); // Agrega un dígito aleatorio (0-9)
        }
        String idString = sb.toString();
        // Convierte la cadena a tipo long
        long id = Long.parseLong(idString);
        return id;
    }

    public static LocalDate obtenerFecha(String parte) {
        String[] split = parte.split(":");
        if (split.length == 2) {
            String fechaStr = split[1].trim();
            return LocalDate.parse(fechaStr);
        } else {
            System.out.println("Formato incorrecto en la parte: " + parte);
            return null;
        }
    }

}