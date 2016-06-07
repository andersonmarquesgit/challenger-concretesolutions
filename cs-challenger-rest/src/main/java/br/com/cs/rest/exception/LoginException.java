package br.com.cs.rest.exception;

public class LoginException extends RuntimeException {
	private static final long serialVersionUID = 6816629521818258947L;
	
	private final String mensagem;

	public LoginException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
