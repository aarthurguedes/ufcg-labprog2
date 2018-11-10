package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Cliente;

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
		assertThrows(IllegalArgumentException.class, () -> new Cliente("0000000000", "João Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("000000000000", "João Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
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
	
	private void criaConta() {
		c.getContas().put("Marcos", new Conta());
		Compra compra = new Compra("03/06/2017", "Coxao com batata - Coxao de frango com batata frita", "5.00"); 
		c.getContas().get("Marcos").getCompras().add(compra);
	}
	
	private void criaContas() {
		criaConta();
		c.getContas().put("Seu Olavo", new Conta());
		Compra compra = new Compra("02/04/2015", "Suco - Suco de maracuja (copo)", "2.50"); 
		c.getContas().get("Seu Olavo").getCompras().add(compra);
	}
	
	@Test
	public void testExibirContaValida() {
		criaConta();
		assertEquals("Cliente: João Neto | Marcos | Coxao com batata - 03-06-2017", 
				c.exibirConta("Marcos"));
	}
	
	@Test
	public void testExibirContaInvalida() {
		criaConta();
		assertThrows(IllegalArgumentException.class, () -> c.exibirConta(""));
		assertThrows(IllegalArgumentException.class, () -> c.exibirConta("Seu Olavo"));
	}
	
	@Test
	public void testExibirContas() {
		criaContas();
		assertEquals("Cliente: João Neto | Marcos | Coxao com batata - 03-06-2017 | Seu Olavo | Suco - 02-04-2015", 
				c.exibirContas());
	}
	
	@Test
	public void testRealizarPagamentoValido() {
		criaConta();
		c.realizarPagamento("Marcos");
		assertTrue(!c.getContas().containsKey("Marcos"));
	}
	
	@Test
	public void testRealizarPagamentoInvalido() {
		criaConta();
		assertThrows(IllegalArgumentException.class, () -> c.realizarPagamento(null));
		assertThrows(IllegalArgumentException.class, () -> c.realizarPagamento(""));
		assertThrows(IllegalArgumentException.class, () -> c.realizarPagamento("Seu Olavo"));
	}
}
