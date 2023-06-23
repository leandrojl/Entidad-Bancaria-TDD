package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.clientes.Cliente;
import ar.edu.unlam.pb2.clientes.Comercio;
import ar.edu.unlam.pb2.clientes.Persona;
import ar.edu.unlam.pb2.entidadBancaria.BilleteraVirtual;
import ar.edu.unlam.pb2.entidadBancaria.Cuenta;
import ar.edu.unlam.pb2.entidadBancaria.CuentaBancaria;
import ar.edu.unlam.pb2.entidadBancaria.CuentaVirtual;
import ar.edu.unlam.pb2.entidadBancaria.Pagadora;
import ar.edu.unlam.pb2.entidadBancaria.Tarjeta;
import ar.edu.unlam.pb2.entidadBancaria.TarjetaDeCredito;
import ar.edu.unlam.pb2.entidadBancaria.TarjetaDeDebito;
import ar.edu.unlam.pb2.excepciones.CBUInvalidoException;
import ar.edu.unlam.pb2.excepciones.CVUInvalidoException;
import ar.edu.unlam.pb2.excepciones.CuitInvalidoException;
import ar.edu.unlam.pb2.excepciones.NoCoincideTitularException;
import ar.edu.unlam.pb2.excepciones.NumeroDeTarjetaInvalidoException;
import ar.edu.unlam.pb2.excepciones.SaldoInsuficienteException;
import ar.edu.unlam.pb2.interfaces.MedioDePago;

public class TestCases {

	@Test
	public void queSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 5446789813221201L;
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final Double SALDO_ESPERADO = 10000.0;
		
