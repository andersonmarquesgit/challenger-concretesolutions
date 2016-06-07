package br.com.cs.rest.exception;

public class LoginException extends BusinessException {
	private static final long serialVersionUID = 6816629521818258947L;

	public LoginException(String mensagem) {
		super(mensagem);
	}
	
}
