package lab5;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	* M�todo auxiliar que verifica os par�metros passados para a constru��o do cliente e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/ 
	private void verificaAtributosCliente(String cpf, String nome, String email, String localizacao) {
		String msgErro = "Erro no cadastro do cliente: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "email nao pode ser vazio ou nulo.");
		} else if(localizacao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "localizacao nao pode ser vazia ou nula.");
		} else if (clientes.containsKey(cpf)) { 
			throw new IllegalArgumentException(msgErro + "cliente ja existe.");
		} else if (cpf.length() > 11 || cpf.length() < 11) {
			throw new IllegalArgumentException(msgErro + "cpf invalido.");
		}
	}
	
	/**
	* Verifica se os par�metros passados s�o v�lidos e, caso sejam, cadastra o cliente, caso contr�rio, lan�a uma exce��o.
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	* @return o cpf do cliente
	*/
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		verificaAtributosCliente(cpf, nome, email, localizacao);
		
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, cliente);
		return cpf;
	}
	
	/**
	* Verifica se o cpf do cliente passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, retorna a representa��o em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representa��o em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibeCliente(String cpf) {
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientes.get(cpf).toString();
	}
	
	/**
	* M�todo auxiliar que adiciona as representa��es (em String) dos clientes em uma lista e os ordena alfabeticamente.
	* 
	* @param listaClientes a lista que armazenar� os clientes
	*/
	private void adicionaClientesEmLista(List<String> listaClientes) {
		for (Cliente c: clientes.values()) {
			if (c != null) {
				listaClientes.add(c.toString() + " | ");
			}
		} 
		Collections.sort(listaClientes);
	}
	
	/**
	* Exibe a representa��o textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representa��o em String dos clientes
	*/
	public String exibeClientes() {
		List<String> listaClientes = new ArrayList<>();
		adicionaClientesEmLista(listaClientes);
		
		String retorno = "";
		for (String c: listaClientes) {
			retorno += c;
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a edi��o do cliente e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param atributo o atributo o qual se quer editar
	* @param novoValor o novo valor para o atributo
	*/ 
	private void verificaDadosParaEdicao(String cpf, String atributo, String novoValor) {
		String msg = "Erro na edicao do cliente:";
		
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(msg + " atributo nao pode ser vazio ou nulo.");
		} else if (novoValor.trim().equals("")) {
			throw new IllegalArgumentException(msg + " novo valor nao pode ser vazio ou nulo.");
		} else if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException(msg + " cliente nao existe."); 
		} else if ((!atributo.equals("nome")) && (!atributo.equals("email")) && (!atributo.equals("localizacao"))) {
			throw new IllegalArgumentException(msg + " atributo nao existe.");
		}
	}
	
	/**
	* Verifica se o atributo e novoValor s�o v�lidos e se o cpf est� cadastrado, em caso positivo, edita o atributo, caso contr�rio,
	* lan�a a exce��o mais adequada.
	*
	* @param cpf o cpf do cliente
	* @param atributo o atributo a ser editado
	* @param novoValor o novo valor do atributo que vai ser editado
	*/
	public void editaCliente(String cpf, String atributo, String novoValor) {
		verificaDadosParaEdicao(cpf, atributo, novoValor);
		
		Cliente cliente = clientes.get(cpf);
		if (atributo.equals("nome")) {
			cliente.setNome(novoValor);
		} else if (atributo.equals("email")){
			cliente.setEmail(novoValor);
		} else {
			cliente.setLocalizacao(novoValor);
		}
	}
	
	/**
	* Verifica se o cpf do cliente passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
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