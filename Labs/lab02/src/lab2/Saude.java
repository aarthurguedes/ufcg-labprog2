package lab2;

/**
* Representação do estado de saude geral (fisica e mental) do aluno. 
*
* @author Arthur Guedes
*/
public class Saude {
	
	/**
	* Saúde mental do aluno.
	*/
	private String saudeMental;
	/**
	* Saúde física do aluno.
	*/
	private String saudeFisica;
	
	/**
	* Contrói a saúde do aluno. Por padrão, ambas as saúdes são consideradas "boas".
	*
	*/
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}
	
	/**
	* Define a saúde mental do aluno.
	*
	* @param valor o estado da saúde mental do aluno
	*/
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	
	/**
	* Define a saúde física do aluno.
	*
	* @param valor o estado da saúde física do aluno
	*/
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	* Retorna a String que representa o estado de saúde geral do aluno.
	*
	* @return a representação em String do estado de saúde do aluno.
	*/
	public String getStatusGeral() {
		if (this.saudeFisica.equals("fraca") && this.saudeMental.equals("fraca")) {
			return "fraca";
		} else if (this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")) {
			return "boa";
		} else {
			return "ok";
		}
	}
	
}
