package lab4;

/**
* Representação de um aluno, que possui matricula (identificação única), nome e curso.
*
* @author Arthur Guedes
*/
public class Aluno {
	
	/**
	* Matrícula do aluno.
	*/
	private String matricula;
	/**
	* Nome do aluno.
	*/
	private String nome;
	/**
	* Curso do aluno.
	*/
	private String curso;
	
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
	* Constrói o aluno a partir da sua matrícula, do seu nome e curso.
	*
	* @param matricula a matricula do aluno
	* @param nome o nome do aluno
	* @param curso o curso do aluno
	*/
	public Aluno(String matricula, String nome, String curso) {
		verificaDado(matricula);
		this.matricula = matricula;
		verificaDado(nome);
		this.nome = nome;
		verificaDado(curso);
		this.curso = curso;
	}
	
	/**
	* Retorna a matrícula do aluno. 
	*
	* @return a representação em String da matrícula do aluno.
	*/
	public String getMatricula() {
		return matricula;
	}

	/**
	* Retorna o nome do aluno. 
	*
	* @return a representação em String do nome do aluno.
	*/
	public String getNome() {
		return nome;
	}

	/**
	* Retorna o curso do aluno. 
	*
	* @return a representação em String do curso do aluno.
	*/
	public String getCurso() {
		return curso;
	}
	
	/**
	* Retorna a String que representa a matrícula, o nome e o curso do aluno.
	* 
	* @return a representação em String do aluno.
	*/
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
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
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	* Retorna o valor boolean que representa se dois alunos são iguais, ou seja, se possuem
	* a mesma matrpicula (identificação única do aluno).
	* 
	* @return o valor boolean da igualdade (ou não) entre dois alunos.  
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}