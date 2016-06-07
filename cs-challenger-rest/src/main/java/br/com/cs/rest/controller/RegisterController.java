package br.com.cs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cs.rest.model.User;
import br.com.cs.rest.service.UserService;


@RestController
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/")
	public ResponseEntity<User> get() {

		User user = new User();
		user.setName("Anderson");
		user.setEmail("anderson@teste");

	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
