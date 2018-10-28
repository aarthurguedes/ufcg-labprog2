package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
* Representação de um controlador para os clientes, responsável por cadastrá-los, representá-los textualmente, editar os seus cadastros
* e removê-los.
*
* @author Arthur Guedes
*/
public class ClienteController {
	
	/**
	* Mapa que representa os clientes, identificados unicamente por seu cpf.
	*/
	private Map<String, Cliente> clientes;
	
	/**
	* Constrói o controle a partir do mapa de clientes. 
	*
	*/
	public ClienteController() {
		this.clientes = new HashMap<>();
	}
	
	/**
	* Método auxiliar que lança a exceção mais adequada a partir do cpf passado como parâmetro, nos casos em que esse não está cadastrado.
	* 
	* @param cpf o cpf do cliente
	*/
	private void verificaCpf(String cpf) {
		if (!clientes.containsKey(cpf)) {
			if (cpf == null) { 
				throw new NullPointerException("Cliente não encontrado");
			} else if (cpf.trim().equals("")) {
				throw new IllegalArgumentException("Cliente não encontrado");
			} else {
				throw new NoSuchElementException("Cliente não encontrado");
			}
		}
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos clientes em uma lista e os ordena alfabeticamente.
	* 
	* @param listaClientes a lista que armazenará os clientes
	*/
	private void adicionarClientesEmLista(List<String> listaClientes) {
		for (Cliente c: clientes.values()) {
			if (c == null) {
				throw new NullPointerException("Cliente inválido encontrado");
			} else {
				listaClientes.add(c.toString() + " | ");
			}
		} 
		
		Collections.sort(listaClientes);
	}

	/**
	* Verifica se o cliente já está cadastrado a partir do cpf passado como parâmetro, caso esteja, lança uma exceção, caso contrário, 
	* cadastra o cliente. 
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/
	public void cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		if (clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Cliente já cadastrado");
		}
		
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, cliente);
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representação em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibirCliente(String cpf) {
		verificaCpf(cpf);
		return clientes.get(cpf).toString();
	}
	
	/**
	* Exibe a representação textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representação em String dos clientes
	*/
	public String exibirClientes() {
		List<String> listaClientes = new ArrayList<>();
		adicionarClientesEmLista(listaClientes);
		
		String retorno = "";
		for (String c: listaClientes) {
			retorno += c;
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Verifica se o cliente está cadastrado a partir do seu cpf, caso não esteja, lança a exceção mais adequada, caso esteja, edita os
	* seus dados, com exceção do cpf, por ser único. 
	*
	* @param cpf o cpf do cliente
	* @param novoNome o novo nome do cliente
	* @param novoEmail o novo email do cliente
	* @param novaLocalizacao o novo local de trabalho do cliente
	*/
	public void editarCadastro(String cpf, String novoNome, String novoEmail, String novaLocalização) {
		verificaCpf(cpf);
		
		Cliente cliente = clientes.get(cpf);
		cliente.setNome(novoNome);
		cliente.setEmail(novoEmail);
		cliente.setLocalizacao(novaLocalização);
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, remove o cadastro do cliente. 
	* 
	* @param cpf o cpf do cliente
	*/
	public void removerCliente(String cpf) {
		verificaCpf(cpf);
		clientes.remove(cpf);
	}
}