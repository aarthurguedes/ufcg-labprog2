package clubluli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import abstrato.Produto;
import clubluli.Jogo;
import clubluli.Livro;
import controllers.CarrinhoDeComprasController;

class CarrinhoDeComprasControllerTest {

	private CarrinhoDeComprasController carrinho;
	
	@BeforeEach
	public void criaCarrinhoDeComprasController() {
		this.carrinho = new CarrinhoDeComprasController();
		this.carrinho.criarCarrinho(1);
	}
	
	@Test
	public void testCriarCarrinhoValido() {
		assertTrue(this.carrinho.getCarrinhos().containsKey(1));
	}
	
	@Test
	public void testCriaCarrinhoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> carrinho.criarCarrinho(1));
	}
	
	@Test
	public void testAdicionarProdutoAoCarrinhoValido() {
		Produto jogo = new Jogo("Jogo do Contente", "Infantil", 34.5);
		this.carrinho.adicionarProdutoAoCarrinho(1, jogo);
		assertTrue(carrinho.getCarrinhos().get(1).getProdutos().contains(jogo));
	}
	
	@Test
	public void testAdicionarProdutoAoCarrinhoInvalido() {
		Produto jogo = new Jogo("Jogo do Contente", "Infantil", 34.5);
		assertThrows(IllegalArgumentException.class, () -> carrinho.adicionarProdutoAoCarrinho(2, jogo));
	}
	
	@Test
	public void testTotalizarCarrinhoValido() {
		Produto jogo = new Jogo("Jogo do Contente", "Infantil", 34.5);
		Produto livro = new Livro("Harry Potter", "Juvenil", 10.0, "Novo");
		this.carrinho.adicionarProdutoAoCarrinho(1, jogo);
		this.carrinho.adicionarProdutoAoCarrinho(1, livro);
		assertEquals(42.775, this.carrinho.totalizarCarrinho(1));
	}
	
	@Test
	public void testTotalizarCarrinhoInvalido() {
		Produto jogo = new Jogo("Jogo do Contente", "Infantil", 34.5);
		this.carrinho.adicionarProdutoAoCarrinho(1, jogo);
		assertThrows(IllegalArgumentException.class, () -> carrinho.totalizarCarrinho(2));
	}
}
