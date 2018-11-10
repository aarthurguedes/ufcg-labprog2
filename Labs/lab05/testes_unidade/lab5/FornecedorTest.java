package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Fornecedor;

class FornecedorTest {

	private Fornecedor f;
	
	@BeforeEach
	public void criaFornecedor() {
		f = new Fornecedor("Dona In�s", "dines@gmail.com", "83 9999-5050");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Dona In�s", f.getNome());
		assertEquals("dines@gmail.com", f.getEmail());
		assertEquals("83 9999-5050", f.getTelefone());
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "dines@gmail.com", "83 9999-5050"));
	} 
	
	@Test
	public void testEmailInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Dona In�s", "", "83 9999-5050"));
	}
	
	@Test
	public void testTelefoneInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Dona In�s", "dines@gmail.com", ""));
	}
	
	@Test
	public void testAdicionarProdutoValido() {
		f.adicionarProduto("Tapioca", "Tapioca com manteiga", "3.00");
		assertTrue(f.getProdutos().containsKey("TapiocaTapioca com manteiga"));
	}
	
	@Test
	public void testAdicionarProdutoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> f.adicionarProduto("", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarProduto("Tapioca simples", "", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", ""));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "-3.00"));
	}
	
	@Test
	public void testExibirProdutoValido() {
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		assertEquals("Tapioca simples - Tapioca com manteiga - R$3,00", f.exibirProduto("Tapioca simples", "Tapioca com manteiga"));
	}
	
	@Test
	public void testExibirProdutoInvalido() {
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> f.exibirProduto("", "Tapioca com manteiga"));
		assertThrows(IllegalArgumentException.class, () -> f.exibirProduto("Tapioca simples", ""));
		assertThrows(IllegalArgumentException.class, () -> f.exibirProduto("Tapioca completa", "Tapioca com manteiga e queijo"));
	}
	
	@Test
	public void testExibirProdutos() {
		f.adicionarProduto("Tapioca completa", "Tapioca com c�co, queijo e manteiga", "3.50");
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		f.adicionarProduto("Bolo", "Bolo de chocolate", "3.00");
		assertEquals("Dona In�s - Bolo - Bolo de chocolate - R$3,00 | Dona In�s - Tapioca completa - Tapioca com c�co, queijo e manteiga - R$3,50 | "
				+ "Dona In�s - Tapioca simples - Tapioca com manteiga - R$3,00", f.exibirProdutos());
	}
	
	@Test
	public void testEditarProdutoValido() {
		f.adicionarProduto("Tapioca completa", "Tapioca com c�co, queijo e manteiga", "3.50");
		f.editarProduto("Tapioca completa", "Tapioca com c�co, queijo e manteiga", "1.50");
		assertEquals("1.50", f.getProdutos().get("Tapioca completaTapioca com c�co, queijo e manteiga").getPreco());
	}
	
	@Test
	public void testEditarProdutoInvalido() {
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("Tapioca simples", "Tapioca com manteiga", "-3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("Tapioca simples", "", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("Tapioca completa", "Tapioca com c�co, queijo e manteiga", "1.50"));
	}
	
	@Test
	public void testRemoverProdutoValido() {
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		f.removerProduto("Tapioca simples", "Tapioca com manteiga");
		assertTrue(!f.getProdutos().containsKey("Tapioca simplesTapioca com manteiga"));
	}
	
	@Test
	public void testRemoverProdutoInvalido() {
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("", "Tapioca com manteiga"));
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("Tapioca simples", ""));
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("Tapioca completa", "Tapioca com c�co, queijo e manteiga"));
	}
	
	@Test
	public void testToString() {
		assertEquals("Dona In�s - dines@gmail.com - 83 9999-5050", f.toString());
	}
	
	@Test
	public void testFornecedoresIguais() {
		Fornecedor f2 = new Fornecedor("Dona In�s", "donaines@gmail.com", "83 8888-4040");
		assertTrue(f.equals(f2));
	}
	
	@Test
	public void testFornecedoresDiferentes() {
		Fornecedor f2 = new Fornecedor("Dona", "dines@gmail.com", "83 9999-5050");
		assertFalse(f.equals(f2));
	}
	
	@Test
	public void testAdicionarComboValido() {
		f.adicionarProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		f.adicionarProduto("Suco", "Suco de maracuja (copo)", "1.50");
		f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer de carne "
				+ "com queijo e calabresa, Suco - Suco de maracuja (copo)");
		assertTrue(f.getCombos().containsKey("X-burguer + sucoX-burguer com suco de maracuja"));
	}
	
	@Test
	public void testAdicionarComboInvalido() {
		f.adicionarProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		f.adicionarProduto("Suco", "Suco de maracuja (copo)", "1.50");
		f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer de carne "
				+ "com queijo e calabresa, Suco - Suco de maracuja (copo)");
		assertThrows(IllegalArgumentException.class, () -> f.adicionarCombo("X-burguer + suco", "X-burguer com suco de "
				+ "maracuja", "0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarCombo("", "X-burguer com suco de maracuja", "0.20", 
				"X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarCombo("X-burguer + suco", "", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "-1", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "1", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)"));
		assertThrows(IllegalArgumentException.class, () -> f.adicionarCombo("X-burguer + suco", "X-burguer com suco de "
				+ "maracuja", "0.20", ""));	
	}
	
	@Test
	public void testExibirComboValido() {
		f.adicionarProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		f.adicionarProduto("Suco", "Suco de maracuja (copo)", "1.50");
		f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer de carne "
				+ "com queijo e calabresa, Suco - Suco de maracuja (copo)");
		assertEquals("X-burguer + suco - X-burguer com suco de maracuja - R$4,80", f.exibirProduto("X-burguer + suco", "X-burguer com suco de maracuja"));
	}
	
	@Test
	public void testExibirComboInvalido() {
		f.adicionarProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		f.adicionarProduto("Suco", "Suco de maracuja (copo)", "1.50");
		f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer de carne "
				+ "com queijo e calabresa, Suco - Suco de maracuja (copo)");
		assertThrows(IllegalArgumentException.class, () -> f.exibirProduto("", "X-burguer com suco de maracuja"));
		assertThrows(IllegalArgumentException.class, () -> f.exibirProduto("X-burguer + suco", ""));
		assertThrows(IllegalArgumentException.class, () -> f.exibirProduto("Rubacao com suco", "Rubacao completo com suco"));
	}
	
	@Test
	public void testExibirCombos() {
		f.adicionarProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		f.adicionarProduto("Suco", "Suco de maracuja (copo)", "1.50");
		f.adicionarCombo("X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer de carne "
				+ "com queijo e calabresa, Suco - Suco de maracuja (copo)");
		
		f.adicionarProduto("Coca-cola", "Coca-cola (lata)", "3.00");
		f.adicionarCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		
		assertEquals("Dona In�s - Coca-cola - Coca-cola (lata) - R$3,00 | Dona In�s - Suco - Suco de maracuja (copo) - R$1,50 | Dona In�s - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | Dona In�s - X-burguer + refrigerante - X-burguer com refri (lata) - R$6,00 | Dona In�s - X-burguer + suco - X-burguer com suco de maracuja - R$4,80", f.exibirProdutos());
	}
	
	@Test
	public void testEditarComboValido() {
		f.adicionarProduto("Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		f.adicionarProduto("Refrigerante", "Refrigerante (lata)", "2.50");
		f.adicionarCombo("Coxao com batata", "Coxao de frango com batata frita", "0.30", "Coxao de Frango - Coxao de frango com cheddar, "
				+ "Refrigerante - Refrigerante (lata)");
		f.editarCombo("Coxao com batata", "Coxao de frango com batata frita", "0.20");
		assertEquals("Coxao com batata - Coxao de frango com batata frita - R$4,00", f.exibirProduto("Coxao com batata", "Coxao de frango com batata frita"));
	}
	
	@Test
	public void testEditarComboInvalido() {
		f.adicionarProduto("Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		f.adicionarProduto("Refrigerante", "Refrigerante (lata)", "2.50");
		f.adicionarCombo("Coxao com batata", "Coxao de frango com batata frita", "0.30", "Coxao de Frango - Coxao de frango com cheddar, "
				+ "Refrigerante - Refrigerante (lata)");
		assertThrows(IllegalArgumentException.class, () -> f.editarCombo("", "Coxao de frango com batata frita", "0.20"));
		assertThrows(IllegalArgumentException.class, () -> f.editarCombo("Coxao com batata", "", "0.20"));
		assertThrows(IllegalArgumentException.class, () -> f.editarCombo("Coxao com batata", "Coxao de frango com batata frita", "-0.20"));
		assertThrows(IllegalArgumentException.class, () -> f.editarCombo("Coxao com batata", "Coxao de frango com batata frita", "1.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarCombo("Coxao e batata", "Coxao de frango e batata frita", "0.20"));
	}
	
	@Test
	public void testRemoverComboValido() {
		f.adicionarProduto("Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		f.adicionarProduto("Refrigerante", "Refrigerante (lata)", "2.50");
		f.adicionarCombo("Coxao com batata", "Coxao de frango com batata frita", "0.30", "Coxao de Frango - Coxao de frango com cheddar, "
				+ "Refrigerante - Refrigerante (lata)");
		f.removerProduto("Coxao com batata", "Coxao de frango com batata frita");
		assertTrue(!f.getCombos().containsKey("Coxao com batataCoxao de frango com batata frita"));
	}
	
	@Test
	public void testRemoverComboInvalido() {
		f.adicionarProduto("Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		f.adicionarProduto("Refrigerante", "Refrigerante (lata)", "2.50");
		f.adicionarCombo("Coxao com batata", "Coxao de frango com batata frita", "0.30", "Coxao de Frango - Coxao de frango com cheddar, "
				+ "Refrigerante - Refrigerante (lata)");
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("Coxao com batata", ""));
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("Coxao e batata", "Coxao de frango e batata frita"));
	}
}
