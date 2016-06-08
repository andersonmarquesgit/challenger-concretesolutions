package br.com.cs.rest.validation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cs.rest.exception.LoginException;
import br.com.cs.rest.model.User;
import br.com.cs.rest.model.to.LoginTO;
import br.com.cs.rest.service.LoginService;
import br.com.cs.rest.service.TokenService;
import br.com.cs.rest.service.UserService;

@Component
public class LoginValidator implements Validator {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginTO.class.equals(clazz);
	}

	@Override
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public void validate(Object target, Errors err) {
		LoginTO l = (LoginTO) target;
        User user = loginService.login(l);
		
		if(user == null) {
			throw new LoginException("Usuário e/ou senha inválidos");
		}else if(!user.getPassword().equals(userService.encryptPassword(l.getPassword()))) {
			throw new LoginException("Usuário e/ou senha inválidos");
		}
		
		String token = tokenService.encodeToken(user);
		if(!user.getToken().equals(token)) {
			throw new LoginException("Não autorizado");
		}else if(user.getLastLogin().after(new Date(new Date().getTime() + 30 * 60 * 1000))) {
			throw new LoginException("Sessão inválida");
		}
	}

}
