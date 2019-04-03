package exceptionsSube;

public class ExceptionSaldoInsuficiente extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439520783817531000L;

	public ExceptionSaldoInsuficiente() {
		super("No hay saldo suficiente para la transaccion, Pobre");
	}

}
