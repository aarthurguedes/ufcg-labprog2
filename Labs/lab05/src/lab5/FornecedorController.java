package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
* Representa��o de um controlador para os fornecedores, respons�vel por cadastr�-los, represent�-los textualmente, editar os seus cadastros
* e remov�-los.
*
* @author Arthur Guedes
*/
public class FornecedorController {
	
	/**
	* Mapa que representa os fornecedores, identificados unicamente por seu nome.
	*/
	Map<String, Fornecedor> fornecedores;

	/**
	* Constr�i o controle a partir do mapa de fornecedores. 
	*
	*/
	public FornecedorController() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	* M�todo auxiliar que lan�a a exce��o mais adequada a partir do nome passado como par�metro, nos casos em que esse n�o est� cadastrado.
	* 
	* @param nome o nome do fornecedor
	*/
	private void verificaNome(String nome) {
		if (!fornecedores.containsKey(nome)) {
			if (nome == null) { 
				throw new NullPointerException("Cliente n�o encontrado");
			} else if (nome.trim().equals("")) {
				throw new IllegalArgumentException("Cliente n�o encontrado");
			} else {
				throw new NoSuchElementException("Cliente n�o encontrado");
			}
		}
	}
	
	/**
	* M�todo auxiliar que adiciona as representa��es (em String) dos fornecedores em uma lista e os ordena alfabeticamente.
	* 
	* @param listaFornecedores a lista que armazenar� os fornecedores
	*/
	private void adicionarFornecedoresEmLista(List<String> listaFornecedores) {
		for (Fornecedor f: fornecedores.values()) {
			if (f == null) {
				throw new NullPointerException("Fornecedor inv�lido encontrado");
			} else {
				listaFornecedores.add(f.toString() + " | ");
			}
		} 
		
		Collections.sort(listaFornecedores);
	}
	
	/**
	* Verifica se o fornecedor j� est� cadastrado a partir do nome passado como par�metro, caso esteja, lan�a uma exce��o, caso contr�rio, 
	* cadastra o fornecedor. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void cadastrarFornecedor(String nome, String email, String telefone) {
		if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Cliente j� cadastrado");
		}

		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, fornecedor);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, retorna a representa��o em String do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	* @return uma representa��o em String do fornecedor, se o mesmo estiver cadastrado.
	*/
	public String exibirFornecedor(String nome) {
		verificaNome(nome);
		return fornecedores.get(nome).toString();
	}
	
	/**
	* Exibe a representa��o textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representa��o em String dos fornecedores
	*/
	public String exibirFornecedores() {
		List<String> listaFornecedores = new ArrayList<>();
		adicionarFornecedoresEmLista(listaFornecedores);
		
		String retorno = "";
		for (String f: listaFornecedores) {
			retorno += f;
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Verifica se o fornecedor est� cadastrado a partir do seu nome, caso n�o esteja, lan�a a exce��o mais adequada, caso esteja, edita os
	* seus dados, com exce��o do nome, por ser �nico. 
	*
	* @param nome o nome do fornecedor
	* @param novoEmail o novo email do fornecedor
	* @param novoTelefone o novo telefone do fornecedor
	*/
	public void editarCadastro(String nome, String novoEmail, String novoTelefone) {
		verificaNome(nome);
		
		Fornecedor fornecedor = fornecedores.get(nome);
		fornecedor.setEmail(novoEmail);
		fornecedor.setTelefone(novoTelefone);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, remove o cadastro do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	*/
	public void removerCliente(String nome) {
		verificaNome(nome);
		fornecedores.remove(nome);
	}
}
