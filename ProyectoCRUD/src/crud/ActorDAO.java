package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ActorDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static void insertarActor(Scanner scanner) {
		System.out.println("Ingrese el id del actor: ");
		int idActor = scanner.nextInt();
		System.out.println("Ingrese el nombre del actor");
		String nombreActor = scanner.nextLine();
		System.out.println("Ingrese la nacionalidad del actor");
		String nacionalidadActor = scanner.nextLine();

		String sql = "INSERT INTO actor (idActor, nombreActor, nacionalidadActor) VALUES (?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, idActor);
			pstmt.setString(2, nombreActor);
			pstmt.setString(3, nacionalidadActor);
			pstmt.executeUpdate();
			System.out.println("Actor agregado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

	public static void listarActores() {
		String sql = "SELECT * FROM actor";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\nLista de Actores:");
			while (rs.next()) {
				System.out.println(rs.getInt("idActor") + rs.getString("nombreActor") + rs.getInt("nacionalidadActor"));
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

	public static void actualizarActor(Scanner scanner) {
		System.out.println("Ingrese un actor a actualizar.");
		int idActor = scanner.nextInt();
		System.out.println("Ingrese un nuevo nombre: ");
		String nombreActor = scanner.nextLine();

		String sql = "UPDATE actor SET nombreActor = ? WHERE idActor = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, idActor);
			pstmt.setString(2, nombreActor);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Actor actualizado correctamente.");
			} else {
				System.out.println("No se encontró el actor con el ID: " + idActor);
			}

		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

	public static void eliminarActor(Scanner scanner) {
		System.out.println("Ingrese ID del actor a eliminar: ");
		int idActor = scanner.nextInt();

		String deleteInterpretacionesSQL = "DELETE FROM interpretacion WHERE idActor = ?";
		String deleteActorSQL = "DELETE FROM actor WHERE idActor = ?";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmtInterpretaciones = connection.prepareStatement(deleteInterpretacionesSQL);
				PreparedStatement pstmtActor = connection.prepareStatement(deleteActorSQL)) {
			pstmtInterpretaciones.setInt(1, idActor);
			pstmtInterpretaciones.executeUpdate();
			pstmtActor.setInt(1, idActor);
			int rowsDeleted = pstmtActor.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Actor eliminado correctamente");
			} else {
				System.out.println("No se encontró el actor");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

}
