package br.com.cs.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RegisterException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ExceptionTO handleException(RegisterException ex) {
		return new ExceptionTO(ex.getMensagem());
	}
	
	@ExceptionHandler(LoginException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody ExceptionTO handleException(LoginException ex) {
		return new ExceptionTO(ex.getMensagem());
	}
}
