package lab3;

import java.util.Arrays;

/**
* Representação da agenda de contatos.
*
* @author Arthur Guedes
*/
public class Agenda {
	
	/**
	* Array que representa a lista de contatos da agenda.
	*/
	private Contato[] contatos;
	
	/**
	* Constrói a agenda a partir da sua lista de contatos.
	*
	*/
	public Agenda() {
		this.contatos = new Contato[100];
	}
	
	/**
	* Retorna o valor booleano que representa se o cadastro foi efetuado com sucesso ou não. 
	*
	* @return o valor booleano indicando se o cadastro foi bem sucedido ou não.
	*/
	public boolean cadastrarContato(String nome, String sobrenome, String numero, int posicao) {
		if (posicao > 0 && posicao <= 100) {
			contatos[posicao - 1] = new Contato(nome, sobrenome, numero);	
			return true;
		} else {
			return false;
		}
	}
	
	/**
	* Retorna, se existir, o contato na posição indicada. 
	*
	* @return a representação em String do contato (nome, sobrenome e número).
	*/
	public String pesquisarContato(int posicao) {
		if (posicao > 0 && posicao <= 100) {
			return contatos[posicao - 1].toString() + " - " + 
					contatos[posicao - 1].getNumTelefone() + "\n";
		} else {
			return "POSIÇÃO DE CONTATO INVÁLIDA!\n";
		}
	}
	
	/**
	* Retorna a lista de contatos da agenda. 
	*
	* @return a representação em String de todos os contatos da agenda.
	*/
	public String listarContatos() {
		String listaContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				int posicao = i + 1;
				listaContatos += posicao + " - " + contatos[i].toString() + "\n";
			}
		}
		return listaContatos;
	}

	/**
	* Retorna o valor booleano que representa se duas agendas são iguais, ou seja, se possuem
	* os mesmos contatos nas mesmas posições.
	* 
	* @return a representação em boolean da igualdade (ou não) entre duas agendas.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
}