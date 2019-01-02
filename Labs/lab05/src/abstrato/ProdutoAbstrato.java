package abstrato;

import validacao.ValidadorBase;

/**
* Representação de um produto abstrato, que possui nome e descrição, além do preço. 
*
* @author Arthur Guedes
*/
public abstract class ProdutoAbstrato {
	
	/**
	* Preço do produto.
	*/
	protected String preco;
	/**
	* Nome do produto.
	*/
	protected String nome;
	/**
	* Descrição do produto.
	*/
	protected String descricao;
	/**
	* Objeto Verificador de parâmetros.
	*/
	protected ValidadorBase vb = new ValidadorBase();

	/**
	 * @return o preço do produto
	 */
	public String getPreco() {
		return preco;
	}

	/**
	 * @param preco o novo preço do produto
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}

	/**
	 * @return o nome do produto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome o novo nome do produto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return a descrição do produto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao a nova descrição do produto
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	* Retorna a String que representa o produto/combo com todos os seus atributos (nome, descrição e preço).
	* 
	* @return a representação em String do produto/combo.
	*/
	@Override
	public String toString() {
		String precoFormatado = String.format("%.2f", Float.parseFloat(preco));
		return this.nome + " - " + this.descricao + " - " + "R$" + precoFormatado.replace(".", ",");
	}

	/**
	* Retorna o valor int que representa a posição do objeto na memória.
	* 
	* @return a representação numérica do objeto.  
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	* Retorna o valor boolean que representa se dois produtos/combos são iguais, ou seja, se possuem
	* o mesmo nome e descrição (indetificações únicas dos produtos e combos).
	* 
	* @param obj o objeto que representa o outro produto/combo
	* @return o valor boolean da igualdade (ou não) entre dois produtos/combos.  
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoAbstrato other = (ProdutoAbstrato) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
