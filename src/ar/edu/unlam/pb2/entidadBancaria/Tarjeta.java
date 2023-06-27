package ar.edu.unlam.pb2.entidadBancaria;
import java.util.Objects;

import ar.edu.unlam.pb2.eventos.Compra;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class Tarjeta implements MedioDePago{
	
	private Long numeroDeTarjeta; 
	private String titularDeLaTarjeta;
	private String fechaVencimiento;
	private Integer codigoDeSeguridad;
	private Double saldo = 0.0;
	
	public Tarjeta(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaVencimiento,
			Integer codigoDeSeguridad, Double saldo) {
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.titularDeLaTarjeta = titularDeLaTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.saldo = saldo;
	}
	
	public Tarjeta(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaVencimiento,
			Integer codigoDeSeguridad) {
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

	@Override
	public void realizarPago() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verificarDisponibilidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerTransaccionesRecientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarPago() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generarToken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDeTarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(numeroDeTarjeta, other.numeroDeTarjeta);
	}

	@Override
	public void realizarPago(Compra compra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarPago(Double monto) {
		// TODO Auto-generated method stub
		
	}	

}
