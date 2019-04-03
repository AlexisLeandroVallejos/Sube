package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;
import exceptionsSube.*;

public class SubeTest {
	
	@Test
	public void recargar_CargueSube200PesosTeniendoSaldo0()
	{
		
		Sube tarjeta = new Sube(new Persona());
		tarjeta.recargar(200);
		Assert.assertEquals("No se pudo recargar la tarjeta con 200",200.0, tarjeta.getSaldo(), 0);
	}
	

	@Test
	public void pagar_PagaViajeDe90ConSaldo50()
	{
		Sube tarjeta = new Sube(new Persona());
		tarjeta.recargar(50);
		Servicio viaje = new Servicio();
		viaje.setCosto(90);
		tarjeta.pagar(viaje);
		Assert.assertEquals("No se pudo pagar 90 con la tarjeta con 50",-40.0, tarjeta.getSaldo(), 0);
	}
	


	@Test
	public void pagar_PagaViajeDe89p90CConSaldo50()
	{
		Sube tarjeta = new Sube(new Persona());
		tarjeta.recargar(50.60);
		Servicio viaje = new Servicio();
		viaje.setCosto(90.5);
		tarjeta.pagar(viaje);
		Assert.assertEquals("No se pudo pagar 90 con la tarjeta con 50",-39.90, tarjeta.getSaldo(), 0);

	}
	

	@Test(expected=ExceptionSaldoInsuficiente.class)
	public void pagar_PagaViajeDe90P20CConSaldo50P30C()
	{
		Sube tarjeta = new Sube(new Persona());
		tarjeta.recargar(50.30);
		Servicio viaje = new Servicio();
		viaje.setCosto(90.5);
		tarjeta.pagar(viaje);
		
	}
	
	@Test(expected=ExceptionSaldoInsuficiente.class)
	public void pagar_NoPuedoPagarViajeDe1000ConSaldo0()
	{
		
		Sube tarjeta = new Sube(new Persona());
		tarjeta.recargar(0);
		Lugar cosa = new Lugar();
		cosa.setCosto(1000);
		tarjeta.pagar(cosa);
	}
}
