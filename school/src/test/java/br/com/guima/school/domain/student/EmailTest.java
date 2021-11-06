package br.com.guima.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void testInvalidEmailFormat() {
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email("teste@teste."));
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(""));
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(null));
	}
	
	@Test
	void testCreateEmail() {
		
		Email email = assertDoesNotThrow(() -> new Email("teste@teste.com.br"));
		
		assertNotNull(email);
		assertEquals("teste@teste.com.br", email.getEndereco());
	}
}
