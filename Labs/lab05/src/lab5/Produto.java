package lab5;

/**
* Representação de um produto (de responsabilidade de um fornecedor), que possui nome e descrição (indentificações únicas), além do preço. 
*
* @author Arthur Guedes
*/
public class Produto {
	
	/**
	* Preço do produto.
	*/
	private String preco;
	/**
	* Nome do produto.
	*/
	private String nome;
	/**
	* Descrição do produto.
	*/
	private String descricao;
	
	/**
	* Constrói o produto a partir do seu preço, nome e descrição.
	*
	* @param preco o preço do produto
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	*/
	public Produto(String preco, String nome, String descricao) {
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
	}

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
	* Retorna a String que representa o produto com todos os seus atributos (nome, descrição e preço).
	* 
	* @return a representação em String do produto.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - " + "R$" + this.preco.replace(".", ",");
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
	* Retorna o valor boolean que representa se dois produtos são iguais, ou seja, se possuem
	* o mesmo nome e descrição (indetificações únicas dos produtos).
	* 
	* @param obj o objeto que representa o outro produto
	* @return o valor boolean da igualdade (ou não) entre dois produtos.  
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
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
