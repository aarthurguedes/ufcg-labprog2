package lab5;

/**
* Representa��o de um produto (de responsabilidade de um fornecedor), que possui nome e descri��o (indentifica��es �nicas), al�m do pre�o. 
*
* @author Arthur Guedes
*/
public class Produto {
	
	/**
	* Pre�o do produto.
	*/
	private String preco;
	/**
	* Nome do produto.
	*/
	private String nome;
	/**
	* Descri��o do produto.
	*/
	private String descricao;
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a constru��o do produto e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param preco o pre�o do produto
	*/ 
	private void verificaAtributosProduto(String nome, String descricao, String preco) {
		String msgErro = "Erro no cadastro de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (preco.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "preco nao pode ser vazio ou nulo.");
		} else if (Float.parseFloat(preco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		}
	}
	
	/**
	* Constr�i o produto a partir do seu pre�o, nome e descri��o.
	*
	* @param preco o pre�o do produto
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	*/
	public Produto(String preco, String nome, String descricao) {
		verificaAtributosProduto(nome, descricao, preco);
		
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * @return o pre�o do produto
	 */
	public String getPreco() {
		return preco;
	}

	/**
	 * @param preco o novo pre�o do produto
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
	 * @return a descri��o do produto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao a nova descri��o do produto
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	* Retorna a String que representa o produto com todos os seus atributos (nome, descri��o e pre�o).
	* 
	* @return a representa��o em String do produto.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - " + "R$" + this.preco.replace(".", ",");
	}

	/**
	* Retorna o valor int que representa a posi��o do objeto na mem�ria.
	* 
	* @return a representa��o num�rica do objeto.  
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
	* Retorna o valor boolean que representa se dois produtos s�o iguais, ou seja, se possuem
	* o mesmo nome e descri��o (indetifica��es �nicas dos produtos).
	* 
	* @param obj o objeto que representa o outro produto
	* @return o valor boolean da igualdade (ou n�o) entre dois produtos.  
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
