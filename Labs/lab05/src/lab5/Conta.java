package lab5;

import java.util.ArrayList;
import java.util.List;

import ferramentas.Calculador;

/**
* Representação de uma conta das compras dos clientes. 
*
* @author Arthur Guedes
*/
public class Conta {
	
	/**
	* Lista de compras da conta.
	*/
	private List<Compra> compras;
	/**
	* Objeto calculador de preços.
	*/
	private Calculador c;

	/**
	* Constrói a conta, inicializando a lista de compras.
	*
	*/
	public Conta() {
		this.compras = new ArrayList<>();
		this.c = new Calculador();
	}

	/**
	 * @return a lista de compras
	 */
	public List<Compra> getCompras() {
		return compras;
	}
	
	/**
	 * @param compras a nova lista de compras
	 */
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	/**
	 * @return o debito do cliente
	 */
	public String getDebito() {
		return c.calculaDebito(compras);
	}
}
