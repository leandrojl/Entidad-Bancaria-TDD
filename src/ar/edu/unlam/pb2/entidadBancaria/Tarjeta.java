package ar.edu.unlam.pb2.entidadBancaria;

public class Tarjeta extends Cuenta{
	
	private String nombre;
	private Long numeroDeTarjeta; 
	private String titularDeLaTarjeta;
	private String fechaDeOtorgamiento;
	private Integer codigoDeSeguridad;
	
	public Tarjeta(String nombre, Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeOtorgamiento,
			Integer codigoDeSeguridad) {
		super();
		this.nombre = nombre;
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.titularDeLaTarjeta = titularDeLaTarjeta;
		this.fechaDeOtorgamiento = fechaDeOtorgamiento;
		this.codigoDeSeguridad = codigoDeSeguridad;
	}
	
	public Tarjeta() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}
	public void setNumeroDeTarjeta(Long numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}
	public String getTitularDeLaTarjeta() {
		return titularDeLaTarjeta;
	}
	public void setTitularDeLaTarjeta(String titularDeLaTarjeta) {
		this.titularDeLaTarjeta = titularDeLaTarjeta;
	}
	public String getFechaDeOtorgamiento() {
		return fechaDeOtorgamiento;
	}
	public void setFechaDeOtorgamiento(String fechaDeOtorgamiento) {
		this.fechaDeOtorgamiento = fechaDeOtorgamiento;
	}
	public Integer getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}
	public void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}
	
	

}
