package br.com.cs.rest.exception;

public class TokenExpiredException extends BusinessException {
	private static final long serialVersionUID = 6816629521818258947L;

	public TokenExpiredException(String mensagem) {
		super(mensagem);
	}
	
}
