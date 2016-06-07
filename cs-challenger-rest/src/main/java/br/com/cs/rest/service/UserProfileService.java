package br.com.cs.rest.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cs.rest.model.User;
import br.com.cs.rest.repository.UserRepository;

@Service
public class UserProfileService {

	@Autowired
	UserRepository userRepository;

}
