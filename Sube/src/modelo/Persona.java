package modelo;

public class Persona {
	String nombre;
	String apellido;
	Sube tarjeta;
	
	public void tarjetaExtraviada() {
		tarjeta.descartar();
	}
	public void tarjetaRobada() {
		tarjeta.descartar();
	}
}
