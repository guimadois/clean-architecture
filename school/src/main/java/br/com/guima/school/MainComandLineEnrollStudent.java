package br.com.guima.school;

import br.com.guima.school.domain.student.enroll.EnrollStudent;
import br.com.guima.school.domain.student.enroll.EnrollStudentDTO;
import br.com.guima.school.infra.student.MemoryStudentRepositoryImpl;

public class MainComandLineEnrollStudent {

	public static void main(String[] args) {
		
		String name = "José Souza";
		String cpf = "789.456.123-00";
		String email = "jsouza@email.com";
		String ddd = "44";
		String fone = "91111111";
		
		EnrollStudent enroll = new EnrollStudent(new MemoryStudentRepositoryImpl());
		enroll.execute(new EnrollStudentDTO(name, cpf, email, ddd, fone));
	}
}
