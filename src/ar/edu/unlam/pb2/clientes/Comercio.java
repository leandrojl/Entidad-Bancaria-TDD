package ar.edu.unlam.pb2.clientes;

public class Comercio {
	
	private Long cuit;
	private String nombre;

	public Comercio(Long cuit, String nombre) {
		this.cuit =cuit;
		this.nombre = nombre;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
