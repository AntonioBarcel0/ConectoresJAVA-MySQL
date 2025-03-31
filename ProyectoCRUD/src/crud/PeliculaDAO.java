package crud;

import java.util.Scanner;

public class PeliculaDAO {
	public static void insertarPelicula(Scanner scanner) {
		System.out.println("Ingrese el id de la película: ");
		int idPelicula = scanner.nextInt();
		System.out.println("Ingrese el titulo de la película:");
		String tituloPelicula = scanner.nextLine();
		System.out.println("Ingrese el director de la película:");
		String directorPelicula = scanner.nextLine();
		System.out.println("Ingrese el género de la película:");
		String generoPelicula = scanner.nextLine();
		System.out.println("Ingrese el año de la película:");
		String anyoPelicula = scanner.nextLine();
		System.out.println("Ingrese la duración de la película:");
		String duracionPelicula = scanner.nextLine();
		
		String sql = "INSERT INTO actor (idPelicula, tituloPelicula, directorPelicula, generoPelicula, anyoPelicula, duracionPelicula) VALUES (?, ?, ?, ?, ?, ?)";
		
	}
	
	public static void listarPeliculas() {
		String sql = "SELECT * FROM pelicula";
			
	}
	
	public static void actualizarPelicula(Scanner scanner) {
		System.out.println("Ingrese una película a actualizar.");
		int idPelicula = scanner.nextInt();
		System.out.println("Ingrese un nuevo título: ");
		String titulo = scanner.nextLine();

		String sql = "UPDATE pelicula SET nombrePelicula = ? WHERE idPelicula = ?";
		
	}
	
	public static void eliminarPelicula(Scanner scanner) {
		System.out.println("Ingrese ID de la pelicula a eliminar: ");
		int idPelicula = scanner.nextInt();

		String deleteInterpretacionesSQL = "DELETE FROM interpretacion WHERE idPelicula = ?";
		String deleteActorSQL = "DELETE FROM pelicula WHERE idPelicula = ?";
		
	}

}
