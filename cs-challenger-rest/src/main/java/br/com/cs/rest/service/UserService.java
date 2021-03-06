package br.com.cs.rest.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cs.rest.model.Phone;
import br.com.cs.rest.model.User;
import br.com.cs.rest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenService tokenService;
	
	public User save(User user) {
		user.setCreated(new Date());
		user.setModified(new Date());
		user.setLastLogin(new Date());
		user.setToken(tokenService.encodeToken(user));
		user.setPassword(encryptPassword(user.getPassword()));
		
		List<Phone> phones = user.getPhones();
		for (Phone phone : phones) {
			phone.setUser(user);
		}
		
		return userRepository.save(user);
	}

	public boolean isEmailExist(String email) {
		return userRepository.findByEmail(email) == null ? false : true;
	}
	
	public String encryptPassword(String password) {
		if(password == null){
			return password;
		}
		
		MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			
			return hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return password;
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
}
