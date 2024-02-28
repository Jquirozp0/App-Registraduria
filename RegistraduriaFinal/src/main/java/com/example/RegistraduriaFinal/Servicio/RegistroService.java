package com.example.RegistraduriaFinal.Servicio;

import com.example.RegistraduriaFinal.Entidad.Persona;
import com.example.RegistraduriaFinal.Repositorio.RegistroRepositorio;
import com.example.RegistraduriaFinal.Utilidad.ArchivoUtilidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RegistroService implements RegistroRepositorio, Serializable {

    private List<Persona> registros;
    private ArchivoUtilidad archivoUtilidad;
    public RegistroService() {

        this.registros = new ArrayList<>();
    }
    public void generarRegistroArch() {
        StringBuilder contenido = new StringBuilder();

        for (Persona elemento : registros) {
            contenido.append(elemento.toString()).append(System.lineSeparator()); // Agrega registro
        }
        archivoUtilidad.generarArchivo("registros.txt", contenido.toString());
    }

    //METODOS PRINCIPAL
    public void agregarRegistro(String id, String nombre1, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String tipoDocumento, String nombrePadre, String apellido1Padre, String apellido2Padre, String nombreMadre, String apellido1Madre, String apellido2Madre) {
        Persona persona = new Persona(id, nombre1, primerApellido, segundoApellido, fechaNacimiento, tipoDocumento, nombrePadre, apellido1Padre, apellido2Padre, nombreMadre, apellido1Madre, apellido2Madre);
        this.registros.add(persona);
    }

    public String leerRegistro(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }
    public void modificarRegistro(String ID) {
        if (validarID(ID)) {
            cargarLista(ID);
            String nombre1 = JOptionPane.showInputDialog("Ingrese el nuevo nombre del niño:");
            String primerApellido = JOptionPane.showInputDialog("Ingrese el nuevo primer apellido del niño:");
            String segundoApellido = JOptionPane.showInputDialog("Ingrese el nuevo segundo apellido del niño:");
            for (Persona persona : registros) {
                if (persona.getId().equals(ID)) {
                    persona.setPrimerNombre(nombre1);
                    persona.setPrimerApellido(primerApellido);
                    persona.setSegundoApellido(segundoApellido);
                    break;
                }
            }
        }
        generarRegistroArch();
    }
    public void eliminarRegistro(String ID) {
        // Obtener el contenido actual del archivo
        String contenido = leerRegistro("registros.txt");

        // Buscar el registro a eliminar
        String[] registrosArray = contenido.split("\\n");
        boolean encontrado = false;
        StringBuilder nuevoContenido = new StringBuilder();
        for (String registro : registrosArray) {
            if (registro.contains("Identificacion:" + ID)) {
                encontrado = true;
            } else {
                nuevoContenido.append(registro).append("\n");
            }
        }
        // Escribir el contenido actualizado en el archivo
        if (encontrado) {
            try (FileWriter fileWriter = new FileWriter("registros.txt")) {
                fileWriter.write(nuevoContenido.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El ID proporcionado no corresponde a ningún registro.");
        }
    }
    //METODOS SEGUNDARIOS
    public boolean validarID(String ID) {
        boolean encontrado = false;
        String nombreArchivo = "registros.txt";
        String contenido = leerRegistro(nombreArchivo);
        String[] contenidoArray = contenido.split(",(?=\\p{Upper})");
        for (String indice : contenidoArray) {
            String[] datos = indice.split(":");
            String valor = datos[1].trim();
            if (valor.equals(ID)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    public void cargarLista(String ID) {
        String aux=ID;
        String nombreArchivo = "registros.txt";
        String[] dato = leerRegistro(nombreArchivo).split(",(?=\\p{Upper})");
        Persona persona = new Persona();
        for (String registro : dato) {
            String[] campos = registro.split(":");
                String nombreCampo = campos[0].trim();
                String valorCampo = campos[1].trim();
                if (aux.equals(ID)) {
                    switch (nombreCampo) {
                        case "Nombre":
                            persona.setPrimerNombre(valorCampo);
                            break;
                        case "Apellido 1":
                            persona.setPrimerApellido(valorCampo);
                            break;
                        case "Apellido 2":
                            persona.setSegundoApellido(valorCampo);
                            break;
                        case "Fecha de Nacimiento":
                            persona.setFechaNacimiento(LocalDate.parse(valorCampo));
                            break;
                        case "Identificacion":
                            persona.setId(valorCampo);
                            aux = valorCampo;
                            break;
                        case "Tipo de Documento":
                            persona.setTipoDocumento(valorCampo);
                            break;
                        case "Nombre del Padre":
                            persona.setNombrePadre(valorCampo);
                            break;
                        case "Apellido 1 del Padre":
                            persona.setApellidoPadre(valorCampo);
                            break;
                        case "Apellido 2 del Padre":
                            persona.setApellido2Padre(valorCampo);
                            break;
                        case "Nombre de la Madre":
                            persona.setNombreMadre(valorCampo);
                            break;
                        case "Apellido 1 de la Madre":
                            persona.setApellidoMadre(valorCampo);
                            break;
                        case "Apellido 2 de la Madre":
                            persona.setApellido2Madre(valorCampo);
                            break;
                    }
                }
        }
        registros.add(persona);
        eliminarRegistro(ID);
    }
}



