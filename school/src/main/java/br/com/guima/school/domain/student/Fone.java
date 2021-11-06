package br.com.guima.school.domain.student;

import lombok.Data;

@Data
public class Fone {

	private String ddd;
	private String number;
	
	public Fone(String ddd, String number) {
		this.ddd = ddd;
		this.number = number;
	}
}
