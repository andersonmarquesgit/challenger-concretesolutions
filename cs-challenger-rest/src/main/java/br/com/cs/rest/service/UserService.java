package br.com.cs.rest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cs.rest.model.User;
import br.com.cs.rest.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		user.setCreated(new Date());
		user.setModified(new Date());
		user.setLastLogin(new Date());
		
		return userRepository.save(user);
	}

}
