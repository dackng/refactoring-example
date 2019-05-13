package config;

public class LoggerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public LoggerException(String mensaje) {
		super(mensaje);
	}
}