package libreria;

public class Autor {
	private int idAutor;
	private String nombreAutor;
	private String nacionalidad;
	
	public Autor(int idAutor, String nombreAutor, String nacionanalidad) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.nacionalidad = nacionanalidad;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNacionanalidad() {
		return nacionalidad;
	}

	public void setNacionanalidad(String nacionanalidad) {
		this.nacionalidad = nacionanalidad;
	}
	
	public String toString() {
		return idAutor + " - " + nombreAutor + " (" + nacionalidad + ") ";  
	}
	
	

}
