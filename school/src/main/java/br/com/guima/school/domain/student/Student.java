package br.com.guima.school.domain.student;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Student {

	//ENTITY
	
	private CPF cpf; 
	private String name;
	private Email email;
	private List<Fone> fones = new ArrayList<Fone>();
	private String password;
	
	public Student(CPF cpf, String name, Email email) {
	
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}
	
	public void addFone(String ddd, String number) {
		
		this.fones.add(new Fone(ddd, number));
	}	
}
