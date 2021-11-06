package br.com.guima.school.infra.student;

import java.util.ArrayList;
import java.util.List;

import br.com.guima.school.domain.student.CPF;
import br.com.guima.school.domain.student.Student;
import br.com.guima.school.domain.student.StudentNotFoundException;
import br.com.guima.school.domain.student.StudentRepository;

public class MemoryStudentRepositoryImpl implements StudentRepository {

	private List<Student> enrolledStudents = new ArrayList<>();
	
	@Override
	public void enroll(Student student) {
		
		this.enrolledStudents.add(student);
	}

	@Override
	public Student finbByCPF(CPF cpf) {
		
		return this.enrolledStudents.stream()
					.filter(student -> student.getCpf().getNumber().equals(cpf.getNumber()))
					.findFirst()
					.orElseThrow(() -> new StudentNotFoundException(cpf));
	}

	@Override
	public List<Student> listAllEnrolledStudents() {
		
		return this.enrolledStudents;
	}

}
