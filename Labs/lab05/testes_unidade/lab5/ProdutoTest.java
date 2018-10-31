package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	Produto p;
	
	@BeforeEach
	public void criaProduto() {
		p = new Produto("3.00", "Tapioca simples", "Tapioca com manteiga");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("3.00", p.getPreco());
		assertEquals("Tapioca simples", p.getNome());
		assertEquals("Tapioca com manteiga", p.getDescricao());
	}
	
	@Test
	public void testPrecoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Produto("", "Tapioca simples", "Tapioca com manteiga"));
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Produto("3.00", "", "Tapioca com manteiga"));
	}
	
	@Test
	public void testDescricaoInvalida() {
		assertThrows(IllegalArgumentException.class, () -> new Produto("3.00", "Tapioca simples", ""));
	}
	
	@Test
	public void testToString() {
		assertEquals("Tapioca simples - Tapioca com manteiga - R$3,00", p.toString());
	}
	
	@Test
	public void testProdutosIguais() {
		Produto p2 = new Produto("2.00", "Tapioca simples", "Tapioca com manteiga");
		assertTrue(p.equals(p2));
	}
	
	@Test
	public void testProdutosDiferentes() {
		Produto p2 = new Produto("3.00", "Tapioca complexa", "Tapioca com manteiga");
		Produto p3 = new Produto("3.00", "Tapioca simples", "Tapioca com manteiga e queijo");
		Produto p4 = new Produto("3.00", "Tapioca complexa", "Tapioca com manteiga e queijo");
		
		assertFalse(p.equals(p2));
		assertFalse(p.equals(p3));
		assertFalse(p.equals(p4));
	}
}
