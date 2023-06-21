package ar.edu.unlam.pb2.entidadBancaria;

public class CuentaBancaria extends Cuenta{
	
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

}
