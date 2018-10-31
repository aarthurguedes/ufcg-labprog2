package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	private Fornecedor f;
	
	@BeforeEach
	public void criaFornecedor() {
		f = new Fornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Dona Inês", f.getNome());
		assertEquals("dines@gmail.com", f.getEmail());
		assertEquals("83 9999-5050", f.getTelefone());
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "dines@gmail.com", "83 9999-5050"));
	} 
	
	@Test
	public void testEmailInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Dona Inês", "", "83 9999-5050"));
	}
	
	@Test
	public void testTelefoneInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Dona Inês", "dines@gmail.com", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("Dona Inês - dines@gmail.com - 83 9999-5050", f.toString());
	}
	
	@Test
	public void testFornecedoresIguais() {
		Fornecedor f2 = new Fornecedor("Dona Inês", "donaines@gmail.com", "83 8888-4040");
		assertTrue(f.equals(f2));
	}
	
	@Test
	public void testFornecedoresDiferentes() {
		Fornecedor f2 = new Fornecedor("Dona", "dines@gmail.com", "83 9999-5050");
		assertFalse(f.equals(f2));
	}
}
