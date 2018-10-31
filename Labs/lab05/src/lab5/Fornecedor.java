package lab5;

import java.util.HashMap;
import java.util.Map;

/**
* Representação de um fornecedor de lanches, que possui nome (identificação única), email e telefone.
*
* @author Arthur Guedes
*/
public class Fornecedor {
	
	/**
	* Nome do fornecedor.
	*/
	private String nome;
	/**
	* Email do fornecedor.
	*/
	private String email;
	/**
	* Telefone do fornecedor.
	*/
	private String telefone;
	/**
	* Mapa de produtos do fornecedor.
	*/
	private Map<String, Produto> produtos;
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a construção do fornecedor e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	private void verificaAtributosFornecedor(String nome, String email, String telefone) {
		String msgErro = "Erro na construção do fornecedor: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "email nao pode ser vazio ou nulo.");
		} else if(telefone.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "telefone nao pode ser vazia ou nula.");
		} 
	}
	
	/**
	* Constrói o fornecedor a partir do seu nome, email e telefone.
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public Fornecedor(String nome, String email, String telefone) {
		verificaAtributosFornecedor(nome, email, telefone);
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	/**
	 * @return o nome do fornecedor
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome o novo nome do fornecedor
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o email do fornecedor
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email o novo email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return o telefone do fornecedor
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone o novo telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return os produtos do fornecedor
	 */
	public Map<String, Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos os novos produtos do fornecedor
	 */
	public void setProdutos(Map<String, Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	* Retorna a String que representa o fornecedor no formato: nome - email - telefone.
	* 
	* @return a representação em String do fornecedor.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	* Retorna o valor boolean que representa se dois fornecedores são iguais, ou seja, se possuem
	* o mesmo nome (identificação única do fornecedor).
	* 
	* @param obj o objeto que representa o outro fornecedor
	* @return o valor boolean da igualdade (ou não) entre dois fornecedores.  
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
