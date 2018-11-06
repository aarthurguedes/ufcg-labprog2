package lab5;

import java.util.Map;

/**
* Representação de um verificador, responsável por verificar atributos/parâmetros das classes Cliente, Fornecedor e Produto.
*
* @author Arthur Guedes
*/
public class VerificadorBase {
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a construção do cliente e lança a exceção adequada quando necessário.
	* 
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/ 
	public void verificaParametrosCliente(String cpf, String nome, String email, String localizacao) {
		String msgErro = "Erro na construção do cliente: ";
		
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
	* Método auxiliar que verifica os parâmetros passados para a construção do fornecedor e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void verificaParametrosFornecedor(String nome, String email, String telefone) {
		String msgErro = "Erro na construção do fornecedor: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "email nao pode ser vazio ou nulo.");
		} else if(telefone.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "telefone nao pode ser vazia ou nula.");
		} 
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a construção do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
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
	* Método auxiliar que verifica os parâmetros passados para o cadastramento do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
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
	* Método auxiliar que verifica os parâmetros passados para a exibição do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param produtos o mapa de produtos
	*/
	public void verificaParametrosExibirProduto(String nome, String descricao, Map<String, ProdutoSimples> produtosSimples, Map<String, Combo> combos) {
		String msgErro = "Erro na exibicao de produto: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!produtosSimples.containsKey(nome + descricao) && !combos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		} 
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a edição do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param novoPreco o novo preço do produto
	* @param produtos o mapa de produtos
	*/
	public void verificaParametrosEditarProduto(String nome, String descricao, String novoPreco, Map<String, ProdutoSimples> produtos) {
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
	* Método auxiliar que verifica os parâmetros passados para a remoção do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param produtos o mapa de produtos
	*/
	public void verificaParametrosRemoverProduto(String nome, String descricao, Map<String, ProdutoSimples> produtos, Map<String, Combo> combos) {
		String msgErro = "Erro na remocao de produto: "; 
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!produtos.containsKey(nome + descricao) && !combos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a construção do combo e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto do combo
	* @param produtos os produtos do combo
	*/ 
	public void verificaParametrosCombo(String nome, String descricao, String fator, String produtos) {
		String msgErro = "Erro no cadastro de combo: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (Float.parseFloat(fator) < 0 || Float.parseFloat(fator) >= 1) {
			throw new IllegalArgumentException(msgErro + "fator invalido.");
		} else if (produtos.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "combo deve ter produtos."); 
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para o cadastramento do combo e lança a exceção adequada 
	* quando necessário.
	* 
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto do combo
	* @param produtos os produtos que farão parte do combo
	* @param combos os combos do fornecedor
	*/
	public void verificaParametrosAdicionarCombo(String nome, String descricao, String fator, String produtos, Map<String, Combo> combos) {
		String msgErro = "Erro no cadastro de combo: ";
		String keyCombo = nome + descricao;
		
		if (combos.containsKey(keyCombo)) {
			throw new IllegalArgumentException(msgErro + "combo ja existe.");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (Float.parseFloat(fator) < 0 || Float.parseFloat(fator) >= 1) {
			throw new IllegalArgumentException(msgErro + "fator invalido.");
		} else if (produtos.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "combo deve ter produtos.");
		}
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a edição do combo e lança a exceção adequada 
	* quando necessário.
	* 
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param novoFator o novo fator de desconto do combo
	* @param combos o mapa de combos do fornecedor
	*/
	public void verificaParametrosEditarCombo(String nome, String descricao, String novoFator, Map<String, Combo> combos) {
		String msgErro = "Erro na edicao de combo: ";
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (Float.parseFloat(novoFator) <= 0 || Float.parseFloat(novoFator) >= 1) {
			throw new IllegalArgumentException(msgErro + "fator invalido.");
		} else if (!combos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
}
