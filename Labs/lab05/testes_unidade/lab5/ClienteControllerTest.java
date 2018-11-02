package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteControllerTest {

	private ClienteController cc;
	
	@BeforeEach
	public void criaClienteController() {
		cc = new ClienteController(); 
	}
	
	@Test
	public void testAdicionaClienteValido() {
		assertEquals("00000000000", cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
	}
	
	@Test
	public void testAdicionaClienteInvalido() {
		assertThrows(IllegalArgumentException.class, () -> cc.adicionaCliente("00000000000", "", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
		assertThrows(IllegalArgumentException.class, () -> cc.adicionaCliente("00000000000", "Jo�o Neto", "", "SPLAB"));
		assertThrows(IllegalArgumentException.class, () -> cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", ""));
		assertThrows(IllegalArgumentException.class, () -> cc.adicionaCliente("000000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
		assertThrows(IllegalArgumentException.class, () -> cc.adicionaCliente("0000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
		cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		assertThrows(IllegalArgumentException.class, () -> cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB"));
	}
	
	@Test
	public void testExibeClienteValido() {
		cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		assertEquals("Jo�o Neto - SPLAB - joaoneto@ccc.ufcg.edu.br", cc.exibeCliente("00000000000")); 
	}
	
	@Test
	public void testExibeClienteInvalido() {
		assertThrows(IllegalArgumentException.class, () -> cc.exibeCliente("00000000000"));
	}
	
	@Test
	public void testExibeClientes() {
		cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		cc.adicionaCliente("00000000001", "Ana Silva", "anasilva@ccc.ufcg.edu.br", "Embedded");
		assertEquals("Ana Silva - Embedded - anasilva@ccc.ufcg.edu.br | Jo�o Neto - SPLAB - joaoneto@ccc.ufcg.edu.br", cc.exibeClientes());
	}
	
	@Test
	public void testEditaClienteValido() {
		cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		cc.editaCliente("00000000000", "nome", "Neto Jo�o");
		cc.editaCliente("00000000000", "email", "netojoao@ccc.ufcg.edu.br");
		cc.editaCliente("00000000000", "localizacao", "LSD");
		assertEquals("Neto Jo�o - LSD - netojoao@ccc.ufcg.edu.br", cc.exibeCliente("00000000000"));
	}
	
	@Test
	public void testEditaClienteInvalido() {
		cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		assertThrows(IllegalArgumentException.class, () -> cc.editaCliente("00000000000", "", "Neto Jo�o"));
		assertThrows(IllegalArgumentException.class, () -> cc.editaCliente("00000000000", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> cc.editaCliente("00000000000", "sobrenome", "Neto Jo�o"));
		assertThrows(IllegalArgumentException.class, () -> cc.editaCliente("00000000001", "nome", "Neto Jo�o"));
	}
	
	@Test
	public void testRemoveClienteValido() {
		cc.adicionaCliente("00000000000", "Jo�o Neto", "joaoneto@ccc.ufcg.edu.br", "SPLAB");
		cc.removeCliente("00000000000");
		assertTrue(!cc.getClientes().containsKey("0000000000"));
	}
	
	@Test
	public void testRemoveClienteInvalido() {
		assertThrows(IllegalArgumentException.class, () -> cc.removeCliente("00000000000"));
	}
}
