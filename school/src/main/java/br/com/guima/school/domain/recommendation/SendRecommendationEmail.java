package br.com.guima.school.domain.recommendation;

import br.com.guima.school.domain.student.Student;

public interface SendRecommendationEmail {

	void sendTo(Student recommendedStudent);
}
