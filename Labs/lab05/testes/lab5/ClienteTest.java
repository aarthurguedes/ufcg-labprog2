package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente c;
	
	@BeforeEach
	public void criaCliente() {
		c = new Cliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("001.002.003-04", c.getCpf());
		assertEquals("Arthur", c.getNome());
		assertEquals("arthur.guedes@ccc.ufcg.edu.br", c.getEmail());
		assertEquals("LP2", c.getLocalizacao());
	}
	
	@Test
	public void testCpfInvalido() {
		assertThrows(NullPointerException.class, () -> new Cliente(null, "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2"));
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(NullPointerException.class, () -> new Cliente("001.002.003-04", null, "arthur.guedes@ccc.ufcg.edu.br", "LP2"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("001.002.003-04", "", "arthur.guedes@ccc.ufcg.edu.br", "LP2"));
	}
	
	@Test
	public void testEmailInvalido() {
		assertThrows(NullPointerException.class, () -> new Cliente("001.002.003-04", "Arthur", null, "LP2"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("001.002.003-04", "Arthur", "", "LP2"));
	}
	
	@Test
	public void testLocalizacaoInvalida() {
		assertThrows(NullPointerException.class, () -> new Cliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("Arthur - LP2 - arthur.guedes@ccc.ufcg.edu.br", c.toString());
	}
	
	@Test
	public void testClientesIguais() {
		Cliente c2 = new Cliente("001.002.003-04", "Matheus", "matheus@ccc.ufcg.edu.br", "SPLAB");
		assertTrue(c.equals(c2));
	}
	
	@Test
	public void testClientesDiferentes() {
		Cliente c2 = new Cliente("001.002.003-05", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
		assertFalse(c.equals(c2));
	}
}
