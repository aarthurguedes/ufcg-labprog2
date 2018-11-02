package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorControllerTest {
	
	private FornecedorController fc;
	
	@BeforeEach
	public void criaFornecedorController() {
		fc = new FornecedorController();
	}
	
	@Test
	public void testAdicionaFornecedorValido() {
		assertEquals("Dona Inês", fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050"));
	}
	
	@Test
	public void testAdicionaFornecedorInvalido() {
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaFornecedor("", "dines@gmail.com", "83 9999-5050"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaFornecedor("Dona Inês", "", "83 9999-5050"));
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050"));
	}
	
	@Test
	public void testExibeFornecedorValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		assertEquals("Dona Inês - dines@gmail.com - 83 9999-5050", fc.exibeFornecedor("Dona Inês"));
	}
	
	@Test
	public void testExibeFornecedorInvalido() {
		assertThrows(IllegalArgumentException.class, () -> fc.exibeFornecedor("Dona Inês"));
	}
	
	@Test
	public void testExibeFornecedores() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050");
		fc.adicionaFornecedor("Ron Weasley", "rweasley@splab.ufcg.edu.br", "83 99936-5050");
		assertEquals("Dona Inês - dines@gmail.com - 83 9999-5050 | Josenilda - nilda@computacao.ufcg.edu.br - 83 98736-5050 | "
				+ "Ron Weasley - rweasley@splab.ufcg.edu.br - 83 99936-5050", fc.exibeFornecedores());
	}
	
	@Test
	public void testEditaFornecedorValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.editaFornecedor("Dona Inês", "email", "ines@gmail.com");
		fc.editaFornecedor("Dona Inês", "telefone", "83 8888-4040");
		assertEquals("Dona Inês - ines@gmail.com - 83 8888-4040", fc.exibeFornecedor("Dona Inês"));
	}
	
	@Test
	public void testEditaFornecedorInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona Inês", "nome", "Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona Inês", "", "Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona Inês", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona Inês", "sobrenome", "Inês"));
	}
	
	@Test
	public void testRemoveFornecedorValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.removeFornecedor("Dona Inês");
		assertTrue(!fc.getFornecedores().containsKey("Dona Inês"));
	}
	
	@Test
	public void testRemoveFornecedorInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.removeFornecedor(""));
		assertThrows(IllegalArgumentException.class, () -> fc.removeFornecedor("Inês"));
	}
	
	@Test
	public void testAdicionaProdutoValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertTrue(fc.getFornecedores().get("Dona Inês").getProdutos().containsKey("Tapioca simplesTapioca com manteiga"));
	}
	
	@Test
	public void testAdicionaProdutoInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("", "Tapioca simples", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona Inês", "", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona Inês", "Tapioca simples", "", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Inês", "Tapioca simples", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "-3.00"));
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00"));
	}
	
	@Test
	public void testExibeProdutoValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertEquals("Tapioca simples - Tapioca com manteiga - R$3,00", fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", "Dona Inês"));
	}
	
	@Test
	public void testExibeProdutoInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("", "Tapioca com manteiga", "Dona Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca simples", "", "Dona Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", "Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca completa", "Tapioca com manteiga e queijo", "Dona Inês"));
	}
	
	@Test
	public void testExibeProdutosFornecedorValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.adicionaProduto("Dona Inês", "Tapioca completa", "Tapioca com manteiga e queijo", "3.50");
		assertEquals("Dona Inês - Tapioca completa - Tapioca com manteiga e queijo - R$3,50 | Dona Inês - Tapioca simples - "
				+ "Tapioca com manteiga - R$3,00", fc.exibeProdutosFornecedor("Dona Inês"));
	}
	
	@Test
	public void testExibeProdutosFornecedorInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.adicionaProduto("Dona Inês", "Tapioca completa", "Tapioca com manteiga e queijo", "3.50");
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProdutosFornecedor(""));
	}
	
	@Test
	public void testExibeProdutos() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaFornecedor("Josenilda", "josenilda@gmail.com", "83 8888-4040");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.adicionaProduto("Josenilda", "Tapioca completa", "Tapioca com manteiga e queijo", "3.50");
		assertEquals("Dona Inês - Tapioca simples - Tapioca com manteiga - R$3,00 | Josenilda - Tapioca completa - "
				+ "Tapioca com manteiga e queijo - R$3,50", fc.exibeProdutos());
	}
	
	@Test
	public void testEditaProdutoValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "Dona Inês", "2.00");
		assertEquals("Tapioca simples - Tapioca com manteiga - R$2,00", 
				fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", "Dona Inês"));
	}
	
	@Test
	public void testEditaProdutoInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "", "2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "Dona Inês", "-2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("", "Tapioca com manteiga", "Dona Inês", "2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "", "Dona Inês", "-2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "Inês", "2.00"));
	}
	
	@Test
	public void testRemoveProdutoValido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.removeProduto("Tapioca simples", "Tapioca com manteiga", "Dona Inês");
		assertTrue(!fc.getFornecedores().get("Dona Inês").getProdutos().containsKey("Tapioca simplesTapioca com manteiga"));
	}
	
	@Test
	public void testRemoveProdutoInvalido() {
		fc.adicionaFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("", "Tapioca com manteiga", "Dona Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca simples", "", "Dona Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca simples", "Tapioca com manteiga", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca simples", "Tapioca com manteiga", "Inês"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca completa", "Tapioca com manteiga e queijo", "Dona Inês"));
	}
}
