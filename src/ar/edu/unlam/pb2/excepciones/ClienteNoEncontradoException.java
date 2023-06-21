package ar.edu.unlam.pb2.excepciones;

import ar.edu.unlam.pb2.clientes.Cliente;

public class ClienteNoEncontradoException extends Exception {
	
	public ClienteNoEncontradoException(String mensaje) {
		super(mensaje);
	}

}
