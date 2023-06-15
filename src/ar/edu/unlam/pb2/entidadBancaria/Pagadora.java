package ar.edu.unlam.pb2.entidadBancaria;

import java.util.HashMap;
import java.util.HashSet;

import ar.edu.unlam.pb2.clientes.Persona;

public class Pagadora {
	
	private String nombre;
	private HashSet<Tarjeta> tarjetas;
	private HashMap<Integer, Persona> clientes;
	private HashSet<Cuenta> cuentas;
	
	public Pagadora(String nombre, HashSet<Tarjeta> tarjetas) {
		super();
		this.nombre = nombre;
		this.tarjetas = tarjetas;
	}
	
	public Pagadora(String nombre) {
		this.nombre = nombre;
		this.tarjetas = new HashSet<Tarjeta>();
		this.clientes = new HashMap<Integer, Persona>();
		this.cuentas = new HashSet<Cuenta>();
	}
	
	public Pagadora() {
		this.tarjetas = new HashSet<Tarjeta>();
		this.clientes = new HashMap<Integer, Persona>();
		this.cuentas = new HashSet<Cuenta>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public HashSet<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(HashSet<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public HashMap<Integer, Persona> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<Integer, Persona> clientes) {
		this.clientes = clientes;
	}

	public HashSet<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(HashSet<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
