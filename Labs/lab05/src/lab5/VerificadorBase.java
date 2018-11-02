package lab5;

import java.util.Map;

/**
* Representa��o de um verificador, respons�vel por verificar atributos/par�metros das classes Cliente, Fornecedor e Produto.
*
* @author Arthur Guedes
*/
public class VerificadorBase {
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a constru��o do cliente e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/ 
	public void verificaParametrosCliente(String cpf, String nome, String email, String localizacao) {
		String msgErro = "Erro na constru��o do cliente: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "email nao pode ser vazio ou nulo.");
		} else if(localizacao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "localizacao nao pode ser vazia ou nula.");
		} else if (cpf.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "cpf nao pode ser vazio ou nulo.");
		} else if (cpf.length() > 11 || cpf.length() < 11) {
			throw new IllegalArgumentException(msgErro + "cpf invalido.");
		}
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a constru��o do fornecedor e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void verificaParametrosFornecedor(String nome, String email, String telefone) {
		String msgErro = "Erro na constru��o do fornecedor: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "email nao pode ser vazio ou nulo.");
		} else if(telefone.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "telefone nao pode ser vazia ou nula.");
		} 
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a constru��o do produto e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param preco o pre�o do produto
	*/ 
	public void verificaParametrosProduto(String nome, String descricao, String preco) {
		String msgErro = "Erro no cadastro de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (preco.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "preco nao pode ser vazio ou nulo.");
		} else if (Float.parseFloat(preco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		}
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para o cadastramento do produto e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param preco o pre�o do produto
	*/
	public void verificaParametrosAdicionarProduto(String nome, String descricao, String preco) {
		String msgErro = "Erro no cadastro de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (preco.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "preco nao pode ser vazio ou nulo.");
		} else if (Float.parseFloat(preco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		}
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a exibi��o do produto e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param produtos o mapa de produtos
	*/
	public void verificaParametrosExibirProduto(String nome, String descricao, Map<String, Produto> produtos) {
		String msgErro = "Erro na exibicao de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a edi��o do produto e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param novoPreco o novo pre�o do produto
	* @param produtos o mapa de produtos
	*/
	public void verificaParametrosEditarProduto(String nome, String descricao, String novoPreco, Map<String, Produto> produtos) {
		String msgErro = "Erro na edicao de produto: ";
		
		if (Float.parseFloat(novoPreco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (!produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* M�todo auxiliar que verifica os par�metros passados para a remo��o do produto e lan�a a exce��o adequada quando necess�rio.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param produtos o mapa de produtos
	*/
	public void verificaParametrosRemoverProduto(String nome, String descricao, Map<String, Produto> produtos) {
		String msgErro = "Erro na remocao de produto: "; 
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
}
