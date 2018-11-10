package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ferramentas.Adicionador;
import lab5.Cliente;
import validacao.ValidadorControllers;

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
	* Objeto Verificador de parãmetros.
	*/
	private ValidadorControllers vc;
	/**
	* Objeto adicionador de strings em listas.
	*/
	private Adicionador a;
	
	/**
	* Constrói o controle a partir do mapa de clientes. 
	*
	*/
	public ClienteController() {
		this.clientes = new HashMap<>();
		this.vc = new ValidadorControllers();
		this.a = new Adicionador();
	}
	
	/**
	 * @return os clientes
	 */
	public Map<String, Cliente> getClientes() {
		return clientes;
	}
	
	/**
	 * @param clientes o novo mapa de clientes
	 */
	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o cliente, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	* @return o cpf do cliente
	*/
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		vc.validaCadastramentoCliente(cpf, nome, email, localizacao, clientes);
		clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representação em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibeCliente(String cpf) {
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientes.get(cpf).toString(); 
	}
	
	/**
	* Exibe a representação textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representação em String dos clientes
	*/
	public String exibeClientes() {
		List<String> listaClientes = new ArrayList<>();
		a.adicionaClientesEmLista(listaClientes, clientes);
		
		String retorno = "";
		for (String c: listaClientes) {
			retorno += c;
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Verifica se o atributo e novoValor são válidos e se o cpf está cadastrado, em caso positivo, edita o atributo, caso contrário,
	* lança a exceção mais adequada.
	*
	* @param cpf o cpf do cliente
	* @param atributo o atributo a ser editado
	* @param novoValor o novo valor do atributo que vai ser editado
	*/
	public void editaCliente(String cpf, String atributo, String novoValor) {
		vc.validaEdicaoCliente(cpf, atributo, novoValor, clientes); 
		
		if (atributo.equals("nome")) {
			clientes.get(cpf).setNome(novoValor);
		} else if (atributo.equals("email")){
			clientes.get(cpf).setEmail(novoValor);
		} else {
			clientes.get(cpf).setLocalizacao(novoValor);
		}
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, remove o cadastro do cliente. 
	* 
	* @param cpf o cpf do cliente
	*/
	public void removeCliente(String cpf) {
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
	}
}