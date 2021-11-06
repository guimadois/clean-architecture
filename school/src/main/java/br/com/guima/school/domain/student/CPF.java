package br.com.guima.school.domain.student;

import lombok.Data;

@Data
public class CPF {

	private static final String REGEX_CPF = "/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/";
	private String number;
	
	public CPF(String number) {
		
		validateFormat(number);
		
		this.number = number;
	}

	private void validateFormat(String number) {
		
		if (number == null || !number.matches(REGEX_CPF)) {
			throw new IllegalArgumentException("Error CPF format inválid!");
		}	
	}
}
