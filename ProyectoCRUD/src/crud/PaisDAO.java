package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PaisDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public static void insertarPais(Scanner scanner) {
		System.out.println("Ingrese el id del País: ");
		int idPais = scanner.nextInt();
		System.out.println("Ingrese el nombre del País");
		String nombrePais = scanner.nextLine();
		
		String sql = "INSERT INTO pais (idPais, nombrePais) VALUES (?, ?)";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, idPais);
			pstmt.setString(2, nombrePais);
			pstmt.executeUpdate();
			System.out.println("País agregado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}
	
	public static void listarPais() {
		String sql = "SELECT * FROM pais";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\nLista de paises:");
			while (rs.next()) {
				System.out.println(rs.getInt("idPais") + rs.getString("nombrePais"));
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}
	
	public static void actualizarPais(Scanner scanner) {
		System.out.println("Ingrese un país a actualizar.");
		int idPais = scanner.nextInt();
		System.out.println("Ingrese un nuevo país: ");
		String nombreNuevoPais = scanner.nextLine();

		String sql = "UPDATE pais SET nombrePais = ? WHERE idPais = ?";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, idPais);
			pstmt.setString(2, nombreNuevoPais);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("País actualizado correctamente.");
			} else {
				System.out.println("No se encontró el país con el ID: " + idPais);
			}

		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}
	
	public static void eliminarPais(Scanner scanner) {
		System.out.println("Ingrese ID del país a eliminar: ");
		int idPais = scanner.nextInt();

		String deletePaisSQL = "DELETE FROM pais WHERE idPais = ?";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmtPais = connection.prepareStatement(deletePaisSQL)) {
			pstmtPais.setInt(1, idPais);
			pstmtPais.executeUpdate();
			int rowsDeleted = pstmtPais.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("País eliminado correctamente");
			} else {
				System.out.println("No se encontró el país");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}

}
