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
		assertEquals("Dona In�s", fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050"));
	}
	
	@Test
	public void testAdicionaFornecedorInvalido() {
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaFornecedor("", "dines@gmail.com", "83 9999-5050"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaFornecedor("Dona In�s", "", "83 9999-5050"));
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050"));
	}
	
	@Test
	public void testExibeFornecedorValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		assertEquals("Dona In�s - dines@gmail.com - 83 9999-5050", fc.exibeFornecedor("Dona In�s"));
	}
	
	@Test
	public void testExibeFornecedorInvalido() {
		assertThrows(IllegalArgumentException.class, () -> fc.exibeFornecedor("Dona In�s"));
	}
	
	@Test
	public void testExibeFornecedores() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050");
		fc.adicionaFornecedor("Ron Weasley", "rweasley@splab.ufcg.edu.br", "83 99936-5050");
		assertEquals("Dona In�s - dines@gmail.com - 83 9999-5050 | Josenilda - nilda@computacao.ufcg.edu.br - 83 98736-5050 | "
				+ "Ron Weasley - rweasley@splab.ufcg.edu.br - 83 99936-5050", fc.exibeFornecedores());
	}
	
	@Test
	public void testEditaFornecedorValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.editaFornecedor("Dona In�s", "email", "ines@gmail.com");
		fc.editaFornecedor("Dona In�s", "telefone", "83 8888-4040");
		assertEquals("Dona In�s - ines@gmail.com - 83 8888-4040", fc.exibeFornecedor("Dona In�s"));
	}
	
	@Test
	public void testEditaFornecedorInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona In�s", "nome", "In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona In�s", "", "In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona In�s", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.editaFornecedor("Dona In�s", "sobrenome", "In�s"));
	}
	
	@Test
	public void testRemoveFornecedorValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.removeFornecedor("Dona In�s");
		assertTrue(!fc.getFornecedores().containsKey("Dona In�s"));
	}
	
	@Test
	public void testRemoveFornecedorInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.removeFornecedor(""));
		assertThrows(IllegalArgumentException.class, () -> fc.removeFornecedor("In�s"));
	}
	
	@Test
	public void testAdicionaProdutoValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertTrue(fc.getFornecedores().get("Dona In�s").getProdutos().containsKey("Tapioca simplesTapioca com manteiga"));
	}
	
	@Test
	public void testAdicionaProdutoInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("", "Tapioca simples", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona In�s", "", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona In�s", "Tapioca simples", "", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("In�s", "Tapioca simples", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "-3.00"));
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00"));
	}
	
	@Test
	public void testExibeProdutoValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertEquals("Tapioca simples - Tapioca com manteiga - R$3,00", fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", "Dona In�s"));
	}
	
	@Test
	public void testExibeProdutoInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("", "Tapioca com manteiga", "Dona In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca simples", "", "Dona In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", "In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("Tapioca completa", "Tapioca com manteiga e queijo", "Dona In�s"));
	}
	
	@Test
	public void testExibeProdutosFornecedorValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.adicionaProduto("Dona In�s", "Tapioca completa", "Tapioca com manteiga e queijo", "3.50");
		assertEquals("Dona In�s - Tapioca completa - Tapioca com manteiga e queijo - R$3,50 | Dona In�s - Tapioca simples - "
				+ "Tapioca com manteiga - R$3,00", fc.exibeProdutosFornecedor("Dona In�s"));
	}
	
	@Test
	public void testExibeProdutosFornecedorInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.adicionaProduto("Dona In�s", "Tapioca completa", "Tapioca com manteiga e queijo", "3.50");
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProdutosFornecedor(""));
	}
	
	@Test
	public void testExibeProdutos() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaFornecedor("Josenilda", "josenilda@gmail.com", "83 8888-4040");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.adicionaProduto("Josenilda", "Tapioca completa", "Tapioca com manteiga e queijo", "3.50");
		assertEquals("Dona In�s - Tapioca simples - Tapioca com manteiga - R$3,00 | Josenilda - Tapioca completa - "
				+ "Tapioca com manteiga e queijo - R$3,50", fc.exibeProdutos());
	}
	
	@Test
	public void testEditaProdutoValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "Dona In�s", "2.00");
		assertEquals("Tapioca simples - Tapioca com manteiga - R$2,00", 
				fc.exibeProduto("Tapioca simples", "Tapioca com manteiga", "Dona In�s"));
	}
	
	@Test
	public void testEditaProdutoInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "", "2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "Dona In�s", "-2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("", "Tapioca com manteiga", "Dona In�s", "2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "", "Dona In�s", "-2.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaProduto("Tapioca simples", "Tapioca com manteiga", "In�s", "2.00"));
	}
	
	@Test
	public void testRemoveProdutoValido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		fc.removeProduto("Tapioca simples", "Tapioca com manteiga", "Dona In�s");
		assertTrue(!fc.getFornecedores().get("Dona In�s").getProdutos().containsKey("Tapioca simplesTapioca com manteiga"));
	}
	
	@Test
	public void testRemoveProdutoInvalido() {
		fc.adicionaFornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
		fc.adicionaProduto("Dona In�s", "Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("", "Tapioca com manteiga", "Dona In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca simples", "", "Dona In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca simples", "Tapioca com manteiga", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca simples", "Tapioca com manteiga", "In�s"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Tapioca completa", "Tapioca com manteiga e queijo", "Dona In�s"));
	}
}
