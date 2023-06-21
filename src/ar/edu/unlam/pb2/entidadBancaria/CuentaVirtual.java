package ar.edu.unlam.pb2.entidadBancaria;

public class CuentaVirtual extends Cuenta{
	
	private String cvu;

	public CuentaVirtual(Integer numeroDeCuenta, String entidadBancaria, String titular) {
		super(numeroDeCuenta, entidadBancaria, titular);
		// TODO Auto-generated constructor stub
	}
	
	public CuentaVirtual(Integer numeroDeCuenta, String cvu, String entidadBancaria, String titular) {
		super(numeroDeCuenta, entidadBancaria, titular);
		this.cvu = cvu;
	}

	public String getCvu() {
		return cvu;
	}

	public void setCvu(String cvu) {
		this.cvu = cvu;
	}

}
