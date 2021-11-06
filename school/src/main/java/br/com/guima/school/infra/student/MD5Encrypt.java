package br.com.guima.school.infra.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.guima.school.domain.student.EncryptPassword;

public class MD5Encrypt implements EncryptPassword {

	@Override
	public String encrypt(String password) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			return sb.toString();			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error: encrypt password failure: " + e.getMessage());
		}
	}

	@Override
	public boolean validatePassword(String encryptPassword, String password) {
		
		return encryptPassword.equals(encrypt(password));
	}

}
