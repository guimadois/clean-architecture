package br.com.guima.school.domain.recommendation;

import java.time.LocalDateTime;

import br.com.guima.school.domain.student.Student;
import lombok.Data;

@Data
public class Recommendation {

	private Student recommended; 
	private Student indicator;
	private LocalDateTime date;
	
	public Recommendation(Student recommended, Student indicator) {
		
		this.recommended = recommended;
		this.indicator = indicator;
		this.date = LocalDateTime.now();
	}
}
