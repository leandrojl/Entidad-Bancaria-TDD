package ar.edu.unlam.pb2.entidadBancaria;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import ar.edu.unlam.pb2.clientes.Cliente;
import ar.edu.unlam.pb2.clientes.Comercio;
import ar.edu.unlam.pb2.excepciones.ClienteNoEncontradoException;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class BilleteraVirtual {
	
	private String nombre;
	private Integer codigoIdentificacion;
	private Cliente cliente;
	private HashSet<Comercio> comercios;
	private HashSet<MedioDePago> mediosDePago;

	public BilleteraVirtual(String nombre) {
		this.setComercios(new HashSet<Comercio>());
		this.nombre = nombre;
		this.mediosDePago = new HashSet<MedioDePago>();
	}
	
	public BilleteraVirtual(Integer codigoIdentificacion, String nombre) {
		
		this.codigoIdentificacion = codigoIdentificacion;
		this.setComercios(new HashSet<Comercio>());
		this.nombre = nombre;
		this.mediosDePago = new HashSet<MedioDePago>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarComercio(Comercio comercio) {
		this.comercios.add(comercio);
		
	}

	public HashSet<Comercio> getComercios() {
		return comercios;
	}

	public void setComercios(HashSet<Comercio> comercios) {
		this.comercios = comercios;
	}

	public HashSet<MedioDePago> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(HashSet<MedioDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	public Integer getCodigoIdentificacion() {
		return codigoIdentificacion;
	}

	public void setCodigoIdentificacion(Integer codigoIdentificacion) {
		this.codigoIdentificacion = codigoIdentificacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIdentificacion);
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BilleteraVirtual other = (BilleteraVirtual) obj;
		return Objects.equals(codigoIdentificacion, other.codigoIdentificacion);
	}

//	public void agregarMedioDePago(Integer dni, Cuenta medioDePago) throws ClienteNoEncontradoException {
//
//		Cliente cliente = buscarClientePorDNI(dni);
//		
//		
//		
//	}

//	private Cliente buscarClientePorDNI(Integer dni) throws ClienteNoEncontradoException {
//		
//		for(Cliente cliente : clientes) {
//			if(cliente.getDni().equals(dni)) {
//				return cliente;
//			}
//		}
//		
//		throw new ClienteNoEncontradoException("Cliente no encontrado");
//	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void agregarMedioDePago(MedioDePago unMedioDePago) {
		this.mediosDePago.add(unMedioDePago);
		
	}

}
