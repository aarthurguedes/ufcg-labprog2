	package lab5;

import java.util.Map;

/**
* Representação de um verificador, responsável por verificar atributos/parâmetros das classes ClienteController e FornecedorController.
*
* @author Arthur Guedes
*/
public class VerificadorControllers {
	
	/**
	* Método auxiliar que verifica os parâmetros passados para o cadastramento do cliente e lança a exceção adequada quando necessário.
	* 
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	* @param clientes o mapa de clientes
	*/ 
	public void verificaParametrosAdicionaCliente(String cpf, String nome, String email, String localizacao, Map<String, Cliente> clientes) {
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
	* Método auxiliar que verifica os parâmetros passados para a edição do cliente e lança a exceção adequada quando necessário.
	* 
	* @param cpf o cpf do cliente
	* @param atributo o atributo o qual se quer editar
	* @param novoValor o novo valor para o atributo
	* @param clientes o mapa de clientes
	*/ 
	public void verificaParametrosEditaCliente(String cpf, String atributo, String novoValor, Map<String, Cliente> clientes) {
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
	* Método auxiliar que verifica os parâmetros passados para o cadastramento do fornecedor e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void verificaParametrosAdicionaFornecedor(String nome, String email, String telefone, Map<String, Fornecedor> fornecedores) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		} else if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a edição do fornecedor e lança a exceção adequada quando necessário.
	* 
	* @param atributo o atributo o qual se quer editar
	* @param novoValor o novo valor para o atributo
	*/ 
	public void verificaParametrosEditaFornecedor(String atributo, String novoValor) {
		String msgErro = "Erro na edicao do fornecedor: ";
		
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser editado.");
		} else if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "atributo nao pode ser vazio ou nulo.");
		} else if (novoValor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "novo valor nao pode ser vazio ou nulo."); 
		} else if ((!atributo.equals("email")) && (!atributo.equals("telefone"))) { 
			throw new IllegalArgumentException(msgErro + "atributo nao existe.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para o cadastramento do produto e lança a exceção adequada quando necessário.
	* 
	* @param fornecedor o nome do fornecedor
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void verificaParametrosAdicionaProduto(String fornecedor, String nome, String descricao, String preco, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro no cadastro de produto: ";
		
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		} else if (Float.parseFloat(preco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		} else if (fornecedores.get(fornecedor).getProdutos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto ja existe.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a exibição do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param fornecedor o nome do fornecedor do produto
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void verificaParametrosExibeProduto(String nome, String descricao, String fornecedor, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na exibicao de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo."); 
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a edição do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o fornecedor do produto
	* @param novoPreco o novo preço para o produto
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void verificaParametrosEditaProduto(String nome, String descricao, String fornecedor, String novoPreco, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na edicao de produto: ";
		
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");
		} else if (Float.parseFloat(novoPreco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a remoção do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o fornecedor do produto
	* @param fornecedores o mapa de fornecedores 
	*/
	public void verificaParametrosRemoveProduto(String nome, String descricao, String fornecedor, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na remocao de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe."); 
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
}
