package lab2;

/**
* Representação de uma das cantinas da universidade e as respectivas contas 
* do aluno nessa. 
* 
* @author Arthur Guedes
*/
public class ContaCantina {
	
	/**
	* Nome da cantina.
	*/
	private String nomeCantina;
	/**
	* Número de itens consumidos em determinado momento.
	*/
	private int numItensConsumidos;
	/**
	* Dívida do estudante na cantina (valor a ser pago).
	*/
	private int dívida;
	/**
	* O valor total gasto com todos os lanches cadastrados.
	*/
	private int valorTotalGasto;
	
	/**
	* Constrói uma conta na cantina a partir do nome da cantina.
	*
	* @param nomeDaCantina o nome da cantina
	*/
	public ContaCantina(String nomeDaCantina) {
		this.nomeCantina = nomeDaCantina;
	}
	
	/**
	* Cadastra o lanche feito pelo estudante, a partir do numero de itens consumidos
	* na cantina e do valor total gasto com o lanche. 
	*
	* @param qtdItens a quantidade de itens consumidos na cantina
	* @param valorCentavos o valor total (em centavos) gasto com o lanche
	*/
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.numItensConsumidos += qtdItens;
		this.dívida += valorCentavos;
		this.valorTotalGasto += valorCentavos;
	}
	
	/**
	* Paga um determinado valor da conta do aluno na cantina, podendo ser o valor total 
	* ou uma parte dele. 
	*
	* @param valorCentavos o valor a ser pago (descontado na dívida)
	*/
	public void pagaConta(int valorCentavos) {
		dívida -= valorCentavos;
	}
	
	/**
	* Retorna o inteiro que representa o valor a ser pago pelo estudante. 
	*
	* @return a representação em inteiro da dívida do aluno.
	*/
	public int getFaltaPagar() {
		return this.dívida;
	}
	
	/**
	* Retorna a String que representa a conta na cantina do aluno. A representação
	* segue o formato "Nome da catina Número de itens consumidos Valor gasto com
	* todos os lanches feitos".
	*
	* @return a representação em String da conta do aluno na cantina.
	*/
	public String toString() {
		return this.nomeCantina + " " + this.numItensConsumidos + " " + this.valorTotalGasto;
	}
}
