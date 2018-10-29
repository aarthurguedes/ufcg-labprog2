package lab5;

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
	* Telefone do cliente.
	*/
	private String telefone;
	
	/**
	* Método auxiliar que lança a exceção mais adequada se algum dos parâmetros passados para a construção do Fornecedor for inválido 
	* (nulo ou vazio).
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/ 
	private void verificaParametros(String nome, String email, String telefone) {
		if (nome == null || email == null || telefone == null) {
			throw new NullPointerException("Objeto null passado como parâmetro.");
		} else if (nome.trim().equals("") || email.trim().equals("") || telefone.trim().equals("")) {
			throw new IllegalArgumentException("String vazia passada como parâmetro");
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
		verificaParametros(nome, email, telefone);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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
	* Retorna a String que representa o fornecedor com todos os seus atributos (nome, email e telefone).
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
