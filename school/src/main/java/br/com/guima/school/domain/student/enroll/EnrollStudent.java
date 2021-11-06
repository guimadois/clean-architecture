package br.com.guima.school.domain.student.enroll;

import br.com.guima.school.domain.student.Student;
import br.com.guima.school.domain.student.StudentRepository;

public class EnrollStudent {

	private final StudentRepository repository;
	
	public EnrollStudent(StudentRepository repository) {
		this.repository = repository;
	}
	
	public void execute(EnrollStudentDTO dto) {
		
		Student student = dto.createStudent();
		repository.enroll(student);
	}
}
