package br.com.cs.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cs.rest.model.User;
import br.com.cs.rest.model.to.LoginTO;
import br.com.cs.rest.service.LoginService;
import br.com.cs.rest.validation.LoginValidator;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired 
	private LoginValidator loginValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(loginValidator);
	}
	
	@RequestMapping(value = "/login", 
			method = RequestMethod.POST, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User login(@Valid @RequestBody LoginTO loginTO) {
		return loginService.login(loginTO);
	}
}
