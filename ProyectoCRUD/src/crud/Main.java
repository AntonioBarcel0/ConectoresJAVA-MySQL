package crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n--- CRUD Películas ---");
			System.out.println("1.Insertar Actor");
			System.out.println("2.Insertar Película");
			System.out.println("3.Insertar País");
			System.out.println("4.Listar actores con País");
			System.out.println("5.Actualizar nombre de actor");
			System.out.println("6.Eliminar actor por ID");
			System.out.println("7.Listar películas con género y director");
			System.out.println("8. Eliminar país por ID");
			System.out.println("9.Salir");

			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion) {
			case 1:
				insertarActor(scanner);
				break;
			case 2:
				insertarPelicula(scanner);
				break;
			case 3:
				insertarPais(scanner);
				break;
			case 4:
				listarActoresConPais(scanner);
				break;
			case 5:
				actualizarNombreActor(scanner);
				break;
			case 6:
				eliminarActorID(scanner);
				break;
			case 7:
				listarPeliculasConGeneroDirector(scanner);
				break;
			case 8:
				eliminarPaisPorID(scanner);
				break;
			case 9:
				System.out.println("Saliendo del programa.");
				break;
			default:
				System.out.println("Opción no válida.");
			}

		} while (opcion != 9);
	}


}
