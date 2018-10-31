package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente c;
	
	@BeforeEach
	public void criaCliente() {
		c = new Cliente("00000000000", "João Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("00000000000", c.getCpf());
		assertEquals("João Neto", c.getNome());
		assertEquals( "joaoneto@ccc.ufcg.edu.br", c.getEmail());
		assertEquals("SPLAB", c.getLocalizacao());
	}
	
	@Test
	public void testCpfInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente("", "João Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000000", "", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
	}
	
	@Test
	public void testEmailInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000000", "João Neto", "", "SPLAB"));
	}
	
	@Test
	public void testLocalizacaoInvalida() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000000", "João Neto", "joaoneto@ccc.ufcg.edu.br", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("João Neto - SPLAB - joaoneto@ccc.ufcg.edu.br", c.toString());
	}
	
	@Test
	public void testClientesIguais() {
		Cliente c2 = new Cliente("00000000000", "Ana Silva", " anasilva@ccc.ufcg.edu.br", "Embedded ");
		assertTrue(c.equals(c2));
	}
	
	@Test
	public void testClientesDiferentes() {
		Cliente c2 = new Cliente("00000000001", "João Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		assertFalse(c.equals(c2));
	}
}
