package com.utad.curso.desarrollo.seguro.config.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // para que se guarde la clase en el contexto y al preguntar por
			// userdetailservide le de esta
public class CustomPasswordEncoder implements PasswordEncoder {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String passwordHash = hash(rawPassword.toString());
		logger.info("passwordHash:" + passwordHash);
		logger.info("encodedPassword:" + encodedPassword);
		return passwordHash.equals(encodedPassword);
	}

	public String hash(String passEntrada) {

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			String response = new String();
			response = "Invalid algorithm";
			return response;
		}

		byte[] hashBytes = messageDigest.digest(passEntrada.getBytes());
		String hashHexString = DatatypeConverter.printHexBinary(hashBytes);

		return hashHexString;

	}

}
