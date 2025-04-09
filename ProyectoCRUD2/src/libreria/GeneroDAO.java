package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class GeneroDAO {
	

	public static void insertarGenero(Scanner scanner) {
		System.out.println("Ingrese el id del Género: ");
		int id_genero = scanner.nextInt();
		System.out.println("Ingrese el nombre del Género");
		String nombre_genero = scanner.nextLine();

		String sql = "INSERT INTO genero (id_genero, nombre_genero) VALUES (?, ?)";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, id_genero);
			pstmt.setString(2, nombre_genero);
			pstmt.executeUpdate();
			System.out.println("Género agregado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}
	
	public static void listarGenero() {
		String sql = "SELECT * FROM genero";

		try (Connection connection = DBConnection.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\nLista de Géneros:");
			while (rs.next()) {
				System.out.println(rs.getInt("id_genero") + rs.getString("nombre_genero"));
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

	public static void actualizarGenero(Scanner scanner) {
		System.out.println("Ingrese un género a actualizar.");
		int id_genero = scanner.nextInt();
		System.out.println("Ingrese un nuevo nombre: ");
		String nombre_genero = scanner.nextLine();

		String sql = "UPDATE genero SET nombre_genero = ? WHERE id_genero = ?";
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, id_genero);
			pstmt.setString(2, nombre_genero);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Género actualizado correctamente.");
			} else {
				System.out.println("No se encontró el género con el ID: " + id_genero);
			}

		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

	public static void eliminarGenero(Scanner scanner) {
		System.out.println("Ingrese ID del género a eliminar: ");
		int id_genero = scanner.nextInt();

		String deleteIdgeneroLibroSQL = "DELETE FROM libro WHERE id_genero = ?";
		String deleteGeneroSQL = "DELETE FROM genero WHERE id_genero = ?";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement deleteIdgeneroLibroSQL = connection.prepareStatement(deleteIdgeneroLibroSQL);
				PreparedStatement pstmtGenero = connection.prepareStatement(deleteGeneroSQL)) {
			deleteIdgeneroLibroSQL.setInt(1, id_genero);
			deleteIdgeneroLibroSQL.executeUpdate();
			pstmtGenero.setInt(1, id_genero);
			int rowsDeleted = pstmtGenero.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Genero eliminado correctamente");
			} else {
				System.out.println("No se encontró el género");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

	}

}
