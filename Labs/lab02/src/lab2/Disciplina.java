package lab2;

/**
* Representação de uma das disciplinas cursadas pelo aluno. 
*
* @author Arthur Guedes
*/
public class Disciplina {
	
	/**
	* Nome da disciplina.
	*/
	private String nomeDisciplina;
	/**
	* Número total de horas que o aluno assistiu aula da disciplina. 
	*/
	private int horasAula;
	/**
	* Nota 1 do aluno, de um total de 4.
	*/
	private double nota1;
	/**
	* Nota 2 do aluno, de um total de 4. 
	*/
	private double nota2;
	/**
	* Nota 3 do aluno, de um total de 4. 
	*/
	private double nota3;
	/**
	* Nota 4 do aluno, de um total de 4. 
	*/
	private double nota4;
	/**
	* Soma das 4 notas do aluno. 
	*/
	private double somaNotas;
	
	/**
	* Contrói a disciplina a partir do seu nome.
	*
	* @param nomeDisciplina o nome da disciplina
	*/
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	* Cadastra as horas de aula assistida pelo aluno. 
	*
	* @param horas a quantidade de horas de aula assistida
	*/
	public void cadastraHoras(int horas) {
		this.horasAula += horas;
	}
	
	/**
	* Cadastra o valor da respectiva nota do aluno. 
	*
	* @param nota a respectiva nota (1, 2, 3 ou 4) a ser cadastrada
	* @param valorNota o valor da nota a ser cadastrada
	*/
	public void cadastraNota(int nota, double valorNota) {
		switch (nota) {
			case 1:
				this.nota1 = valorNota;
				somaNotas += valorNota;
				break;
			case 2:
				this.nota2 = valorNota;
				somaNotas += valorNota;
				break;
			case 3:
				this.nota3 = valorNota;
				somaNotas += valorNota;
				break;
			case 4:
				this.nota4 = valorNota;
				somaNotas += valorNota;
				break;
		}
	}

	/**
	* Retorna um valor booleano que representa se o aluno foi aprovado ou não.
	*
	* @return a representação em booleano da aprovação ou não do aluno. 
	*/
	public boolean aprovado() {
		if ((somaNotas / 4) >= 7.0) {
			return true;
		} else {
			return false; 
		}
	}
	 
	/**
	* Retorna a String que representa o nome da disciplina, o número de horas de aula
	* assistida pelo estudante, a média do aluno na disciplina e suas respectivas notas.
	* 
	* @return a representação em String da disciplina e do desempenho do aluno.
	*/
	public String toString() {
		return this.nomeDisciplina + " " + this.horasAula + " " + (somaNotas / 4) +
				" " + "[" + this.nota1 + ", " + this.nota2 + ", " + this.nota3 +
				", " + this.nota4 + "]"; 
	} 
	
}
