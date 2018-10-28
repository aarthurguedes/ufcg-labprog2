package lab5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteControllerTest {

	private ClienteController cl;
	
	@BeforeEach
	public void criaClienteController() {
		cl = new ClienteController();	
	}
	
	@Test
	public void testCadastrarClienteInvalido() {
		cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
		assertThrows(IllegalArgumentException.class, () -> cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2"));
	}
	
	@Test
	public void testCadastrarClienteValido() {
		cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
	}
	
	@Test
	public void testExibirClienteInvalido() {
		assertThrows(NullPointerException.class, () -> cl.exibirCliente(null));
		assertThrows(IllegalArgumentException.class, () -> cl.exibirCliente(""));
		assertThrows(NoSuchElementException.class, () -> cl.exibirCliente("001.002.003-05"));
	}
	
	@Test 
	public void testExibirClienteValido() {
		cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
		assertEquals("Arthur - LP2 - arthur.guedes@ccc.ufcg.edu.br", cl.exibirCliente("001.002.003-04"));
	}
	
	@Test
	public void testExibirClientes() {
		cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
		cl.cadastrarCliente("001.002.003-05", "Antonio", "antonio@ccc.ufcg.edu.br", "LP2");
		cl.cadastrarCliente("001.002.003-06", "Bruno", "bruno@ccc.ufcg.edu.br", "SPLAB");
		cl.cadastrarCliente("001.002.003-07", "Carlos", "carlos@ccc.ufcg.edu.br", "LSD");
		assertEquals("Antonio - LP2 - antonio@ccc.ufcg.edu.br | Arthur - LP2 - arthur.guedes@ccc.ufcg.edu.br | Bruno - SPLAB - "
				+ "bruno@ccc.ufcg.edu.br | Carlos - LSD - carlos@ccc.ufcg.edu.br", cl.exibirClientes());
	}
	
	@Test
	public void testEditarCadastroInvalido() {
		assertThrows(NullPointerException.class, () -> cl.editarCadastro(null, "Arthur", "arthur@ccc.ufcg.edu.br", "SPLAB"));
		assertThrows(IllegalArgumentException.class, () -> cl.editarCadastro("", "Arthur", "arthur@ccc.ufcg.edu.br", "SPLAB"));
		assertThrows(NoSuchElementException.class, () -> cl.exibirCliente("001.002.003-05"));
	}
	
	@Test
	public void testEditarCadastroValido() {
		cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
		cl.editarCadastro("001.002.003-04", "Arthur Guedes", "arthur@ccc.ufcg.edu.br", "SPLAB");
	}
	
	@Test
	public void testRemoverClienteInvalido() {
		assertThrows(NullPointerException.class, () -> cl.removerCliente(null));
		assertThrows(IllegalArgumentException.class, () -> cl.removerCliente(""));
		assertThrows(NoSuchElementException.class, () -> cl.exibirCliente("001.002.003-05"));
	}
	
	@Test
	public void testRemoverClienteValido() {
		cl.cadastrarCliente("001.002.003-04", "Arthur", "arthur.guedes@ccc.ufcg.edu.br", "LP2");
		cl.removerCliente("001.002.003-04");
	}
}
