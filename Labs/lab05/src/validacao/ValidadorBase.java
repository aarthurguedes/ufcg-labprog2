package validacao;

import java.util.Map;

import lab5.Combo;
import lab5.Conta;
import lab5.ProdutoSimples;

/**
* Representação de um verificador, responsável por verificar atributos/parâmetros das classes Cliente, Fornecedor e Produto.
*
* @author Arthur Guedes
*/
public class ValidadorBase {
	
	/**
	* Método auxiliar que valida o nome passado como parâmetro.
	* 
	* @param nome o nome do cliente / fornecedor
	* @param msgErro a mensagem de erro a ser exibida
	*/ 
	public void validaNome(String nome, String msgErro) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	* Método auxiliar que valida o email passado como parâmetro.
	* 
	* @param email o email do cliente / fornecedor
	* @param msgErro a mensagem de erro a ser exibida
	*/
	public void validaEmail(String email, String msgErro) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "email nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	* Método auxiliar que valida a localização passada como parâmetro.
	* 
	* @param localizacao a localização do cliente
	* @param msgErro a mensagem de erro a ser exibida
	*/
	public void validaLocalizacao(String localizacao, String msgErro) {
		if(localizacao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "localizacao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	* Método auxiliar que valida o cpf passado como parâmetro.
	* 
	* @param cpf o cpf do cliente
	* @param msgErro a mensagem de erro a ser exibida
	*/
	public void validaCpf(String cpf, String msgErro) {
		if (cpf.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "cpf nao pode ser vazio ou nulo.");
		} else if (cpf.length() > 11 || cpf.length() < 11) {
			throw new IllegalArgumentException(msgErro + "cpf invalido.");
		}
	}
	
	/**
	* Método auxiliar que valida a descrição do produto.
	* 
	* @param descricao a descrição do produto
	* @param msgErro a mensagem de erro a ser exibida
	*/
	public void validaDescricao(String descricao, String msgErro) {
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	* Método auxiliar que valida o preço do produto.
	* 
	* @param preco o preço do produto
	* @param msgErro a mensagem de erro a ser exibida
	*/
	public void validaPreco(String preco, String msgErro) {
		if (preco.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "preco nao pode ser vazio ou nulo.");
		} else if (Float.parseFloat(preco) < 0) {
			throw new IllegalArgumentException(msgErro + "preco invalido.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a construção do cliente.
	* 
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	*/ 
	public void validaCliente(String cpf, String nome, String email, String localizacao) {
		String msgErro = "Erro na construção do cliente: ";
		validaNome(nome, msgErro);
		validaEmail(email, msgErro);
		validaLocalizacao(localizacao, msgErro);
		validaCpf(cpf, msgErro);
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a construção do fornecedor.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void validaFornecedor(String nome, String email, String telefone) {
		String msgErro = "Erro na construção do fornecedor: ";
		validaNome(nome, msgErro);
		validaEmail(email, msgErro);
		
		if(telefone.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "telefone nao pode ser vazia ou nula.");
		} 
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a construção do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
	*/ 
	public void validaProduto(String nome, String descricao, String preco) {
		String msgErro = "Erro no cadastro de produto: ";
		validaNome(nome, msgErro);
		validaDescricao(descricao, msgErro);
		validaPreco(preco, msgErro);
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a exibição do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param produtosSimples o mapa de produtos
	*/
	public void validaExibicaoProduto(String nome, String descricao, Map<String, ProdutoSimples> produtosSimples, Map<String, Combo> combos) {
		String msgErro = "Erro na exibicao de produto: ";
		validaNome(nome, msgErro);
		validaDescricao(descricao, msgErro);
		
		if (!produtosSimples.containsKey(nome + descricao) && !combos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		} 
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a edição do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param novoPreco o novo preço do produto
	* @param produtos o mapa de produtos
	*/
	public void validaEdicaoProduto(String nome, String descricao, String novoPreco, Map<String, ProdutoSimples> produtos) {
		String msgErro = "Erro na edicao de produto: ";
		validaPreco(novoPreco, msgErro);
		validaDescricao(descricao, msgErro);
		validaNome(nome, msgErro);
		
		if (!produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a remoção do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param produtos o mapa de produtos
	*/
	public void validaRemocaoProduto(String nome, String descricao, Map<String, ProdutoSimples> produtos, Map<String, Combo> combos) {
		String msgErro = "Erro na remocao de produto: "; 
		validaNome(nome, msgErro);
		validaDescricao(descricao, msgErro);

		if (!produtos.containsKey(nome + descricao) && !combos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	

	/**
	* Método auxiliar que valida os fator de desconto do combo.
	* 
	* @param fator o fator de desconto do combo
	* @param msgErro a mensagem de erro a ser exibida
	*/
	public void validaFator(String fator, String msgErro) {
		if (Float.parseFloat(fator) <= 0 || Float.parseFloat(fator) >= 1) {
			throw new IllegalArgumentException(msgErro + "fator invalido.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a construção do combo.
	* 
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto do combo
	* @param produtos os produtos do combo
	*/ 
	public void validaCombo(String nome, String descricao, String fator, String produtos) {
		String msgErro = "Erro no cadastro de combo: ";
		validaNome(nome, msgErro);
		validaDescricao(descricao, msgErro);
		validaFator(fator, msgErro);
		
		if (produtos.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "combo deve ter produtos."); 
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para o cadastramento do combo.
	* 
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto do combo
	* @param produtos os produtos que farão parte do combo
	* @param combos os combos do fornecedor
	*/
	public void validaCadastramentoCombo(String nome, String descricao, String fator, String produtos, Map<String, Combo> combos) {
		String msgErro = "Erro no cadastro de combo: ";
		String keyCombo = nome + descricao;
		
		if (combos.containsKey(keyCombo)) {
			throw new IllegalArgumentException(msgErro + "combo ja existe.");
		}
		
		validaNome(nome, msgErro);
		validaDescricao(descricao, msgErro);
		validaFator(fator, msgErro);
		
		if (produtos.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "combo deve ter produtos.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a edição do combo.
	* 
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param novoFator o novo fator de desconto do combo
	* @param combos o mapa de combos do fornecedor
	*/
	public void validaEdicaoCombo(String nome, String descricao, String novoFator, Map<String, Combo> combos) {
		String msgErro = "Erro na edicao de combo: ";
		validaNome(nome, msgErro);
		validaDescricao(descricao, msgErro);
		validaFator(novoFator, msgErro);
		
		if (!combos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os produtos do combo.
	* 
	* @param produtos os produtos que farão parte do combo
	* @param keyProd1 a chave do produto 1
	* @param keyProd2 a chave do produto 2
	* @param produtosSimples o mapa de produtos
	* @param combos o mapa de combos
	*/ 
	public void validaProdutosDoCombo(String produtos, String keyProd1, String keyProd2, Map<String, ProdutoSimples> produtosSimples, Map<String, Combo> combos) {
		String keyProduto1 = keyProd1;
		String keyProduto2 = keyProd2;
		
		if (!produtosSimples.containsKey(keyProduto1) || !produtosSimples.containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		} else if (combos.containsKey(keyProduto1) || combos.containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo não pode possuir combos na lista de produtos.");
		}
	}
	
	/**
	* Método auxiliar que valida o fornecedor passado como parâmetro para a exibição da conta.
	* 
	* @param fornecedor o nome do fornecedor
	* @param contas as contas do cliente
	*/ 
	public void validaExibicaoConta(String fornecedor, Map<String, Conta> contas) {
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		} else if (!contas.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}
	
	/**
	* Método auxiliar que valida o fornecedor passado como parâmetro para a realização do pagamento do débito do cliente.
	* 
	* @param fornecedor o nome do fornecedor
	* @param contas as contas do cliente
	*/ 
	public void validaPagamento(String fornecedor, Map<String, Conta> contas) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		} else if (!contas.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
	}
}
