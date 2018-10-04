package lab3;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {

	private Contato contatoBasico;
	
	@BeforeEach
	public void criaContato() {
		contatoBasico = new Contato("Arthur", "Guedes", "4002-8922");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Arthur", contatoBasico.getNome());
		assertEquals("Guedes", contatoBasico.getSobrenome());
		assertEquals("4002-8922",contatoBasico.getNumTelefone());
	}
	
	@Test
	public void testEquals() {
		Contato contato2 = new Contato("Arthur", "Guedes", "9898-8989");
		Contato contato3 = new Contato("Artur", "Guedes", "4002-8922");
		assertTrue(contatoBasico.equals(contato2));
		assertFalse(contatoBasico.equals(contato3));
	}
	
	@Test
	public void testToString() {
		assertEquals("Arthur Guedes", contatoBasico.toString());
	}
	
	@Test
	public void testNomeNull() {
		try {
			Contato contatoInvalido = new Contato(null, "Guedes", "4002-8922");
			fail("Era esperado exceção ao passar código nulo");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	public void testSobrenomeNull() {
		try {
			Contato contatoInvalido = new Contato("Arthur", null, "4002-8922");
			fail("Era esperado exceção ao passar código nulo");
		} catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	public void testNumeroNull() {
		try {
			Contato contatoInvalido = new Contato("Arthur", "Guedes", null);
			fail("Era esperado exceção ao passar código nulo");
		} catch(NullPointerException npe) {
			
		}
	}
}
