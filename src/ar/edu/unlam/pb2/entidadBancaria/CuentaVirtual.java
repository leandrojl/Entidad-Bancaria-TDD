package ar.edu.unlam.pb2.entidadBancaria;
import ar.edu.unlam.pb2.eventos.Compra;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class CuentaVirtual extends Cuenta implements MedioDePago{
	
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
