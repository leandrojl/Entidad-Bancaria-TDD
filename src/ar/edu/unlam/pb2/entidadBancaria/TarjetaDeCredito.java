package ar.edu.unlam.pb2.entidadBancaria;

public class TarjetaDeCredito extends Tarjeta{
	
	private Double limiteDeCompraEnPesos;
	private Double limiteDeCompraEnDolares;
	
	public TarjetaDeCredito(Long numeroDeTarjeta, String titularDeLaTarjeta, String fechaDeVencimiento,
			Integer codigoDeSeguridad, Double limiteDeCompraEnPesos, Double limiteDeCompraEnDolares) {
		super(numeroDeTarjeta, titularDeLaTarjeta, fechaDeVencimiento, codigoDeSeguridad);
		this.setLimiteDeCompraEnPesos(limiteDeCompraEnPesos);
		this.setLimiteDeCompraEnDolares(limiteDeCompraEnDolares);
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
	

}
