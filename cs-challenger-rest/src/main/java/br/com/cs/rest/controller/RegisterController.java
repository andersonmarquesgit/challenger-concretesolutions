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
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>( userService.save(user), HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/",
			method = RequestMethod.GET, 
	        produces = "application/json")
	public ResponseEntity<User> get() {

		User user = new User();
		user.setName("Anderson");
		user.setEmail("anderson@teste");

		Phone p1 = new Phone();
		p1.setDdd(21);
		p1.setNumber(987654321);
		
		Phone p2 = new Phone();
		p2.setDdd(11);
		p2.setNumber(999998888);
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(p1);
		phones.add(p2);
		
		user.setPhones(phones);
		
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
