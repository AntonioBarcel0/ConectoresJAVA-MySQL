package libreria;

public class Libro {
	private int id_libro;
	private String titulo;
	private int anio_publicacion;
	private int id_autor;
	private int id_genero;

	public Libro(int id_libro, String titulo, int anio_publicacion, int id_autor, int id_genero) {
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.anio_publicacion = anio_publicacion;
		this.id_autor = id_autor;
		this.id_genero = id_genero;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio_publicacion() {
		return anio_publicacion;
	}

	public void setAnio_publicacion(int anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public int getId_genero() {
		return id_genero;
	}

	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}

	@Override
	public String toString() {
		return id_libro + " - " + titulo + " (" + anio_publicacion + ")";
	}
}
