package com.example.RegistraduriaFinal.Vista;
import com.example.RegistraduriaFinal.Controlador.RegistroController;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RegistroControllerInterface extends JFrame {
    private RegistroController registroController;
    private Scanner scanner;
    public RegistroControllerInterface() {
        this.scanner = new Scanner(System.in);
        this.registroController = new RegistroController();
    }
    public void mostrarMenu() {
        String nombre1 = null;
        String apellido1 = null;
        String apellido2 = null;
        String nombrePadre = null;
        String apellido1Padre = null;
        String apellido2Padre = null;
        String nombreMadre = null;
        String apellido1Madre = null;
        String apellido2Madre = null;
        LocalDate fechaNacimiento = null;

        String[] opciones = {"Agregar Nuevo Niño", "Consultar Registros", "Modificar Registro","Eliminar Registro", "Salir"};
        String[] opcionesNiño = {"Ambos padres", "Solo padre", "Solo madre", "Salir"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción:",
                "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opciones, opciones[0]);

        switch (opcionSeleccionada) {
            case 0:
                nombre1 = JOptionPane.showInputDialog("Ingrese el nombre1 del niño:");
                while (fechaNacimiento == null) {
                    String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
                    try {
                        fechaNacimiento = LocalDate.parse(fechaStr);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Inténtelo de nuevo.");
                    }
                }
                int opcionSeleccionadaNiño = JOptionPane.showOptionDialog(null, "Seleccione una opción:",
                        "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, opcionesNiño, opcionesNiño[0]);
                switch (opcionSeleccionadaNiño) {

                    case 0:
                        nombrePadre = JOptionPane.showInputDialog("Ingrese el nombre del padre:");
                        apellido1Padre = JOptionPane.showInputDialog("Ingrese el apellido 1 del padre:");
                        apellido2Padre = JOptionPane.showInputDialog("Ingrese el apellido 2 del padre:");
                        nombreMadre = JOptionPane.showInputDialog("Ingrese el nombre 1 de la madre:");
                        apellido1Madre = JOptionPane.showInputDialog("Ingrese el apellido 1 de la madre:");
                        apellido2Madre = JOptionPane.showInputDialog("Ingrese el apellido 2 de la madre:");
                        registroController.ingresarNuevoRegistro(0, nombre1, apellido1, apellido2,
                                fechaNacimiento, nombrePadre, apellido1Padre, apellido2Padre,
                                nombreMadre, apellido1Madre, apellido2Madre);
                        break;
                    case 1:
                        nombrePadre = JOptionPane.showInputDialog("Ingrese el nombre 1 del padre:");
                        apellido1Padre = JOptionPane.showInputDialog("Ingrese el apellido 1 del padre:");
                        apellido2Padre = JOptionPane.showInputDialog("Ingrese el apellido 2 del padre:");
                        registroController.ingresarNuevoRegistro(1, nombre1, apellido1, apellido2,
                                fechaNacimiento, nombrePadre, apellido1Padre, apellido2Padre,
                                null, null, null);
                        break;
                    case 2:
                        nombreMadre = JOptionPane.showInputDialog("Ingrese el nombre 1 de la madre:");
                        apellido1Madre = JOptionPane.showInputDialog("Ingrese el apellido 1 de la madre:");
                        apellido2Madre = JOptionPane.showInputDialog("Ingrese el apellido 2 de la madre:");
                        registroController.ingresarNuevoRegistro(2, nombre1, apellido1, apellido2,
                                fechaNacimiento, null, null, null,
                                nombreMadre, apellido1Madre, apellido2Madre);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                        mostrarMenu();
                        break;
                }
                JOptionPane.showMessageDialog(null, "Nuevo niño registrado correctamente.");
                break;
            case 1:
                registroController.consultarRegistros();
                break;
            case 2:
                String ID= JOptionPane.showInputDialog("Ingrese el Id del registro a modificar:");
                registroController.modificarRegistros(ID);

                break;
            case 3:
                String ID2= JOptionPane.showInputDialog("Ingrese el Id del registro a eliminar:");
                registroController.eliminarRegistros(ID2);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                mostrarMenu();
                break;
        }
    }
}

