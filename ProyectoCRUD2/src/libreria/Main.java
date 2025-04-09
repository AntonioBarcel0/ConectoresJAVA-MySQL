package libreria;

import java.util.Scanner;

import libreria.Autor;
import libreria.Genero;
import libreria.Libro;
import libreria.Prestamo;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("=== MENÚ PRINCIPAL ===");
			System.out.println("1. Gestionar géneros");
			System.out.println("2. Gestionar autores");
			System.out.println("3. Gestionar libros");
			System.out.println("4. Gestionar préstamos");
			System.out.println("5. Consultas JOIN");
			System.out.println("6. Consultar préstamos con libros");
			System.out.println("0. Salir");
			System.out.print("Opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
				case 1 -> GeneroMenu.mostrarMenu(scanner);
				case 2 -> AutorMenu.mostrarMenu(scanner);
				case 3 -> LibroMenu.mostrarMenu(scanner);
				case 4 -> PrestamoMenu.mostrarMenu(scanner);
				case 5 -> mostrarConsultasJoin();
				case 6 -> mostrarPrestamosConLibros();
			}
		} while (opcion != 0);
		scanner.close();
	}
	
	private static void mostrarConsultasJoin() {
		 System.out.println("Ejecutando consultas JOIN...");
        // Implementar consultas JOIN aquí
        // Ejemplo: SELECT libro.titulo, autor.nombre_autor, genero.nombre_genero FROM ...
    }

    private static void mostrarPrestamosConLibros() {
        System.out.println("Listando préstamos con detalles de libros...");
        // Implementar consulta de préstamos con información de libros
        // Ejemplo: SELECT prestamo.*, libro.titulo FROM prestamo JOIN libro ...
    }
}
