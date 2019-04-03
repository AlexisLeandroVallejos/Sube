package modelo;

import exceptionsSube.ExceptionSaldoInsuficiente;

public class Sube {
	private Persona persona;
	private int codigo;
	private double saldo;
	private double maxSaldoNeg = -40;
	
	boolean esMedioDePago = true;

	public Sube(Persona p)
	{
		this.persona = p;
	}
	 
	public void recargar(double cantidad) {
		saldo += cantidad;
	}

	public void pagar(Servicio cosa) {
		
		if(this.puedoPagar(cosa.getCosto()))
		{
			saldo = saldo - cosa.getCosto();
		}
		else 
		{
			throw new ExceptionSaldoInsuficiente();
		}
		
	}
	
	public boolean puedoPagar(double costo)
	{
		return saldo - costo >= maxSaldoNeg;
		
	}
	
	public void descartar() {
		esMedioDePago = false;
		//MinisterioDeTransporte.generarNuevaTarjeta();
	}

	public double getSaldo() {
		return saldo;
	}

}
