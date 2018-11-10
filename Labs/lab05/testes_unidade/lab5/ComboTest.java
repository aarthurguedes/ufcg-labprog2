package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Combo;

class ComboTest {

	private Combo c;
	
	@BeforeEach
	public void criaCombo() {
		c = new Combo("X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer de carne com "
				+ "queijo e calabresa, Suco - Suco de maracuja (copo)");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("X-burguer + suco", c.getNome());
		assertEquals("X-burguer com suco de maracuja", c.getDescricao());
		assertEquals("0.20", c.getFator());
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Combo("", "X-burguer com suco de maracuja", "0.20", 
				"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
		
		
	}
	
	@Test
	public void testDescricaoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Combo("X-burguer + suco", "", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
	}
	
	@Test
	public void testFatorInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Combo("X-burguer + suco", "X-burguer com suco de maracuja", 
				"", "Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
	}
	
	@Test
	public void testProdutosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Combo("X-burguer + suco", "X-burguer com suco de maracuja", 
				"0.20", ""));
	}
	
	@Test
	public void testCombosIguais() {
		Combo c2 = new Combo("X-burguer + suco", "X-burguer com suco de maracuja", "0.10", "X-burguer - Hamburguer de carne, Suco - Suco (copo)");
		assertTrue(c.equals(c2));
	}
	
	@Test
	public void testCombosDiferentes() {
		Combo c2 = new Combo("X-burguer e suco", "X-burguer com suco de maracuja", "0.10", "X-burguer - Hamburguer de carne, Suco - Suco (copo)");
		Combo c3 = new Combo("X-burguer e suco", "X burguer com suco de maracuja", "0.10", "X-burguer - Hamburguer de carne, Suco - Suco (copo)");
		assertFalse(c.equals(c2));
		assertFalse(c.equals(c3));
	}
}
