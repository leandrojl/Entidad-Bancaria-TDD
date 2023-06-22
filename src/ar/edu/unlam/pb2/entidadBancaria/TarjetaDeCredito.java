package ar.edu.unlam.pb2.entidadBancaria;

import ar.edu.unlam.pb2.interfaces.PaqueteBlack;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class TarjetaDeCredito extends Tarjeta implements MedioDePago{
	
	private Double limiteDeCompraEnPesos;
	private Double limiteDeCompraEnDolares;
	
	public TarjetaDeCredito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeVencimiento,
			Integer codigoDeSeguridad, Double limiteDeCompraEnPesos, Double limiteDeCompraEnDolares) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeVencimiento, codigoDeSeguridad);
		this.setLimiteDeCompraEnPesos(limiteDeCompraEnPesos);
		this.setLimiteDeCompraEnDolares(limiteDeCompraEnDolares);
	}

	public TarjetaDeCredito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeVencimiento, Integer codigoDeSeguridad) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeVencimiento, codigoDeSeguridad);
	}

	public Double getLimiteDeCompraEnPesos() {
		return limiteDeCompraEnPesos;
	}

	public void setLimiteDeCompraEnPesos(Double limiteDeCompraEnPesos) {
		this.limiteDeCompraEnPesos = limiteDeCompraEnPesos;
	}

	public Double getLimiteDeCompraEnDolares() {
		return limiteDeCompraEnDolares;
	}

	public void setLimiteDeCompraEnDolares(Double limiteDeCompraEnDolares) {
		this.limiteDeCompraEnDolares = limiteDeCompraEnDolares;
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
	

}
