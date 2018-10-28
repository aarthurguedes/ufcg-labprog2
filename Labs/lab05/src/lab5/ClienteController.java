package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
* Representa��o de um controlador para os clientes, respons�vel por cadastr�-los, represent�-los textualmente, editar os seus cadastros
* e remov�-los.
*
* @author Arthur Guedes
*/
public class ClienteController {
	
	/**
	* Mapa que representa os clientes, identificados unicamente por seu cpf.
	*/
	private Map<String, Cliente> clientes;
	
	/**
	* Constr�i o controle a partir do mapa de clientes. 
	*
	*/
	public ClienteController() {
		this.clientes = new HashMap<>();
	}
	
	/**
	* M�todo auxiliar que lan�a a exce��o mais adequada a partir do cpf passado como par�metro, nos casos em que esse n�o est� cadastrado.
	* 
	* @param cpf o cpf do cliente
	*/
	private void verificaCpf(String cpf) {
		if (!clientes.containsKey(cpf)) {
			if (cpf == null) { 
				throw new NullPointerException("Cliente n�o encontrado");
			} else if (cpf.trim().equals("")) {
				throw new IllegalArgumentException("Cliente n�o encontrado");
			} else {
				throw new NoSuchElementException("Cliente n�o encontrado");
			}
		}
	}
	
	/**
	* M�todo auxiliar que adiciona as representa��es (em String) dos clientes em uma lista e os ordena alfabeticamente.
	* 
	* @param listaClientes a lista que armazenar� os clientes
	*/
	private void adicionarClientesEmLista(List<String> listaClientes) {
		for (Cliente c: clientes.values()) {
			if (c == null) {
				throw new NullPointerException("Cliente inv�lido encontrado");
			} else {
				listaClientes.add(c.toString() + " | ");
			}
		} 
		
		Collections.sort(listaClientes);
	}

	/**
	* Verifica se o cliente j� est� cadastrado a partir do cpf passado como par�metro, caso esteja, lan�a uma exce��o, caso contr�rio, 
	* cadastra o cliente. 
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/
	public void cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		if (clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Cliente j� cadastrado");
		}
		
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, cliente);
	}
	
	/**
	* Verifica se o cpf do cliente passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, retorna a representa��o em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representa��o em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibirCliente(String cpf) {
		verificaCpf(cpf);
		return clientes.get(cpf).toString();
	}
	
	/**
	* Exibe a representa��o textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representa��o em String dos clientes
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
	* Verifica se o cliente est� cadastrado a partir do seu cpf, caso n�o esteja, lan�a a exce��o mais adequada, caso esteja, edita os
	* seus dados, com exce��o do cpf, por ser �nico. 
	*
	* @param cpf o cpf do cliente
	* @param novoNome o novo nome do cliente
	* @param novoEmail o novo email do cliente
	* @param novaLocalizacao o novo local de trabalho do cliente
	*/
	public void editarCadastro(String cpf, String novoNome, String novoEmail, String novaLocaliza��o) {
		verificaCpf(cpf);
		
		Cliente cliente = clientes.get(cpf);
		cliente.setNome(novoNome);
		cliente.setEmail(novoEmail);
		cliente.setLocalizacao(novaLocaliza��o);
	}
	
	/**
	* Verifica se o cpf do cliente passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, remove o cadastro do cliente. 
	* 
	* @param cpf o cpf do cliente
	*/
	public void removerCliente(String cpf) {
		verificaCpf(cpf);
		clientes.remove(cpf);
	}
}