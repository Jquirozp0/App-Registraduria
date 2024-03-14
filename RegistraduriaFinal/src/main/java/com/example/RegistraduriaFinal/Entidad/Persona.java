package com.example.RegistraduriaFinal.Entidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Persona")
@Table(name = "PERSONAS")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONAS")
    @SequenceGenerator(name = "SEQ_PERSONAS", sequenceName = "SEQ_PERSONAS", allocationSize = 1)

    @Column(name = "PER_ID")
    private Long id;
    @Column(name = "PER_PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "PER_PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "PER_SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "PER_FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;
    @Column(name = "PER_TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "PER_NOMBRE_PADRE")
    private String nombrePadre;
    @Column(name = "PER_APELLIDO_PADRE")
    private String apellidoPadre;
    @Column(name = "PER_APELLIDO2_PADRE")
    private String apellido2Padre;
    @Column(name = "PER_NOMBRE_MADRE")
    private String nombreMadre;
    @Column(name = "PER_APELLIDO_MADRE")
    private String apellidoMadre;
    @Column(name = "PER_APELLIDO2_MADRE")
    private String apellido2Madre;

}
