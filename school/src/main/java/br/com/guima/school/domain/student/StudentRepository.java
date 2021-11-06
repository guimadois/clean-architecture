package br.com.guima.school.domain.student;

import java.util.List;

public interface StudentRepository {

	void enroll(Student student);
	
	Student finbByCPF(CPF cpf);
	
	List<Student> listAllEnrolledStudents();
	
	//...
}
