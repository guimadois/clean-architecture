package br.com.guima.school.domain.student;

import lombok.Data;

@Data
public class Email {

	//VALUE OBJECT
	
	private static final String REGEX_EMAIL = "/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i";
	
	private String endereco;
	
	public Email(String endereco) {
	
		validateEmailFormat(endereco);		
		this.endereco = endereco;
	}

	private void validateEmailFormat(String endereco2) {
		
		if (endereco == null || !endereco.matches(REGEX_EMAIL)) {
			throw new IllegalArgumentException("Error format e-mail!");
		}	
	}
}
