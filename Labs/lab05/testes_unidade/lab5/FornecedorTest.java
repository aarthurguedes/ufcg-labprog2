package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	private Fornecedor f;
	
	@BeforeEach
	public void criaFornecedor() {
		f = new Fornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Dona Inês", f.getNome());
		assertEquals("dines@gmail.com", f.getEmail());
		assertEquals("83 9999-5050", f.getTelefone());
	}
	
	@Test
	public void testNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "dines@gmail.com", "83 9999-5050"));
	} 
	
	@Test
	public void testEmailInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Dona Inês", "", "83 9999-5050"));
	}
	
	@Test
	public void testTelefoneInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Dona Inês", "dines@gmail.com", ""));
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
		f.adicionarProduto("Tapioca completa", "Tapioca com côco, queijo e manteiga", "3.50");
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		f.adicionarProduto("Bolo", "Bolo de chocolate", "3.00");
		assertEquals("Dona Inês - Bolo - Bolo de chocolate - R$3,00 | Dona Inês - Tapioca completa - Tapioca com côco, queijo e manteiga - R$3,50 | "
				+ "Dona Inês - Tapioca simples - Tapioca com manteiga - R$3,00", f.exibirProdutos());
	}
	
	@Test
	public void testEditarProdutoValido() {
		f.adicionarProduto("Tapioca completa", "Tapioca com côco, queijo e manteiga", "3.50");
		f.editarProduto("Tapioca completa", "Tapioca com côco, queijo e manteiga", "1.50");
		assertEquals("1.50", f.getProdutos().get("Tapioca completaTapioca com côco, queijo e manteiga").getPreco());
	}
	
	@Test
	public void testEditarProdutoInvalido() {
		f.adicionarProduto("Tapioca simples", "Tapioca com manteiga", "3.00");
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("Tapioca simples", "Tapioca com manteiga", "-3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("", "Tapioca com manteiga", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("Tapioca simples", "", "3.00"));
		assertThrows(IllegalArgumentException.class, () -> f.editarProduto("Tapioca completa", "Tapioca com côco, queijo e manteiga", "1.50"));
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
		assertThrows(IllegalArgumentException.class, () -> f.removerProduto("Tapioca completa", "Tapioca com côco, queijo e manteiga"));
	}
	
	@Test
	public void testToString() {
		assertEquals("Dona Inês - dines@gmail.com - 83 9999-5050", f.toString());
	}
	
	@Test
	public void testFornecedoresIguais() {
		Fornecedor f2 = new Fornecedor("Dona Inês", "donaines@gmail.com", "83 8888-4040");
		assertTrue(f.equals(f2));
	}
	
	@Test
	public void testFornecedoresDiferentes() {
		Fornecedor f2 = new Fornecedor("Dona", "dines@gmail.com", "83 9999-5050");
		assertFalse(f.equals(f2));
	}
}
