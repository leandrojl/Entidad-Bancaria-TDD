package ar.edu.unlam.pb2.entidadBancaria;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class TarjetaDeDebito extends Tarjeta implements MedioDePago{

	public TarjetaDeDebito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeOtorgamiento,
			Integer codigoDeSeguridad, Double saldo) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeOtorgamiento, codigoDeSeguridad, saldo);
	}

	public TarjetaDeDebito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeOtorgamiento,
			Integer codigoDeSeguridad) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeOtorgamiento, codigoDeSeguridad);
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
