package lab2;

/**
* A conta de laboratório é responsável por manter o registro da quantidade 
* de espaço utilizado, pelo aluno, em determinado laboratório.
* 
* @author Arthur Guedes
*/
public class ContaLaboratorio {
	
	/**
	* Nome do laboratório.
	*/
	private String nomeLaboratorio;
	/**
	* A cota determina o limite de espaço disponível no sistema de armazenamento.
	* A cota de todo laboratório é, por padrão, 2000mb (aproximadamente 2gb).
	*/
	private int cota = 2000;
	/**
	* Espaço total consumido pelo estudante.
	*/
	private int espacoConsumido;
	
	/**
	* Constrói uma conta de laboratório a partir do nome do laboratório.
	*
	* @param nomeLaboratorio o nome do laboratório
	*/
	public ContaLaboratorio (String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}
	
	/**
	* Constrói uma conta de laboratório a partir do nome do laboratório e da cota.
	*
	* @param nomeLaboratorio o nome do laboratório
	* @param cota a cota de espaço que o aluno dispõe
	*/
	public ContaLaboratorio (String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	* Aumenta o espaço consumido pelo aluno.
	*
	* @param mbytes o tamanho em mbytes (mb) a ser consumido
	*/
	public void consomeEspaco(int mbytes) {
		this.espacoConsumido += mbytes;
	}
	
	/**
	* Libera (diminui) o espaço consumido pelo aluno.
	* 
	* @param mbytes o tamanho em mbytes (mb) a ser liberado
	*/
	public void liberaEspaco(int mbytes) {
		this.espacoConsumido -= mbytes;
	}
	
	/**
	* Retorna um valor booleano que representa se o aluno já atingiu ou não a cota
	* do lCC.
	*
	* @return a representação em booleano do atingimento da cota. 
	*/
	public boolean atingiuCota() {
		if (this.espacoConsumido >= this.cota) {
			return true;
		} else {
			return false; 
		}
	}
	
	/**
	* Retorna a String que representa o nome do laboratório, o espaço ocupado e a cota.
	*
	* @return a representação em String da conta de laboratório de um aluno.
	*/
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoConsumido + "/" + this.cota;
	}
}