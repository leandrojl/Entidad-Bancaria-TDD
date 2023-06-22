package ar.edu.unlam.pb2.clientes;
import java.util.HashSet;

import ar.edu.unlam.pb2.entidadBancaria.BilleteraVirtual;
import ar.edu.unlam.pb2.entidadBancaria.Cuenta;

public class Cliente extends Persona{
	
	private Integer numeroCliente;
	private HashSet<BilleteraVirtual> billeterasVirtuales;

	public Cliente(Integer dni, String nombre) {
		super(dni, nombre);
		this.billeterasVirtuales = new HashSet<BilleteraVirtual>();
	}
	
	public Cliente(Integer numeroCliente, Integer dni, String nombre) {
		super(dni, nombre);
		this.numeroCliente = numeroCliente;
	}

	public Integer getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(Integer numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public HashSet<BilleteraVirtual> getBilleterasVirtuales() {
		return billeterasVirtuales;
	}

	public void setBilleterasVirtuales(HashSet<BilleteraVirtual> billeterasVirtuales) {
		this.billeterasVirtuales = billeterasVirtuales;
	}

	public void agregarBilletera(BilleteraVirtual billeteraVirtual) {
		this.billeterasVirtuales.add(billeteraVirtual);
		
	}

	public void agregarMedioDePago(Cuenta medioDePago) {
		
		
		
	}
	
	

}
