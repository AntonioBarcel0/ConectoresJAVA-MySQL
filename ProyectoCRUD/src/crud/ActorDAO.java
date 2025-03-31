package crud;

import java.util.Scanner;

public class ActorDAO {

	public static void insertarActor(Scanner scanner) {
		System.out.println("Ingrese el id del actor: ");
		int idActor = scanner.nextInt();
		System.out.println("Ingrese el nombre del actor");
		String nombreActor = scanner.nextLine();
		System.out.println("Ingrese la nacionalidad del actor");
		String nacionalidadActor = scanner.nextLine();
		
		String sql = "INSERT INTO actor (idActor, nombreActor, nacionalidadActor) VALUES (?, ?, ?)";
		
	}
	
	public static void listarActores() {
		String sql = "SELECT * FROM actor";
			
	}
	
	public static void actualizarActor(Scanner scanner) {
		System.out.println("Ingrese un actor a actualizar.");
		int idActor = scanner.nextInt();
		System.out.println("Ingrese un nuevo nombre: ");
		String titulo = scanner.nextLine();

		String sql = "UPDATE actor SET nombreActor = ? WHERE idActor = ?";
		
	}
	
	public static void eliminarActor(Scanner scanner) {
		System.out.println("Ingrese ID del actor a eliminar: ");
		int id = scanner.nextInt();

		String deleteInterpretacionesSQL = "DELETE FROM interpretacion WHERE idActor = ?";
		String deleteActorSQL = "DELETE FROM actor WHERE idActor = ?";
		
	}
	
	

}
