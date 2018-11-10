package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Compra;

class CompraTest {

	private Compra c;
	
	@BeforeEach
	public void criaCompra() {
		c = new Compra("03/12/2013", "Coxao com batata - Coxao de frango com batata frita", "5.00");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("03/12/2013", c.getData());
		assertEquals("Coxao com batata - Coxao de frango com batata frita", c.getIdProduto());
		assertEquals("5.00", c.getPreco());
	}

}
