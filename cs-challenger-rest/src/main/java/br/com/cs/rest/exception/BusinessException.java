package br.com.cs.rest.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -682202173376339549L;

	private final String mensagem;

	public BusinessException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
