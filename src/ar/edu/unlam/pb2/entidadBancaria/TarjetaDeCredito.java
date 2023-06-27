package ar.edu.unlam.pb2.entidadBancaria;

import ar.edu.unlam.pb2.interfaces.MedioDePago;

import java.util.HashMap;

import ar.edu.unlam.pb2.eventos.Compra;
import ar.edu.unlam.pb2.excepciones.SaldoInsuficienteException;

public class TarjetaDeCredito extends Tarjeta implements MedioDePago{
	
	private Double limiteDeCompraEnPesos;
	private Double limiteDeCompraEnDolares;
	private HashMap<Integer, Compra> registroDeCompras;
	
	public TarjetaDeCredito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeVencimiento,
			Integer codigoDeSeguridad, Double limiteDeCompraEnPesos, Double limiteDeCompraEnDolares) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeVencimiento, codigoDeSeguridad);
		this.setLimiteDeCompraEnPesos(limiteDeCompraEnPesos);
		this.setLimiteDeCompraEnDolares(limiteDeCompraEnDolares);
		this.registroDeCompras = new HashMap<Integer, Compra>();
	}

	public TarjetaDeCredito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeVencimiento, Integer codigoDeSeguridad) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeVencimiento, codigoDeSeguridad);
		this.setLimiteDeCompraEnPesos(limiteDeCompraEnPesos);
		this.setLimiteDeCompraEnDolares(limiteDeCompraEnDolares);
		this.registroDeCompras = new HashMap<Integer, Compra>();
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
	public void realizarPago(Double monto) {
		
	}
	
	@Override
	public void realizarPago(Compra compra){
		try {
			verificarLimiteDeCompra(compra.getMonto());
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.registroDeCompras.put(compra.getNumeroCompra(), compra);
		setSaldo(this.getSaldo() + compra.getMonto());
	}

	private Boolean verificarLimiteDeCompra(Double monto) throws SaldoInsuficienteException {
		if(this.limiteDeCompraEnPesos >= monto) {
			return true;
		}
		
		throw new SaldoInsuficienteException("Saldo insuficiente para la operacion");
		
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

	public HashMap<Integer, Compra> getRegistroDeCompras() {
		return registroDeCompras;
	}

	public void setRegistroDeCompras(HashMap<Integer, Compra> registroDeCompras) {
		this.registroDeCompras = registroDeCompras;
	}
	

}
