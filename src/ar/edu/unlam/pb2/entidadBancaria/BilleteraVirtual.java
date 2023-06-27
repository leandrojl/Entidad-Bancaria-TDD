package ar.edu.unlam.pb2.entidadBancaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import ar.edu.unlam.pb2.clientes.Cliente;
import ar.edu.unlam.pb2.clientes.Comercio;
import ar.edu.unlam.pb2.eventos.Compra;
import ar.edu.unlam.pb2.excepciones.CVUInvalidoException;
import ar.edu.unlam.pb2.excepciones.ClienteNoEncontradoException;
import ar.edu.unlam.pb2.excepciones.ComercioInvalidadException;
import ar.edu.unlam.pb2.excepciones.MedioDePagoNoDisponibleException;
import ar.edu.unlam.pb2.excepciones.MedioDePagoNoVerificadoException;
import ar.edu.unlam.pb2.excepciones.NoCoincideTitularException;
import ar.edu.unlam.pb2.excepciones.SaldoInsuficienteException;
import ar.edu.unlam.pb2.excepciones.TarjetaNoDisponibleException;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class BilleteraVirtual implements MedioDePago{
	
	private String nombre;
	private Integer codigoIdentificacion;
	private Cliente cliente;
	private HashSet<Comercio> comercios;
	private HashSet<MedioDePago> mediosDePago;
	private ArrayList <Compra> compras;

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

	public void agregarMedioDePago(MedioDePago unMedioDePago) throws NoCoincideTitularException {
		validarTitularidad(unMedioDePago);
		this.mediosDePago.add(unMedioDePago);
		
	}

	private Boolean validarTitularidad(MedioDePago unMedioDePago) throws NoCoincideTitularException {
		
		if (unMedioDePago instanceof TarjetaDeCredito) {
	        TarjetaDeCredito tarjeta = (TarjetaDeCredito) unMedioDePago;
	        if(this.cliente.getNombre().equals(tarjeta.getTitularDeLaTarjeta())) {
	        	return true;
	        }
	    } else if (unMedioDePago instanceof TarjetaDeDebito) {
	        TarjetaDeDebito tarjeta = (TarjetaDeDebito) unMedioDePago;
	        if(this.cliente.getNombre().equals(tarjeta.getTitularDeLaTarjeta())) {
	        	return true;
	        }
	    } else if (unMedioDePago instanceof CuentaBancaria) {
	        CuentaBancaria cuenta = (CuentaBancaria) unMedioDePago;
	        
	        if(this.cliente.getNombre().equals(cuenta.getTitular())) {
	        	return true;
	        }
	    } else if (unMedioDePago instanceof CuentaVirtual) {
	        CuentaVirtual cuenta = (CuentaVirtual) unMedioDePago;
	        if(this.cliente.getNombre().equals(cuenta.getTitular())) {
	        	return true;
	        }
	    }
	    	 
	    	throw new NoCoincideTitularException("el titular no ");
	    
		
		
	}

	@Override
	public void realizarPago(Compra compra) {
		//1) Recibo la compra
		//2) Valido que la billetera tenga el comercio
		//3) Valido que la billetera tenga el medio de pago
		//4) Verifico que medio de pago es
		//5) Realizo el pago 
		//6) Registro la compra en la billetara
		//7) Registro la compra en el comerio
		
		
		try {
			validarComercioEnBilletera(compra.getComercio());
			validarMedioDePagoEnBilletera(compra.getMedioDePago());
			MedioDePago medioDePago = obtenerQueMedioDePagoEs(compra.getMedioDePago());
			realizoElPago(compra, medioDePago);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void realizoElPago(Compra compra, Object medioDePago) throws SaldoInsuficienteException {
		if (medioDePago instanceof TarjetaDeCredito) {
		    TarjetaDeCredito tarjeta = (TarjetaDeCredito) medioDePago;
		    tarjeta.realizarPago(compra);
		} else if (medioDePago instanceof TarjetaDeDebito) {
		    TarjetaDeDebito tarjeta = (TarjetaDeDebito) medioDePago;
		    // Realiza operaciones con la tarjeta
		} else if (medioDePago instanceof CuentaVirtual) {
		    CuentaVirtual cuenta = (CuentaVirtual) medioDePago;
		    // Realiza operaciones con la cuenta virtual
		} else if (medioDePago instanceof CuentaBancaria) {
		    CuentaBancaria cuenta = (CuentaBancaria) medioDePago;
		    // Realiza operaciones con la cuenta bancaria
		}
		
	}

	private MedioDePago obtenerQueMedioDePagoEs(MedioDePago medioDePago) throws MedioDePagoNoVerificadoException {
    if (medioDePago instanceof TarjetaDeCredito) {
        TarjetaDeCredito tarjeta = (TarjetaDeCredito) medioDePago;
        return tarjeta;
    } else if (medioDePago instanceof TarjetaDeDebito) {
        TarjetaDeDebito tarjeta = (TarjetaDeDebito) medioDePago;
        return tarjeta;
    } else if (medioDePago instanceof CuentaVirtual) {
        CuentaVirtual cuenta = (CuentaVirtual) medioDePago;
        return cuenta;
    } else if (medioDePago instanceof CuentaBancaria) {
        CuentaBancaria cuenta = (CuentaBancaria) medioDePago;
        return cuenta;
    } 
    throw new MedioDePagoNoVerificadoException("Medio de pago no verificado");
}

	private Boolean validarMedioDePagoEnBilletera(MedioDePago medioDePago) throws MedioDePagoNoDisponibleException {

		if(this.mediosDePago.contains(medioDePago)) {
			return true;
		}
		throw new MedioDePagoNoDisponibleException("Medio de pago no encontrado");
	}

	private Boolean validarComercioEnBilletera(Comercio comercio) throws ComercioInvalidadException {
		if(this.comercios.contains(comercio)) {
			return true;
		}
		throw new ComercioInvalidadException("Comercio no adherido");
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
	public void realizarPago() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList <Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList <Compra> compras) {
		this.compras = compras;
	}

	@Override
	public void realizarPago(Double monto) {
		// TODO Auto-generated method stub
		
	}

}
