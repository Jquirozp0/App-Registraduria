package com.example.RegistraduriaFinal;
import com.example.RegistraduriaFinal.Entidad.Persona;
import com.example.RegistraduriaFinal.Repositorio.RegistroRepositorio;
import com.example.RegistraduriaFinal.Utilidad.ArchivoUtilidad;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
@Log4j2
public class
RegistraduriaFinalApplication implements CommandLineRunner {
	Persona per = new Persona();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		;
		SpringApplication.run(RegistraduriaFinalApplication.class, args);
		System.out.println("proyecto registraduria");
	}

	@Autowired
	RegistroRepositorio registroRepositorio;

	ArchivoUtilidad archivoUtilidad;

	@Override
	public void run(String... args) throws Exception {
		long id = 0;
		archivoUtilidad = new ArchivoUtilidad();
		// Solicitar al usuario que ingrese su nombre
		int opcion, opcion1;
		while (true) {
			System.out.print("1. Agregar Nuevo Niño"+ "\n");
			System.out.print("2. Consultar Registros"+ "\n");
			System.out.print("3. Modificar Registro"+ "\n");
			System.out.print("4. Eliminar Registro"+ "\n");
			System.out.print("5. Salir"+ "\n");
			opcion = sc.nextInt();

			switch (opcion) {
				case 1:
					System.out.print("1. Ambos padres, 2. Solo padre, 3. Solo madre, 4. Salir"+ "\n");
					opcion1 = sc.nextInt();
					sc.nextLine();
					registro(opcion1);
					break;
				case 2:
					System.out.print("Ingrese el id a buscar"+ "\n");
					id = sc.nextInt();
					consulta(id);
					break;
				case 3:
					System.out.print("Ingrese el id a modificar"+ "\n");
					id = sc.nextInt();
					sc.nextLine();
					boolean res = false;
					if ( res = consulta(id)){
						System.out.print("Ingrese el nuevo nombre"+ "\n");
						String nuevoPrimerNombre = sc.nextLine();

						System.out.print("Ingrese el nuevo primer apellido"+ "\n");
						String nuevoPrimerApellido = sc.nextLine();
						System.out.print("Ingrese el nuevo segundo apellido"+ "\n");
						String nuevoSegundoApellido = sc.nextLine();
						modificacion(id, nuevoPrimerNombre, nuevoPrimerApellido, nuevoSegundoApellido);
					}else {System.out.print("ID no encontrado"+ "\n");}

					break;
				case 4:
					System.out.print("Ingrese el id a eliminar"+ "\n");
					id = sc.nextInt();
					eliminacion(id);
					break;
				case 5:
					System.out.println("Saliendo...");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
					break;
			}
		}
	}
	public boolean consulta(long id){
		Optional<Persona> optionalPersona = registroRepositorio.findById(id);
		if (optionalPersona.isPresent()) {
			Persona persona = optionalPersona.get();
			System.out.println(persona);
			return true;
		} else {
			System.out.println("No se encontró ninguna persona con el id: " + id);
			return false;
		}
	}
	public void eliminacion(long id){
		if (registroRepositorio.existsById(id)) {
			registroRepositorio.deleteById(id);
			System.out.println("Se ha eliminado la persona con el id: " + id);
		} else {
			System.out.println("No se encontró ninguna persona con el id: " + id);
		}
	}
	public void modificacion(long id, String nuevoPrimerNombre, String nuevoPrimerApellido, String nuevoSegundoApellido){
		Optional<Persona> optionalPersona = registroRepositorio.findById(id);
		if (optionalPersona.isPresent()) {
			Persona persona = optionalPersona.get();
			persona.setPrimerNombre(nuevoPrimerNombre);
			persona.setPrimerApellido(nuevoPrimerApellido);
			persona.setSegundoApellido(nuevoSegundoApellido);
			registroRepositorio.save(persona);
			System.out.println("Se ha modificado la persona con el id: " + id);
		} else {
			System.out.println("No se encontró ninguna persona con el id: " + id);
		}
	}
	public void registro(int opcion1) {

			System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD):"+ "\n");
			String fecha1 = sc.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fecha;
			int tipo = 0;
			try {
				LocalDate fechaNacimiento = LocalDate.parse(fecha1, formatter);
				per.setFechaNacimiento(fechaNacimiento);
				System.out.println("Fecha ingresada: " + fechaNacimiento);
			} catch (Exception e) {
				System.out.println("Formato de fecha inválido. Por favor ingrese la fecha en el formato YYYY-MM-DD.");
				return;
			}
			switch (opcion1) {
				case 1:
					tipo = 0;
					System.out.print("Ingrese el nombre del niño:"+ "\n");
					per.setPrimerNombre(sc.nextLine());
					System.out.print("Ingrese el nombre del padre:"+ "\n");
					per.setNombrePadre(sc.nextLine());
					System.out.print("Ingrese el apellido 1 del padre:"+ "\n");
					per.setApellidoPadre(sc.nextLine());
					System.out.print("Ingrese el apellido 2 del padre:"+ "\n");
					per.setApellido2Padre(sc.nextLine());
					System.out.print("Ingrese el nombre 1 de la madre:"+ "\n");
					per.setNombreMadre(sc.nextLine());
					System.out.print("Ingrese el apellido 1 de la madre:"+ "\n");
					per.setApellidoMadre(sc.nextLine());
					System.out.print("Ingrese el apellido 2 de la madre:"+ "\n");
					per.setApellido2Madre(sc.nextLine());
					break;
				case 2:
					tipo = 1;
					System.out.print("Ingrese el nombre del niño:"+ "\n");
					per.setPrimerNombre(sc.nextLine());
					System.out.print("Ingrese el nombre 1 del padre:"+ "\n");
					per.setNombrePadre(sc.nextLine());
					System.out.print("Ingrese el apellido 1 del padre:"+ "\n");
					per.setApellidoPadre(sc.nextLine());
					System.out.print("Ingrese el apellido 2 del padre:"+ "\n");
					per.setApellido2Padre(sc.nextLine());
					break;
				case 3:
					tipo = 2;
					System.out.print("Ingrese el nombre del niño:"+ "\n");
					per.setPrimerNombre(sc.nextLine());
					System.out.print("Ingrese el nombre 1 de la madre:"+ "\n");
					per.setNombreMadre(sc.nextLine());
					System.out.print("Ingrese el apellido 1 de la madre:"+ "\n");
					per.setApellidoMadre(sc.nextLine());
					System.out.print("Ingrese el apellido 2 de la madre:"+ "\n");
					per.setApellido2Madre(sc.nextLine());
					break;
				case 4:
					System.out.println("Saliendo...");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
					break;
			}
			archivoUtilidad.asignarApellidos(tipo, per.getApellidoPadre(), per.getApellido2Padre(), per.getApellidoMadre(), per.getApellido2Madre());
			per.setPrimerApellido(archivoUtilidad.getPrimerApellido());
			per.setSegundoApellido(archivoUtilidad.getSegundoApellido());
			per.setId(archivoUtilidad.generarId());
			per.setTipoDocumento(archivoUtilidad.asignarTipoDocumento(per.getFechaNacimiento()));
			registroRepositorio.save(per);
	}
}










