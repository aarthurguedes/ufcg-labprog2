package lab3;

/**
* Representação do contato, que contém nome, sobrenome e telefone.
*
* @author Arthur Guedes
*/
public class Contato {
	
	/**
	* Nome do contato.
	*/
	private String nome;
	/**
	* Sobrenome do contato.
	*/
	private String sobrenome;
	/**
	* Número do contato.
	*/
	private String numTelefone;
	
	/**
	* Constrói o contato a partir do seu nome, sobrenome, número e posição na agenda de contatos.
	*
	* @param nome o nome do contato
	* @param sobrenome o sobrenome do contato
	* @param numTelefone o número do telefone do contato
	* @param posicao a posicao do contato na agenda
	*/
	public Contato(String nome, String sobrenome, String numTelefone) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo");
		} else {
			this.nome = nome;
		} 

		if (sobrenome == null) {
			throw new NullPointerException("Sobrenome nulo");
		} else {
			this.sobrenome = sobrenome;
		} 
		
		if (numTelefone == null) {
			throw new NullPointerException("Número nulo");
		} else {
			this.numTelefone = numTelefone;
		} 
	}

	/**
	* Retorna o nome do contato. 
	*
	* @return a representação em String do nome do contato.
	*/
	public String getNome() {
		return nome;
	}

	/**
	* Modifica o nome do contato.
	*
	* @param nome o novo nome do contato
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	* Retorna o sobrenome do contato. 
	*
	* @return a representação em String do sobrenome do contato.
	*/
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	* Modifica o sobrenome do contato.
	*
	* @param sobrenome o novo sobrenome do contato
	*/
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	* Retorna o número do contato. 
	*
	* @return a representação em String do número do contato.
	*/
	public String getNumTelefone() {
		return numTelefone;
	}

	/**
	* Modifica o número do contato.
	*
	* @param numTelefone o novo número do contato
	*/
	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	/**
	* Retorna o valor booleano que representa se dois contatos são iguais, ou seja, se possuem
	* o mesmo nome e sobrenome.
	* 
	* @return a representação em boolean da igualdade (ou não) entre dois contatos.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	/**
	* Retorna a String que representa o nome e sobrenome do contato.
	* 
	* @return a representação em String do contato.
	*/
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome; 
	}
}