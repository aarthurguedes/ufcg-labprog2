package lab5;

/**
* Representação de uma compra do cliente, que possui data, identificação do produto e preço. 
*
* @author Arthur Guedes
*/
public class Compra {
	
	/**
	* Data da compra.
	*/
	private String data;
	/**
	* Identificação do produto comprado (nome + descricao).
	*/
	private String idProduto;
	/**
	* Preço da compra.
	*/
	private String preco;
	
	/**
	* Constrói a compra a partir da sua data, do id do produto e do preço.
	*
	* @param data a data da compra
	* @param idProduto o id do produto comprado
	* @param preco o preço da compra
	*/
	public Compra(String data, String idProduto, String preco) {
		this.data = data;
		this.idProduto = idProduto;
		this.preco = preco;
	}

	/**
	 * @return a data da compra
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data a nova data da compra
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return o id do produto comprado
	 */
	public String getIdProduto() {
		return idProduto;
	}
	
	/**
	 * @param idProduto o id do produto
	 */
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * @return o preço da compra
	 */
	public String getPreco() {
		return preco;
	}

	/**
	 * @param preco o novo preço da compra
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}
}
