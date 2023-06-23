package ar.edu.unlam.pb2.entidadBancaria;

import ar.edu.unlam.pb2.eventos.Compra;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class CuentaBancaria extends Cuenta implements MedioDePago{
	
	private String cbu;

	public CuentaBancaria(Integer numeroDeCuenta, String entidadBancaria, String titular) {
		super(numeroDeCuenta, entidadBancaria, titular);
		// TODO Auto-generated constructor stub
	}
	
	public CuentaBancaria(Integer numeroDeCuenta, String cbu, String entidadBancaria, String titular) {
		super(numeroDeCuenta, entidadBancaria, titular);
		this.cbu = cbu;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
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
	public void realizarPago(Compra compra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarPago(Double monto) {
		// TODO Auto-generated method stub
		
	}

}
