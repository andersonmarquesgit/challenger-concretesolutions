package br.com.cs.rest.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.cs.rest.model.User;

public class UserValidator implements Validator {

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
		if(u.getName().equals("Anderson")){
			err.rejectValue("name","name.anderson", "O nome é anderson");
		}
		
	}

}
