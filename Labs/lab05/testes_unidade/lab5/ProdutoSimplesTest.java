package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ProdutoSimples;

class ProdutoSimplesTest {

	ProdutoSimples p;
	
	@BeforeEach
	public void criaProduto() {
		p = new ProdutoSimples("3.00", "Tapioca simples", "Tapioca com manteiga");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("3.00", p.getPreco());
		assertEquals("Tapioca simples", p.getNome());
		assertEquals("Tapioca com manteiga", p.getDescricao());
	}
	
	@Test
	public void testPrecoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("", "Tapioca simples", "Tapioca com manteiga"));
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("3.00", "", "Tapioca com manteiga"));
	}
	
	@Test
	public void testDescricaoInvalida() {
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("3.00", "Tapioca simples", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("Tapioca simples - Tapioca com manteiga - R$3,00", p.toString());
	}
	
	@Test
	public void testProdutosIguais() {
		ProdutoSimples p2 = new ProdutoSimples("2.00", "Tapioca simples", "Tapioca com manteiga");
		assertTrue(p.equals(p2));
	}
	
	@Test
	public void testProdutosDiferentes() {
		ProdutoSimples p2 = new ProdutoSimples("3.00", "Tapioca complexa", "Tapioca com manteiga");
		ProdutoSimples p3 = new ProdutoSimples("3.00", "Tapioca simples", "Tapioca com manteiga e queijo");
		ProdutoSimples p4 = new ProdutoSimples("3.00", "Tapioca complexa", "Tapioca com manteiga e queijo");
		
		assertFalse(p.equals(p2));
		assertFalse(p.equals(p3));
		assertFalse(p.equals(p4));
	}
}
