package com.example.RegistraduriaFinal.Controlador;
import com.example.RegistraduriaFinal.Servicio.RegistroService;
import com.example.RegistraduriaFinal.Utilidad.ArchivoUtilidad;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class RegistroController {
    private RegistroService registroService;
    private ArchivoUtilidad archivoUtilidad;

    //constructor
    public RegistroController() {
        this.archivoUtilidad = new ArchivoUtilidad();
        this.registroService = new RegistroService();
    }

    public void ingresarNuevoRegistro(int tipo, String nombre1, String apellido1, String apellido2,
                                      LocalDate fechaNacimiento, String nombrePadre, String apellido1Padre, String apellido2Padre,
                                      String nombreMadre, String apellido1Madre, String apellido2Madre) {

        archivoUtilidad.asignarApellidos(tipo, apellido1Padre, apellido2Padre, apellido1Madre, apellido2Madre);
        String primerApellido = archivoUtilidad.getPrimerApellido();
        String segundoApellido = archivoUtilidad.getSegundoApellido();
        String tipoDoc = archivoUtilidad.asignarTipoDocumento(fechaNacimiento);
        String ID = archivoUtilidad.generarId();
        registroService.agregarRegistro(ID, nombre1, primerApellido, segundoApellido, fechaNacimiento, tipoDoc, nombrePadre, apellido1Padre, apellido2Padre, nombreMadre, apellido1Madre, apellido2Madre);
        registroService.generarRegistroArch();
    }
    public void consultarRegistros() {
        String leerRegistro = registroService.leerRegistro("registros.txt");
        JTextArea textArea = new JTextArea(leerRegistro);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Registros", JOptionPane.PLAIN_MESSAGE);
    }
    public void modificarRegistros(String ID) {

       registroService.modificarRegistro(ID);
    }
    public void eliminarRegistros(String ID) {
        if (registroService.validarID(ID)) {
            registroService.eliminarRegistro(ID);
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El ID proporcionado no corresponde a ningún registro.");
        }
    }
}
