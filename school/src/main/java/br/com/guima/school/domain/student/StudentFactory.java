package br.com.guima.school.domain.student;

import lombok.Data;

@Data
public class StudentFactory {

	private Student student;
	
	public StudentFactory withNameCPFAndEmail(String name, String cpf, String email) {
		
		this.student = new Student(new CPF(cpf), name, new Email(email));
		return this;
	}
	
	public StudentFactory withFone(String ddd, String numero) {
		
		this.student.addFone(ddd, numero);
		return this;
	}
	
	public Student getStudent() {
		
		return this.student;
	}
}