		// Ejecuci�n
		Tarjeta tarjetaDeDebito= cuandoCreoUnaTarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);
		//Tarjeta tarjetaDeDebito = new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);
		tarjetaDeDebito.setSaldo(10000.0);
		
		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeDebito.getNumeroDeTarjeta());
		assertEquals(TITULAR_ESPERADO, tarjetaDeDebito.getTitularDeLaTarjeta());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeDebito.getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeDebito.getFechaVencimiento());
		assertEquals(SALDO_ESPERADO, tarjetaDeDebito.getSaldo());
	}
	
	
	@Test(expected=NumeroDeTarjetaInvalidoException.class)
	public void queNoSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 1115446789813221201L;
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final Double SALDO_ESPERADO = 10000.0;
		
		// Ejecuci�n
		Tarjeta tarjetaDeDebito= cuandoCreoUnaTarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);
		//Tarjeta tarjetaDeDebito = new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);
		
	}

	@Test
	public void queSePuedaCrearUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 4246789813221201L;
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final Double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final Double LIMITE_COMPRA_EN_DOLARES = 1000.0;
		
		// Ejecuci�n
		Tarjeta tarjetaDeCredito = new TarjetaDeCredito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, LIMITE_COMPRA_EN_PESOS, LIMITE_COMPRA_EN_DOLARES);

		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeCredito.getNumeroDeTarjeta());
		assertEquals(TITULAR_ESPERADO, tarjetaDeCredito.getTitularDeLaTarjeta());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeCredito.getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeCredito.getFechaVencimiento());
		assertEquals(LIMITE_COMPRA_EN_PESOS, ((TarjetaDeCredito)tarjetaDeCredito).getLimiteDeCompraEnPesos());
		assertEquals(LIMITE_COMPRA_EN_DOLARES, ((TarjetaDeCredito)tarjetaDeCredito).getLimiteDeCompraEnDolares());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaBancaria() throws CBUInvalidoException{
		// Preparaci�n 
		final String CBU_ESPERADO = "01702046600000087865";
		final String ENTIDAD_ESPERADA = "Santander";
		final String TITULAR_ESPERADO = "Vicente De La Pradera";
		final Integer NUMERO_CUENTA = 1;
		
		// Ejeruci�n
		Cuenta cuentaBancaria = new CuentaBancaria(NUMERO_CUENTA,CBU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CBU_ESPERADO, ((CuentaBancaria)cuentaBancaria).getCbu());
		assertEquals(ENTIDAD_ESPERADA, ((CuentaBancaria)cuentaBancaria).getEntidadBancaria());
		assertEquals(TITULAR_ESPERADO, ((CuentaBancaria)cuentaBancaria).getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaVirtual() throws CVUInvalidoException{
		// Preparaci�n 
		final String CVU_ESPERADO = "46467898132212011234552";
		final String ENTIDAD_ESPERADA = "Mercado Pago";
		final String TITULAR_ESPERADO = "Leticia Bridgeton";
		final Integer NUMERO_CUENTA = 1;
		
		// Ejecuci�n
		Cuenta cuentaVirtual = new CuentaVirtual(NUMERO_CUENTA,CVU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CVU_ESPERADO, ((CuentaVirtual)cuentaVirtual).getCvu());
		assertEquals(ENTIDAD_ESPERADA, ((CuentaVirtual)cuentaVirtual).getEntidadBancaria());
		assertEquals(TITULAR_ESPERADO, ((CuentaVirtual)cuentaVirtual).getTitular() );
	}
	
	@Test
	public void queSePuedaCrearUnComercio() throws CuitInvalidoException{
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "El almacen de la esquina";
		final Long CUIT_ESPERADO = 30215654124L;
		
		// Ejecuci�n
		Comercio elAlmacen = new Comercio(CUIT_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, elAlmacen.getNombre());
		assertEquals(CUIT_ESPERADO, elAlmacen.getCuit());
	}
	
	@Test
	public void queSePuedaCrearUnCliente() {
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "Erika Romeo";
		final Integer DNI_ESPERADO = 33458712;
		
		// Ejecuci�n
		Cliente nuevo = new Cliente(DNI_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, nuevo.getNombre());
		assertEquals(NOMBRE_ESPERADO, nuevo.getDni());
	}
	
	@Test
	public void queSePuedanAgregar2ComerciosALaBilletera() throws CuitInvalidoException{
		// Preparaci�n 
		
		// Ejecuci�n
		BilleteraVirtual mataGalan = new BilleteraVirtual("Ank");
		
		mataGalan.agregarComercio(new Comercio(30456213545L, "Supermercado"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));
		
		
		// Verificaci�n
		assertEquals(2, mataGalan.getComercios().size());
	}
	
//	@Test
//	public void queSePuedanAgregar3ClientesALaBilletera() {
//		// Preparaci�n 
//		
//		
//		// Ejecuci�n
//		BilleteraVirtual mataGalan = new BilleteraVirtual("Bna+");
//		
//		mataGalan.agregarCliente(new Cliente(27541231, "Luis Gomez"));
//		mataGalan.agregarCliente(new Cliente(27541231, "Luis Gomez"));
//		mataGalan.agregarCliente(new Cliente(36541231, "Sofia Molina"));
//		
//		// Verificaci�n
//		assertEquals(3, mataGalan.getClientes().size());
//	}
	
	@Test
	public void queSePuedanAgregarDistintosMediosDePagoALaBilleteraDeUnCliente() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, NoCoincideTitularException{
		// Preparaci�n tarjeta de credito
		final Long NUMERO_TARJETA = 4246789813121201L;
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final Double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final Double LIMITE_COMPRA_EN_DOLARES = 1000.0;
		final Integer CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS = 5;
		
		//Preparacion cuenta bancaria
		final Integer NUMERO_DE_CUENTA = 1;
		final String NUMERO_CBU = "01702046600000087865";
		final String ENTIDAD_BANCARIA = "Naci�n";
		final String TITULAR_CUENTA_BANCARIA = "Luis Gomez";
		
		//Preparacion cuenta virtual
		final Integer NUMERO_DE_CUENTA2 = 2;
		final String NUMERO_CVU = "0000003100036521571806";
		final String ENTIDAD_BANCARIA2 = "Naci�n";
		final String TITULAR_CUENTA_VIRTUAL = "Luis Gomez";
		
		// Ejecuci�n
		Cliente cliente = new Cliente(27541231, "Luis Gomez");
		
		BilleteraVirtual mataGalan = new BilleteraVirtual(1,"MercadoPago");
		
		
		
		TarjetaDeCredito tarjetaDeCredito = cuandoCreoUnaTarjetaDeCredito(NUMERO_TARJETA,TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO,CODIGO_DE_SEGURIDAD_ESPERADO,LIMITE_COMPRA_EN_PESOS,LIMITE_COMPRA_EN_DOLARES);
		
		CuentaBancaria cuentaBancaria = cuandoCreoUnaCuentaBancaria(NUMERO_DE_CUENTA,NUMERO_CBU, ENTIDAD_BANCARIA, TITULAR_CUENTA_BANCARIA);
		
		CuentaVirtual cuentaVirtual = cuandoCreoUnaCuentaVirtual(NUMERO_DE_CUENTA2,NUMERO_CVU, ENTIDAD_BANCARIA2, TITULAR_CUENTA_VIRTUAL);
		
		mataGalan.setCliente(cliente);
		
		cliente.agregarBilletera(mataGalan);
		
		mataGalan.agregarMedioDePago(tarjetaDeCredito);
		
		mataGalan.agregarMedioDePago(new TarjetaDeDebito(48332562153254623L, "Luis Gomez", "10/10/2026", 312));
		
		mataGalan.agregarMedioDePago(new TarjetaDeCredito(5423542385612354L, "Luis Gomez", "10/10/2026", 153));
		
		mataGalan.agregarMedioDePago(cuentaBancaria);
		
		mataGalan.agregarMedioDePago(cuentaVirtual);
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS, ((Integer)mataGalan.getMediosDePago().size()));
	}
	
//	@Test
//	public void queSePuedaPagarConUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException{
//		// Preparaci�n 
//		Billetera mataGalan = new Billetera("Ank");
//		mataGalan.agregarConsumidor(Consumidor(27541231, "Luis Gomez");
//		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(48332562153254623L, "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0));
//		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
//		// Ejecuci�n	
//		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1000.0);
//		Boolean resultado = mataGalan.pagar(codigoQR, mataGalan.getConsumidor(27541231).getMedioPagador(48332562153254623L));
//		
//		// Verificaci�n
//		assertTrue(resultado);
//	}
//	
//	@Test
//	public void queSePuedaTransferirDeUnaCuentaAOtra() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, SaldoInsuficienteException{
//		// Preparaci�n 
//		Billetera mataGalan = new Billetera("Ual�");
//		Transferible cuentaOrigen = new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez");
//		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
//		mataGalan.agregarConsumidor(consumidorOrigen);
//		mataGalan.agregarMedioDePago(27541231, cuentaOrigen);
//		
//		Transferible cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
//		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
//		mataGalan.agregarConsumidor(consumidorDestino);
//		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
//				
//		// Ejecuci�n
//		Boolean resultado = mataGalan.transferir(cuentaOrigen, cuentaDestino);
//				
//		// Verificaci�n
//		assertTrue(resultado);
//	}
//	
//	@Test (expected=SaldoInsuficienteException.class)
//	public void queNoSePuedaTransferirSiElSaldoNoEsSuficiente() {
//
//	}
//	
//	@Test (expected=SaldoInsuficienteException.class)
//	public void queNoSePuedaComprarSiElSaldoDeLaTarjetaDeDebitoEsInsuficiente() {
//
//	}
//	
//	@Test (expected=ExcedeLimiteDeCompraException.class)
//	public void queNoSePuedaComprarSiSeExcedeElLimiteDeCompraDeLaTarjetaDeCredito() {
//
//	}
	
	private CuentaVirtual cuandoCreoUnaCuentaVirtual(Integer nUMERO_DE_CUENTA2, String nUMERO_CVU,
			String eNTIDAD_BANCARIA2, String tITULAR_CUENTA_VIRTUAL) throws CVUInvalidoException {
		validarCvu(nUMERO_CVU);
		return new CuentaVirtual(nUMERO_DE_CUENTA2,nUMERO_CVU, eNTIDAD_BANCARIA2, tITULAR_CUENTA_VIRTUAL);
	}


	private Boolean validarCvu(String nUMERO_CVU) throws CVUInvalidoException {
		if (nUMERO_CVU.matches("\\b\\d{22}\\b")) {
			
		    return true;
		
		} else {
			
		    throw new CVUInvalidoException("numero incorrecto de cvu");
		}
		
	}


	private CuentaBancaria cuandoCreoUnaCuentaBancaria(Integer nUMERO_DE_CUENTA, String nUMERO_CBU,
			String eNTIDAD_BANCARIA, String tITULAR_CUENTA_BANCARIA) throws CBUInvalidoException {
		validarCbu(nUMERO_CBU);
		return new CuentaBancaria(nUMERO_DE_CUENTA,nUMERO_CBU, eNTIDAD_BANCARIA, tITULAR_CUENTA_BANCARIA);
	}


	private Boolean validarCbu(String nUMERO_CBU) throws CBUInvalidoException {
			if (nUMERO_CBU.matches("\\b\\d{20}\\b")) {
			
		    return true;
		
		} else {
			
		    throw new CBUInvalidoException("numero incorrecto de cbu");
		}
		
	}


	private TarjetaDeCredito cuandoCreoUnaTarjetaDeCredito(Long nUMERO_TARJETA, String tITULAR_ESPERADO,
			String fECHA_DE_VENCIMIENTO_ESPERADO, Integer cODIGO_DE_SEGURIDAD_ESPERADO, Double lIMITE_COMPRA_EN_PESOS,
			Double lIMITE_COMPRA_EN_DOLARES) throws NumeroDeTarjetaInvalidoException {
		
		validarNumeroTarjeta(nUMERO_TARJETA);
		return new TarjetaDeCredito(nUMERO_TARJETA, tITULAR_ESPERADO,
			fECHA_DE_VENCIMIENTO_ESPERADO, cODIGO_DE_SEGURIDAD_ESPERADO, lIMITE_COMPRA_EN_PESOS, lIMITE_COMPRA_EN_DOLARES);
		
	}


	private Boolean validarNumeroTarjeta(Long nUMERO_TARJETA) throws NumeroDeTarjetaInvalidoException {
		String numeroString = Long.toString(nUMERO_TARJETA);
		if (numeroString.matches("\\d{16}")) {
			
		    return true;
		
		} else {
			
		    throw new NumeroDeTarjetaInvalidoException("numero incorrecto de tarjeta");
		}
		
	}


	private Tarjeta cuandoCreoUnaTarjetaDeDebito(Long NUMERO_ESPERADO, String TITULAR_ESPERADO,
			String FECHA_DE_VENCIMIENTO_ESPERADO, Integer CODIGO_DE_SEGURIDAD_ESPERADO) throws NumeroDeTarjetaInvalidoException {

		String numeroString = Long.toString(NUMERO_ESPERADO);

		// Verificar si NUMERO_ESPERADO es un n�mero v�lido
		if (numeroString.matches("\\d{16}")) {
			
		    return new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);
		
		} else {
			
		    throw new NumeroDeTarjetaInvalidoException("numero incorrecto de tarjeta");
		}
		
	}
	
	
	}


