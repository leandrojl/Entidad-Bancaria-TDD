package ar.edu.unlam.pb2.interfaces;

import ar.edu.unlam.pb2.eventos.Compra;

public interface MedioDePago {
	void realizarPago();
	void verificarDisponibilidad();
	void obtenerTransaccionesRecientes();
	void cancelarPago();
	void generarToken();
	void realizarPago(Compra compra);
	void realizarPago(Double monto);

}
