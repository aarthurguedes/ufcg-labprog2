package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.SAGAController;

class SAGAControllerTest {

	private SAGAController sc;
	
	@BeforeEach
	public void criaSAGAController() {
		sc = new SAGAController();
		adicionaObjetos();
		sc.adicionaCompra("19418510068", "Marcos", "03/12/2013", "Coxao com batata", "Coxao de frango com batata frita");
	}
	
	private void adicionaObjetos() {
		sc.adicionaCliente("19418510068", "Amigao Fernandes", "amigao_fernandes@ccc.ufcg.edu.br", "LSD");
		sc.adicionaFornecedor("Marcos", "marcos@gmail.com", "83 99151-3570");
		sc.adicionaProduto("Marcos", "Coxao de Frango", "Coxao de frango com cheddar", "2.50");
		sc.adicionaProduto("Marcos", "Refrigerante", "Refrigerante (lata)", "2.50");
		sc.adicionaCombo("Marcos", "Coxao com batata", "Coxao de frango com batata frita", "0.30", "Coxao de Frango - "
				+ "Coxao de frango com cheddar, Refrigerante - Refrigerante (lata)");
	}
	
	@Test
	public void testAdicionaCompraValida() {
		assertTrue(sc.getCc().getClientes().get("19418510068").getContas().containsKey("Marcos"));
	}
	
	@Test
	public void testAdicionaCompraInvalida() {
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("194185100680", "Marcos", "03/12/2013", "Coxao com batata", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510069", "Marcos", "03/12/2013", "Coxao com batata", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "", "03/12/2013", "Coxao com batata", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "Seu Olavo", "03/12/2013", "Coxao com batata", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "Marcos", "", "Coxao com batata", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "Marcos", "03/13/2013", "Coxao com batata", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "Marcos", "03/12/2013", "", "Coxao de frango com batata frita"));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "Marcos", "03/12/2013", "Coxao com batata", ""));
		assertThrows(IllegalArgumentException.class, () -> sc.adicionaCompra("19418510068", "Marcos", "03/12/2013", "Coxao e batata", "Coxao de frango com batata frita"));
	}
	
	@Test
	public void testGetDebitoValido() {
		assertEquals("3.50", sc.getDebito("19418510068", "Marcos"));
	}
	
	@Test
	public void testGetDebitoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> sc.getDebito("194185100680", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.getDebito("19418510069", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.getDebito("19418510068", ""));
		assertThrows(IllegalArgumentException.class, () -> sc.getDebito("19418510068", "Seu Olavo"));
	}
	
	@Test
	public void testExibeContasValidas() {
		assertEquals("Cliente: Amigao Fernandes | Marcos | Coxao com batata - 03-12-2013", sc.exibeContas("19418510068", "Marcos"));
	}
	
	@Test
	public void testExibeContasInvalidas() {
		assertThrows(IllegalArgumentException.class, () -> sc.exibeContas("194185100680", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.exibeContas("19418510069", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.exibeContas("19418510068", ""));
		assertThrows(IllegalArgumentException.class, () -> sc.exibeContas("19418510068", "Seu Olavo"));
	}
	
	private void adicionaMaisObjetos() {
		sc.adicionaFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		sc.adicionaProduto("Seu Olavo", "X-burguer", "Hamburguer de carne com queijo e calabresa", "4.50");
		sc.adicionaProduto("Seu Olavo", "Suco", "Suco de maracuja (copo)", "1.50");
		sc.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", "0.20", "X-burguer - Hamburguer "
				+ "de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
		sc.adicionaCompra("19418510068", "Seu Olavo", "02/04/2015", "X-burguer + suco", "X-burguer com suco de maracuja");
	}
	
	@Test
	public void testExibeContasClientesValidas() {
		adicionaMaisObjetos();
		assertEquals("Cliente: Amigao Fernandes | Marcos | Coxao com batata - 03-12-2013 | Seu Olavo | X-burguer + suco - "
				+ "02-04-2015", sc.exibeContasClientes("19418510068"));
	}
	
	@Test
	public void testExibeContasClientesInvalidas() {
		adicionaMaisObjetos();
		assertThrows(IllegalArgumentException.class, () -> sc.exibeContasClientes("194185100680"));
		assertThrows(IllegalArgumentException.class, () -> sc.exibeContasClientes("19418510069"));
	}
	
	@Test
	public void testRealizaPagamentoValido() {
		sc.realizaPagamento("19418510068", "Marcos");
		assertTrue(!sc.getCc().getClientes().get("19418510068").getContas().containsKey("Marcos"));
	}
	
	@Test
	public void testRealizaPagamentoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> sc.realizaPagamento("", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.realizaPagamento("194185100680", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.realizaPagamento("19418510069", "Marcos"));
		assertThrows(IllegalArgumentException.class, () -> sc.realizaPagamento("19418510068", ""));
		assertThrows(IllegalArgumentException.class, () -> sc.realizaPagamento("19418510068", "Seu Olavo"));
	}

}
