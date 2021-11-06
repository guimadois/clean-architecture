package br.com.guima.school.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.guima.school.domain.student.CPF;
import br.com.guima.school.domain.student.Email;
import br.com.guima.school.domain.student.Fone;
import br.com.guima.school.domain.student.Student;
import br.com.guima.school.domain.student.StudentNotFoundException;
import br.com.guima.school.domain.student.StudentRepository;

public class JDBCStudentRepositoryImpl implements StudentRepository {

	protected final static String SQL_INSERT_STUDENT = "INSERT INTO STUDENT VALUES(?, ?, ?)";
	protected final static String SQL_INSERT_FONE = "INSERT INTO FONE VALUES (?, ?)";
	protected final static String SQL_SELECT_STUDENT = "SELECT id, cpf, name, email FROM STUDENT";
	protected final static String SQL_SELECT_STUDENT_BY_CPF = SQL_SELECT_STUDENT.concat(" WHERE cpf = ?");
	protected final static String SQL_SELECT_FONE_BY_STUDENT = "SELECT ddd, number FROM FONE WHERE student_id = ?";
	
	private final Connection connection;
	
	public JDBCStudentRepositoryImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void enroll(Student student) {
	
		String sql = SQL_INSERT_STUDENT;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);	
			ps.setString(1, student.getCpf().getNumber());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail().getEndereco());
			
			ps.execute();
			
			sql = SQL_INSERT_FONE;
			ps = connection.prepareStatement(sql);
			for (Fone fone : student.getFones()) {
				ps.setString(1, fone.getDdd());
				ps.setString(2, fone.getNumber());
				
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student finbByCPF(CPF cpf) {
		
		
		try {
			String sql = SQL_SELECT_STUDENT_BY_CPF;
			PreparedStatement psStudent = connection.prepareStatement(sql);
			psStudent.setString(1, cpf.getNumber());
			
			ResultSet rsStudent = psStudent.executeQuery();
			boolean exists = rsStudent.next();
			
			if (!exists) {
				throw new StudentNotFoundException(cpf);
			}
			
			Long studentId = rsStudent.getLong("id");
			String name = rsStudent.getString("name");
			Email email = new Email(rsStudent.getString("email"));
			Student student = new Student(cpf, name, email);
			
			sql = SQL_SELECT_FONE_BY_STUDENT;
			PreparedStatement psFone = connection.prepareStatement(sql);
			psFone.setLong(1, studentId);
			ResultSet rsFone = psFone.executeQuery();
				
			while(rsFone.next()) {
				String ddd = rsFone.getString("ddd");
				String number = rsFone.getString("number");
				student.addFone(ddd, number);
			}
							
			return student;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Student> listAllEnrolledStudents() {
		
		try {
			String sql = SQL_SELECT_STUDENT;
			PreparedStatement psStudents = connection.prepareStatement(sql);
			ResultSet rsStudents = psStudents.executeQuery();
			List<Student> students = new ArrayList<>();
			
			while (rsStudents.next()) {
				
				Long studentId = rsStudents.getLong("id");							
				CPF cpf = new CPF(rsStudents.getString("cpf"));
				String name = rsStudents.getString("name");
				Email email = new Email(rsStudents.getString("email"));
				Student student = new Student(cpf, name, email);
				
				sql = SQL_SELECT_FONE_BY_STUDENT;
				PreparedStatement psFone = connection.prepareStatement(sql);
				psFone.setLong(1, studentId);
				ResultSet rsFone = psFone.executeQuery();
				
				while(rsFone.next()) {
					String ddd = rsFone.getString("ddd");
					String number = rsFone.getString("number");
					student.addFone(ddd, number);
				}
				
				students.add(student);
			}
			
			return students;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
