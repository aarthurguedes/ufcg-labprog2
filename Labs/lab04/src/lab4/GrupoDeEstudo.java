package lab4;

import java.util.HashSet;

/**
* Representação de um grupo de estudo, que possui um conjunto de alunos e um nome / tema (identificação única).
*
* @author Arthur Guedes
*/
public class GrupoDeEstudo {
	
	/**
	* Alunos que participam do grupo.
	*/
	private HashSet<Aluno> alunos;
	/**
	* Nome do grupo.
	*/
	private String nome;

	/**
	* Método auxiliar que verifica se uma String passada como parâmetro é null (NullPointerException) ou vazia (IllegalArgumentException).
	* Caso seja, o programa lança uma exceção.
	*
	* @param dado a String passada como parâmetro
	*/
	private void verificaDado(String dado) {
		if (dado == null) {
			throw new NullPointerException ("Parâmetro inválido. Operação encerrada!");
		} else if (dado.trim().equals("")) {
			throw new IllegalArgumentException ("Parâmetro inválido. Operação encerrada!");
		}
	}
	
	/**
	* Constrói o grupo de estudo a partir do seu nome.
	*
	* @param nome o nome do grupo
	*/
	public GrupoDeEstudo(String nome) {
		verificaDado(nome);
		this.nome = nome;
		this.alunos = new HashSet<>(); 
	}
	
	/**
	* Retorna o nome do grupo de estudo. 
	*
	* @return a representação em String do nome do grupo.
	*/
	public String getNome() {
		return nome;
	}
	
	/**
	* Retorna o conjunto de alunos que fazem parte do grupo. 
	*
	* @return o HashSet de alunos do grupo.
	*/
	public HashSet<Aluno> getAlunos() {
		return alunos;
	}

	/**
	* Cadastra aluno no grupo de estudo.
	*
	* @param aluno o aluno a ser cadastrado
	*/
	public void cadastraAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException ("Parâmetro inválido. Objeto null.");
		} else {
			alunos.add(aluno);
		}
	}
	
	/**
	* Retorna a String que representa os alunos de um determinado grupo de estudo.
	* 
	* @return a representação em String do grupo. 
	*/
	@Override
	public String toString() {
		String retorno = "\nAlunos do grupo " + this.nome + ":\n"; 
		
		for (Aluno a: alunos) {
			retorno += "* " + a.toString() + "\n";
		}
		
		return retorno;
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
	* Retorna o valor boolean que representa se dois grupos de estudo são iguais, ou seja, se possuem
	* o mesmo nome (identificação única do grupo).
	* 
	* @return o valor boolean da igualdade (ou não) entre dois grupos. 
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeEstudo other = (GrupoDeEstudo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}