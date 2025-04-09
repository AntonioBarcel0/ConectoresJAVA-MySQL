package libreria;

import java.util.Date;

public class Prestamo {
	
	private int id_libro;
	private Date fecha_prestamo;
	private boolean devuelto;

	

	public int getId_libro() {
		return id_libro;
	}



	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}



	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}



	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}



	public boolean isDevuelto() {
		return devuelto;
	}



	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}



	public Prestamo(int id_libro, Date fecha_prestamo, boolean devuelto) {
		super();
		this.id_libro = id_libro;
		this.fecha_prestamo = fecha_prestamo;
		this.devuelto = devuelto;
	}



	@Override
	public String toString() {
		return "Prestamo [id_libro=" + id_libro + ", fecha_prestamo=" + fecha_prestamo + ", devuelto=" + devuelto + "]";
	}



	a

}
