package com.example.RegistraduriaFinal.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaDto implements Serializable {

    private Long id;
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

}