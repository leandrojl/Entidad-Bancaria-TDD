package ar.edu.unlam.pb2.entidadBancaria;

public class Tarjeta extends Cuenta{
	

	private Long numeroDeTarjeta; 
	private String titularDeLaTarjeta;
	private String fechaVencimiento;
	private Integer codigoDeSeguridad;
	private Double saldo;
	
	public Tarjeta(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaVencimiento,
			Integer codigoDeSeguridad, Double saldo) {
		super();
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.titularDeLaTarjeta = titularDeLaTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.saldo = saldo;
	}
	
	public Tarjeta(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaVencimiento,
			Integer codigoDeSeguridad) {
		super();
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.titularDeLaTarjeta = titularDeLaTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	public Tarjeta() {
		
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
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaDeOtorgamiento) {
		this.fechaVencimiento = fechaDeOtorgamiento;
	}
	public Integer getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}
	public void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	

}
