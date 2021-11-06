package br.com.guima.school.domain.student.enroll;

import br.com.guima.school.domain.student.Student;
import br.com.guima.school.domain.student.StudentFactory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnrollStudentDTO {

	private String name;
	private String cpf;
	private String email;
	private String ddd;
	private String fone;
	
	public Student createStudent() {
		StudentFactory factory = new StudentFactory();
		
		return factory.withNameCPFAndEmail(this.name, 
										   this.cpf, 
										   this.email)
								 .withFone(this.ddd, this.fone)
								 .getStudent();		
	}
}
