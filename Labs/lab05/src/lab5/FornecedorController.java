package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
* Representação de um controlador para os fornecedores, responsável por cadastrá-los, representá-los textualmente, editar os seus cadastros
* e removê-los.
*
* @author Arthur Guedes
*/
public class FornecedorController {
	
	/**
	* Mapa que representa os fornecedores, identificados unicamente por seu nome.
	*/
	Map<String, Fornecedor> fornecedores;

	/**
	* Constrói o controle a partir do mapa de fornecedores. 
	*
	*/
	public FornecedorController() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	* Método auxiliar que lança a exceção mais adequada a partir do nome passado como parâmetro, nos casos em que esse não está cadastrado.
	* 
	* @param nome o nome do fornecedor
	*/
	private void verificaNome(String nome) {
		if (!fornecedores.containsKey(nome)) {
			if (nome == null) { 
				throw new NullPointerException("Cliente não encontrado");
			} else if (nome.trim().equals("")) {
				throw new IllegalArgumentException("Cliente não encontrado");
			} else {
				throw new NoSuchElementException("Cliente não encontrado");
			}
		}
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos fornecedores em uma lista e os ordena alfabeticamente.
	* 
	* @param listaFornecedores a lista que armazenará os fornecedores
	*/
	private void adicionarFornecedoresEmLista(List<String> listaFornecedores) {
		for (Fornecedor f: fornecedores.values()) {
			if (f == null) {
				throw new NullPointerException("Fornecedor inválido encontrado");
			} else {
				listaFornecedores.add(f.toString() + " | ");
			}
		} 
		
		Collections.sort(listaFornecedores);
	}
	
	/**
	* Verifica se o fornecedor já está cadastrado a partir do nome passado como parâmetro, caso esteja, lança uma exceção, caso contrário, 
	* cadastra o fornecedor. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void cadastrarFornecedor(String nome, String email, String telefone) {
		if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Cliente já cadastrado");
		}

		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, fornecedor);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	* @return uma representação em String do fornecedor, se o mesmo estiver cadastrado.
	*/
	public String exibirFornecedor(String nome) {
		verificaNome(nome);
		return fornecedores.get(nome).toString();
	}
	
	/**
	* Exibe a representação textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representação em String dos fornecedores
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
	* Verifica se o fornecedor está cadastrado a partir do seu nome, caso não esteja, lança a exceção mais adequada, caso esteja, edita os
	* seus dados, com exceção do nome, por ser único. 
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
	* Verifica se o nome do fornecedor passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, remove o cadastro do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	*/
	public void removerCliente(String nome) {
		verificaNome(nome);
		fornecedores.remove(nome);
	}
}
