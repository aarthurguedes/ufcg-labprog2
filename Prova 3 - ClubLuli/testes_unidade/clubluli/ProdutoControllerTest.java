package clubluli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ProdutoController;

class ProdutoControllerTest {
	
	private ProdutoController produto;

	@BeforeEach
	public void criaProdutoController() {
		this.produto = new ProdutoController();
	}
	
	@Test
	public void testCadastrarOficina() {
		produto.cadastrarOficina("Bang", "Infantil", 47.5, 12.0);
		assertTrue(produto.getProdutos().containsKey("Bang"));
	}
	
	@Test
	public void testCadastrarLivro() {
		produto.cadastrarLivro("Harry Potter", "Infantil", 47.5, "Novo");
		assertTrue(produto.getProdutos().containsKey("Harry Potter"));
	}
	
	@Test
	public void testCadastrarJogo() {
		produto.cadastrarJogo("Jogo do Contente", "Infantil", 34.5);
		assertTrue(produto.getProdutos().containsKey("Jogo do Contente"));
	}
	
	@Test
	public void testExibirProduto() {
		produto.cadastrarJogo("Jogo do Contente", "Infantil", 34.5);
		assertEquals("[Jogo do Contente, Infantil, 34.5]", produto.exibirProduto("Jogo do Contente"));
	}
	
	@Test
	public void testObterPreco() {
		produto.cadastrarJogo("Jogo do Contente", "Infantil", 34.5);
		assertEquals(32.775, produto.obterPreco("Jogo do Contente"));
	}
	
	@Test
	public void testConfigurarOrdenacao() {
		produto.configurarOrdenacao("NOME");
		assertEquals("NOME", produto.getTipoOrdenacao());
	}
	
	@Test
	public void testListar() {
		produto.cadastrarLivro("Harry Potter", "Infantil", 47.5, "Novo");
		produto.cadastrarJogo("Jogo do Contente", "Infantil", 34.5);
		assertEquals("[[Harry Potter, Infantil, 47.5], [Jogo do Contente, Infantil, 34.5]", produto.listar());
	}
}
