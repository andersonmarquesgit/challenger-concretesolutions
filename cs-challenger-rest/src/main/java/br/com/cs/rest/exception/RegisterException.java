package br.com.cs.rest.exception;

public class RegisterException extends BusinessException {
	private static final long serialVersionUID = 6816629521818258947L;
	
	public RegisterException(String mensagem) {
		super(mensagem);
	}
}
