package br.com.cs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cs.rest.model.User;
import br.com.cs.rest.model.to.LoginTO;
import br.com.cs.rest.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepository;
	
	public User login(LoginTO loginTO) {
		return userRepository.findByEmail(loginTO.getEmail());
	}

}
