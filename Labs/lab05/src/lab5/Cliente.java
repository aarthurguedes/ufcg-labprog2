package lab5;

/**
* Representa��o de um cliente, que possui cpf (identifica��o �nica), nome, email e local de trabalho (localiza��o).
*
* @author Arthur Guedes
*/
public class Cliente {
	
	/**
	* CPF do cliente.
	*/
	private String cpf;
	/**
	* Nome do cliente.
	*/
	private String nome;
	/**
	* Email do cliente.
	*/
	private String email;
	/**
	* Local de trabalho do cliente.
	*/
	private String localizacao;
	
	/**
	* Constr�i o cliente a partir do seu cpf, nome, email e localiza��o.
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/
	public Cliente(String cpf, String nome, String email, String localizacao) {			
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	/**
	 * @return o cpf do cliente
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * @param cpf o novo cpf do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * @return o nome do cliente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome o novo nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return o email do cliente
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email o novo email do cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return o local de trabalho do cliente
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * @param localizacao a nova localiza��o (local de trabalho) do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	* Retorna a String que representa o cliente no formato: nome - localizacao - email.
	* 
	* @return a representa��o em String do cliente.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	
	/**
	* Retorna o valor boolean que representa se dois clientes s�o iguais, ou seja, se possuem
	* o mesmo cpf (identifica��o �nica do cliente).
	* 
	* @param obj o objeto que representa o outro cliente
	* @return o valor boolean da igualdade (ou n�o) entre dois clientes.  
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
