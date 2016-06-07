package br.com.cs.rest.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.cs.rest.model.User;
import br.com.cs.rest.service.UserService;

public class UserValidator implements Validator {

	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "name", "name.empty",  "Nome é obrigatório.");

		User u = (User) target;
        
        //perform additional checks
        //if name already exists or ?
		if(userService.isEmailExist(u.getEmail())){
			err.rejectValue("email","email.exist", "E-mail já existente");
		}
		
	}

}
