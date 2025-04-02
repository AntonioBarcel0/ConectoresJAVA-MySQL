package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PeliculaDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
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
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, idPelicula);
			pstmt.setString(2, tituloPelicula);
			pstmt.setString(3, directorPelicula);
			pstmt.setString(4, generoPelicula);
			pstmt.setString(5, anyoPelicula);
			pstmt.setString(6, duracionPelicula);
			pstmt.executeUpdate();
			System.out.println("Película agregada correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}
	
	public static void listarPeliculas() {
		String sql = "SELECT * FROM pelicula";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\nLista de películas:");
			while (rs.next()) {
				System.out.println(rs.getInt("idPelicula") + rs.getString("tituloPelicula") + rs.getString("directorPelicula") + rs.getString("generoPelicula") + rs.getInt("anyoPelicula")
						+ rs.getInt("duracionPelicula"));
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}
	
	public static void actualizarPelicula(Scanner scanner) {
		System.out.println("Ingrese una película a actualizar.");
		int idPelicula = scanner.nextInt();
		System.out.println("Ingrese un nuevo título: ");
		String tituloPelicula = scanner.nextLine();

		String sql = "UPDATE pelicula SET nombrePelicula = ? WHERE idPelicula = ?";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.setInt(1, idPelicula);
			pstmt.setString(2, tituloPelicula);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Película actualizada correctamente.");
			} else {
				System.out.println("No se encontró la película con ID: " + idPelicula);
			}

		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}
	
	public static void eliminarPelicula(Scanner scanner) {
		System.out.println("Ingrese ID de la pelicula a eliminar: ");
		int idPelicula = scanner.nextInt();

		String deleteInterpretacionesSQL = "DELETE FROM interpretacion WHERE idPelicula = ?";
		String deletePeliculaSQL = "DELETE FROM pelicula WHERE idPelicula = ?";
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmtInterpretaciones = connection.prepareStatement(deletePeliculaSQL);
				PreparedStatement pstmtPelicula = connection.prepareStatement(deletePeliculaSQL)) {
			pstmtInterpretaciones.setInt(1, idPelicula);
			pstmtInterpretaciones.executeUpdate();
			pstmtPelicula.setInt(1, idPelicula);
			int rowsDeleted = pstmtPelicula.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Película eliminada correctamente");
			} else {
				System.out.println("No se encontró la película");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}
	}

}
