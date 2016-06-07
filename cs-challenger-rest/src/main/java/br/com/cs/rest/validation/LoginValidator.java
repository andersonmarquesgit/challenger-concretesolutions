package br.com.cs.rest.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.cs.rest.model.User;
import br.com.cs.rest.model.to.LoginTO;
import br.com.cs.rest.service.LoginService;

@Component
public class LoginValidator implements Validator {

	@Autowired
	private LoginService loginService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		LoginTO l = (LoginTO) target;
        User user = loginService.login(l);
		
		if(user == null){
			err.rejectValue("email","user.email", "Usuário e/ou senha inválidos");
		}else if(!user.getPassword().equals(l.getPassword())) {
			err.rejectValue("password","user.password", "Usuário e/ou senha inválidos");
		}
		
	}

}
