package ar.edu.unlam.pb2.entidadBancaria;

public class TarjetaDeDebito extends Tarjeta{

	public TarjetaDeDebito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeOtorgamiento,
			Integer codigoDeSeguridad, Double saldo) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeOtorgamiento, codigoDeSeguridad, saldo);
	}

	public TarjetaDeDebito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeOtorgamiento,
			Integer codigoDeSeguridad) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeOtorgamiento, codigoDeSeguridad);
	}

}
