package br.com.cs.rest.exception;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import br.com.cs.rest.util.CollectionUtil;

public class ExceptionTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagem;

	public ExceptionTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}