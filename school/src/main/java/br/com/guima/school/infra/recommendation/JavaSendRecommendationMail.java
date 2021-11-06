package br.com.guima.school.infra.recommendation;

import br.com.guima.school.domain.recommendation.SendRecommendationEmail;
import br.com.guima.school.domain.student.Student;

public class JavaSendRecommendationMail implements SendRecommendationEmail {

	@Override
	public void sendTo(Student recommendedStudent) {
		
		//lógica para envio de e-mail com lib Java Mail.
	}

}
