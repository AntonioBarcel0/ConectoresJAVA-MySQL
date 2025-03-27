package conectores;

import java.sql.*;
import java.util.Scanner;

public class Peliculas {
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("\n--- CRUD Películas ---");
			System.out.println("1.Agregar Película");
			System.out.println("2.Mostrar Películas");
			System.out.println("3.Actualizar Películas");
			System.out.println("4.Eliminar película");
			System.out.println("5.Salir");
			
			opcion = scanner.nextInt();
			switch(opcion) {
			case 1:
				agregarPelicula(scanner);
				break;
			case 2:
				agregarPelicula();
				break;
			case 3:
				agregarPelicula();
				break;
			case 4:
				agregarPelicula();
				break;
			case 5:
				System.out.println("Saliendo del programa.");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			
		}while (opcion != 5);
	}
		
	public static void agregarPelicula(Scanner scanner) {
		System.out.println("Ingrese un título: ");
		String titulo = scanner.nextLine();
		System.out.println("Agrege el id del director");
		String idDirector = scanner.nextLine();
		System.out.println("Agrege el id del género");
		String idGenero = scanner.nextLine();
		System.out.println("Agrege el año");
		String anyo = scanner.nextLine();
		System.out.println("Agrege la duración");
		String duracion = scanner.nextLine();
		
		String sql = "INSER INTO pelicula (tituloPelicula, directorPelicula, generoPelicula, anyoPelicula, duracionPelicula) VALUES (?,?,?,?,?)";	
		
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexion establecida con la base de datos MySql.");
		}catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}

}
