package lab5;

import java.util.HashMap;
import java.util.Map;

/**
* Representação de um combo de produtos simples, que possui nome, descricao e preço. 
*
* @author Arthur Guedes
*/
public class Combo extends ProdutoAbstrato {
	
	/**
	* Produtos que compõem o combo.
	*/
	private Map<String, ProdutoSimples> produtosSimples;
	/**
	* Fator de promoção.
	*/
	private String fator;

	/**
	* Constrói o combo a partir do seu nome, descricao, fator e dos produtos que o compõem.
	*
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto do combo
	* @param produtos os produtos que formam o combo
	*/
	public Combo(String nome, String descricao, String fator, String produtos) {
		vb.verificaParametrosCombo(nome, descricao, fator, produtos);
		this.nome = nome; 
		this.descricao = descricao;
		this.fator = fator;
		this.produtosSimples = new HashMap<>();
	}

	/**
	 * @return o mapa de produtos
	 */
	public Map<String, ProdutoSimples> getProdutosSimples() {
		return produtosSimples;
	}

	/**
	 * @param produtosSimples o novo mapa de produtos
	 */
	public void setProdutosSimples(Map<String, ProdutoSimples> produtosSimples) {
		this.produtosSimples = produtosSimples;
	}

	/**
	 * @return o fator de desconto
	 */
	public String getFator() {
		return fator;
	}

	/**
	 * @param produtosSimples o novo mapa de produtos que formam o combo
	 */
	public void setFator(String fator) {
		this.fator = fator;
	}
}