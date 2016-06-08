package br.com.cs.rest.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;

import br.com.cs.rest.model.User;

@Service
public class TokenService {

	public String encodeToken(User user) {

		JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256),
				new Payload(user.getEmail()));
		
		byte[] sharedKey = new byte[32];
//		new SecureRandom().nextBytes(sharedKey);

		try {
			jwsObject.sign(new MACSigner(sharedKey));
		} catch (JOSEException e) {
			e.printStackTrace();
		}

		return jwsObject.serialize();
	}

}
