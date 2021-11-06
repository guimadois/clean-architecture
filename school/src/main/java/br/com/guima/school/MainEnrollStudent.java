package br.com.guima.school;

import br.com.guima.school.domain.student.Student;
import br.com.guima.school.domain.student.StudentFactory;
import br.com.guima.school.domain.student.StudentRepository;
import br.com.guima.school.infra.student.MemoryStudentRepositoryImpl;

public class MainEnrollStudent {

	public static void main(String[] args) {
		
		StudentFactory factory = new StudentFactory();
		
		Student student = factory.withNameCPFAndEmail("João da Silva", 
													  "123.456.789-00", 
													  "jsilva@email.com")
								 .withFone("44", "90000000")
								 .getStudent();		
		
		StudentRepository repository = new MemoryStudentRepositoryImpl();
		repository.enroll(student);
		
	}
}
