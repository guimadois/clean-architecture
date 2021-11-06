package br.com.guima.school.domain.student;

public interface EncryptPassword {

	String encrypt(String password);
	
	boolean validatePassword(String encryptPassword, String password);
}
