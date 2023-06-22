package ar.edu.unlam.pb2.interfaces;

public interface MedioDePago {
	void realizarPago();
	void verificarDisponibilidad();
	void obtenerTransaccionesRecientes();
	void cancelarPago();
	void generarToken();

}
