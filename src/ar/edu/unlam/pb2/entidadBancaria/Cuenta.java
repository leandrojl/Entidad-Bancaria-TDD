package ar.edu.unlam.pb2.entidadBancaria;

public abstract class Cuenta {
	
	private Integer numeroDeCuenta;
	private String entidadBancaria;
	private String titular;
	
	public Cuenta(Integer numeroDeCuenta, String entidadBancaria, String titular) {
		this.numeroDeCuenta = numeroDeCuenta;
		this.entidadBancaria = entidadBancaria;
		this.titular =  titular;
	}

	public Integer getNumeroDeCuenta() {
		return numeroDeCuenta;
	}



	public void setNumeroDeCuenta(Integer numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}


	public String getEntidadBancaria() {
		return entidadBancaria;
	}



	public void setEntidadBancaria(String entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}



	public String getTitular() {
		return titular;
	}



	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	
}
