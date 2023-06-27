package ar.edu.unlam.pb2.eventos;

import ar.edu.unlam.pb2.clientes.Comercio;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class Compra {
	private Integer numeroCompra;
	private MedioDePago medioDePago;
	private Comercio comercio;
	private Double monto;
	
	public Compra(Integer numeroCompra, MedioDePago medioDePago, Comercio comercio, Double monto) {
		super();
		this.numeroCompra = numeroCompra;
		this.medioDePago = medioDePago;
		this.comercio = comercio;
		this.monto = monto;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getNumeroCompra() {
		return numeroCompra;
	}

	public void setNumeroCompra(Integer numeroCompra) {
		this.numeroCompra = numeroCompra;
	}

}
