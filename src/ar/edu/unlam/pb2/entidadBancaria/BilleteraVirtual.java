package ar.edu.unlam.pb2.entidadBancaria;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import ar.edu.unlam.pb2.clientes.Cliente;
import ar.edu.unlam.pb2.clientes.Comercio;
import ar.edu.unlam.pb2.excepciones.ClienteNoEncontradoException;


public class BilleteraVirtual {
	
	private String nombre;
	private Integer codigoIdentificacion;
	private HashSet<Comercio> comercios;
	private HashMap<Cliente, HashSet<MedioDePago>> clientes;
	private HashSet<Cuenta> mediosDePago;

	public BilleteraVirtual(String nombre) {
		this.setComercios(new HashSet<Comercio>());
		this.nombre = nombre;
		this.clientes = new HashSet<Cliente>();
		this.mediosDePago = new HashSet<Cuenta>();
	}
	
	public BilleteraVirtual(Integer codigoIdentificacion, String nombre) {
		
		this.codigoIdentificacion = codigoIdentificacion;
		this.setComercios(new HashSet<Comercio>());
		this.nombre = nombre;
		this.clientes = new HashSet<Cliente>();
		this.mediosDePago = new HashSet<Cuenta>();
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

	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
		
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashSet<Cuenta> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(HashSet<Cuenta> mediosDePago) {
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

	public void agregarMedioDePago(Integer dni, Cuenta medioDePago) throws ClienteNoEncontradoException {

		Cliente cliente = buscarClientePorDNI(dni);
		
		
		
	}

	private Cliente buscarClientePorDNI(Integer dni) throws ClienteNoEncontradoException {
		
		for(Cliente cliente : clientes) {
			if(cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		
		throw new ClienteNoEncontradoException("Cliente no encontrado");
	}

}
