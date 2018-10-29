package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	private Fornecedor f;
	
	@BeforeEach
	public void criaFornecedor() {
		f = new Fornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Arthur", f.getNome());
		assertEquals("arthur.guedes@ccc.ufcg.edu.br", f.getEmail());
		assertEquals("83 9999-5050", f.getTelefone());
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(NullPointerException.class, () -> new Fornecedor(null, "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050"));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050"));
	}
	
	@Test
	public void testEmailInvalido() {
		assertThrows(NullPointerException.class, () -> new Fornecedor("Arthur", null, "83 9999-5050"));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Arthur", "", "83 9999-5050"));
	}
	
	@Test
	public void testTelefoneInvalido() {
		assertThrows(NullPointerException.class, () -> new Fornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("Arthur - arthur.guedes@ccc.ufcg.edu.br - 83 9999-5050", f.toString());
	}
	
	@Test
	public void testFornecedoresDiferentes() {
		Fornecedor f2 = new Fornecedor("Arthurzinho", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
		assertFalse(f.equals(f2));
	}
	
	@Test
	public void testFornecedoresIguais() {
		Fornecedor f2 = new Fornecedor("Arthur", "arthurzinho@ccc.ufcg.edu.br", "83 8888-4040");
		assertTrue(f.equals(f2));
	}

}
