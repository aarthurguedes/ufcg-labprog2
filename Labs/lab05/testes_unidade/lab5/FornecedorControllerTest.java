package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.FornecedorController;

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
	
	@Test
	public void testAdicionaComboValido() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "5.00");
		fc.adicionaProduto("Seu Olavo", "Coca-cola", "Coca-cola (lata)", "3.00");
		fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		assertTrue(fc.getFornecedores().get("Seu Olavo").getCombos().containsKey("X-burguer + refrigeranteX-burguer com refri (lata)"));
	}
	
	@Test
	public void testAdicionaComboInvalido() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "5.00");
		fc.adicionaProduto("Seu Olavo", "Coca-cola", "Coca-cola (lata)", "3.00");
		fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("", "X-burguer + refrigerante", "X-burguer com "
				+ "refri (lata)", "0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Olavo", "X-burguer + refrigerante", "X-burguer com "
				+ "refri (lata)", "0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com "
				+ "refri (lata)", "0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Seu Olavo", "", "X-burguer com "
				+ "refri (lata)", "0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "", 
				"0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com "
				+ "refri (lata)", "-0.20", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com "
				+ "refri (lata)", "1.00", "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)"));
		assertThrows(IllegalArgumentException.class, () -> fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com "
				+ "refri (lata)", "1.00", ""));
	}
	
	@Test
	public void testExibeComboValido() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		fc.adicionaProduto("Seu Olavo", "Coca-cola", "Coca-cola (lata)", "3.00");
		fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		assertEquals("X-burguer + refrigerante - X-burguer com refri (lata) - R$6,00", fc.exibeProduto("X-burguer + refrigerante", "X-burguer com refri (lata)", 
				"Seu Olavo"));
	}
	
	@Test
	public void testExibeComboInvalido() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		fc.adicionaProduto("Seu Olavo", "Coca-cola", "Coca-cola (lata)", "3.00");
		fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("", "X-burguer com refri (lata)", "Seu Olavo"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("X-burguer + refrigerante", "X-burguer com refri (lata)", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("X-burguer + refrigerante", "X-burguer com refri (lata)", "Olavo"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("X-burguer + refrigerante", "", "Seu Olavo"));
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProduto("X-burguer com refrigerante", "X-burguer e refri (lata)", "Seu Olavo"));
	}
	
	@Test
	public void testExibirCombosFornecedorValido() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		fc.adicionaProduto("Seu Olavo", "Coca-cola", "Coca-cola (lata)", "3.00");
		fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		
		fc.adicionaProduto("Seu Olavo", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		fc.adicionaCombo("Seu Olavo", "Coxao de Frango + refrigerante", "Coxao de frango com refri", "0.25", 
				"Coxao de Frango - Coxao de frango com cheddar, Coca-cola - Coca-cola (lata)");
		
		assertEquals("Seu Olavo - Coca-cola - Coca-cola (lata) - R$3,00 | Seu Olavo - Coxao de Frango - Coxao de frango "
				+ "com cheddar - R$2,50 | Seu Olavo - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | "
				+ "Seu Olavo - Coxao de Frango + refrigerante - Coxao de frango com refri - R$4,13 | Seu Olavo - "
				+ "X-burguer + refrigerante - X-burguer com refri (lata) - R$6,00", fc.exibeProdutosFornecedor("Seu Olavo"));
	}
	
	@Test
	public void testExibirCombosFornecedorInvalido() {
		assertThrows(IllegalArgumentException.class, () -> fc.exibeProdutosFornecedor(""));
	}
	
	@Test
	public void testExibirCombos() {
		fc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		fc.adicionaProduto("Seu Olavo", "Coca-cola", "Coca-cola (lata)", "3.00");
		fc.adicionaCombo("Seu Olavo", "X-burguer + refrigerante", "X-burguer com refri (lata)", "0.20", "X-burguer - "
				+ "Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
		
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		fc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", "2.50");
		fc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", "0.30", 
				"Coxao de Frango - Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
		
		assertEquals("Marcos - Coxao com batata - Coxao de frango com batata frita - R$3,50 | Marcos - Coxao de Frango - "
				+ "Coxao de frango com cheddar - R$2,50 | Marcos - Refrigerante - Refrigerante (lata) - R$2,50 | Seu Olavo "
				+ "- Coca-cola - Coca-cola (lata) - R$3,00 | Seu Olavo - X-burguer - Hamburguer de carne com queijo e "
				+ "calabresa - R$4,50 | Seu Olavo - X-burguer + refrigerante - X-burguer com refri (lata) - R$6,00", fc.exibeProdutos());
	}
	
	@Test
	public void testEditaComboValido() {
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		fc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", "2.50");
		fc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", "0.30", 
				"Coxao de Frango - Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
		fc.editaCombo("Coxao com batata", "Coxao de frango com batata frita", "Marcos", "0.20");
		assertEquals("Coxao com batata - Coxao de frango com batata frita - R$4,00", fc.exibeProduto("Coxao com batata", 
				"Coxao de frango com batata frita", "Marcos"));
	}
	
	@Test
	public void testEditaComboInvalido() {
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		fc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", "2.50");
		fc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", "0.30", 
				"Coxao de Frango - Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
		
		assertThrows(IllegalArgumentException.class, () -> fc.editaCombo("", "Coxao de frango com batata frita", "Marcos", "0.20"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaCombo("Coxao com batata", "", "Marcos", "0.20"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaCombo("Coxao com batata", "Coxao de frango com batata "
				+ "frita", "", "0.20"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaCombo("Coxao com batata", "Coxao de frango com batata "
				+ "frita", "Marcos", "0.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaCombo("Coxao com batata", "Coxao de frango com batata "
				+ "frita", "Marcos", "1.00"));
		assertThrows(IllegalArgumentException.class, () -> fc.editaCombo("Coxao e batata", "Coxao de frango e batata "
				+ "frita", "Marcos", "0.20"));
	}
	
	@Test
	public void testRemoveComboValido() {
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		fc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", "2.50");
		fc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", "0.30", 
				"Coxao de Frango - Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
		fc.removeProduto("Coxao com batata", "Coxao de frango com batata frita", "Marcos");
		assertTrue(!fc.getFornecedores().get("Marcos").getCombos().containsKey("Coxao com batataCoxao de frango com batata frita"));
	}
	
	@Test
	public void testRemoveComboInvalido() {
		fc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		fc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		fc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", "2.50");
		fc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", "0.30", 
				"Coxao de Frango - Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("", "Coxao de frango com batata frita", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Coxao com batata", "", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Coxao com batata", "Coxao de frango com batata frita", ""));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Coxao com batata", "Coxao de frango com batata frita", "Seu Olavo"));
		assertThrows(IllegalArgumentException.class, () -> fc.removeProduto("Coxao e batata", "Coxao de frango e batata frita", "Marcos"));
	}
}