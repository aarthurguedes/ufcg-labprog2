package lab5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorControllerTest {

	private FornecedorController fc;
	
	@BeforeEach
	public void criaFornecedorController() {
		fc = new FornecedorController();
	}
	
	@Test
	public void testCadastrarFornecedorInvalido() {
		fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050"));
	}
	
	@Test
	public void testCadastrarFornecedorValido() {
		fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
	}
	
	@Test
	public void testExibirFornecedorInvalido() {
		assertThrows(NullPointerException.class, () -> fc.exibirFornecedor(null));
		assertThrows(IllegalArgumentException.class, () -> fc.exibirFornecedor(""));
		assertThrows(NoSuchElementException.class, () -> fc.exibirFornecedor("Arthur")); 
	}
	
	@Test
	public void testExibirFornecedorValido() {
		fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
		assertEquals("Arthur - arthur.guedes@ccc.ufcg.edu.br - 83 9999-5050", fc.exibirFornecedor("Arthur"));
	} 
	
	@Test
	public void testExibirFornecedores() {
		fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
		fc.cadastrarFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.cadastrarFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050");
		fc.cadastrarFornecedor("Ron Weasley", "rweasley@splab.ufcg.edu.br", "83 99936-5050");
		assertEquals("Arthur - arthur.guedes@ccc.ufcg.edu.br - 83 9999-5050 | Dona Inês - dines@gmail.com - 83 9999-5050 | "
				+ "Josenilda - nilda@computacao.ufcg.edu.br - 83 98736-5050 | Ron Weasley - rweasley@splab.ufcg.edu.br - 83 99936-5050", 
				fc.exibirFornecedores());
	}
	
	@Test
	public void testEditarCadastroInvalido() {
		assertThrows(NullPointerException.class, () -> fc.editarCadastro(null, "arthur@ccc.ufcg.edu.br", "83 9999-5050"));
		assertThrows(IllegalArgumentException.class, () -> fc.editarCadastro("", "arthur@ccc.ufcg.edu.br", "83 9999-5050"));
		assertThrows(NoSuchElementException.class, () -> fc.editarCadastro("Arthur", "arthur@ccc.ufcg.edu.br", "83 9999-5050"));  
	} 
	
	@Test
	public void testEditarCadastroValido() {
		fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
		fc.editarCadastro("Arthur", "arthurzinho@gmail.com", "83 8888-4040");
	}
	
	@Test
	public void testRemoverFornecedorInvalido() {
		assertThrows(NullPointerException.class, () -> fc.removerCliente(null));
		assertThrows(IllegalArgumentException.class, () -> fc.removerCliente(""));
		assertThrows(NoSuchElementException.class, () -> fc.removerCliente("Arthur"));
	}
	
	@Test
	public void testRemoverFornecedorValido() {
		fc.cadastrarFornecedor("Arthur", "arthur.guedes@ccc.ufcg.edu.br", "83 9999-5050");
		fc.removerCliente("Arthur");
	}
}