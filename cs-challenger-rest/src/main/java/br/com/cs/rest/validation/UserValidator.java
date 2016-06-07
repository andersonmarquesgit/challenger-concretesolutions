package br.com.cs.rest.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cs.rest.exception.RegisterException;
import br.com.cs.rest.model.User;
import br.com.cs.rest.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	@ResponseStatus(HttpStatus.CONFLICT)
	public void validate(Object target, Errors err) {
		User u = (User) target;
        
		if(userService.isEmailExist(u.getEmail())){
			throw new RegisterException("E-mail já existente");
		}
		
	}

}
