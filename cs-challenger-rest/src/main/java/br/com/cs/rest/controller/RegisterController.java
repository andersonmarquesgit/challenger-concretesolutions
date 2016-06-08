package br.com.cs.rest.controller;

import java.util.ArrayList;
import java.util.List;

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

import br.com.cs.rest.model.Phone;
import br.com.cs.rest.model.User;
import br.com.cs.rest.service.UserService;
import br.com.cs.rest.validation.UserValidator;


@RestController
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired 
	private UserValidator userValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(userValidator);
	}
	
	@RequestMapping(value = "/cadastro", 
			method = RequestMethod.POST, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User saveUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}
	
	@RequestMapping(value = "/",
			method = RequestMethod.GET, 
	        produces = "application/json")
	public @ResponseBody List<User> get() {
		return userService.findAll();
	}
}
