package validacao;

import java.util.Map;

import lab5.Cliente;
import lab5.Fornecedor;

/**
* Representação de um verificador, responsável por verificar atributos/parâmetros das classes ClienteController e FornecedorController.
*
* @author Arthur Guedes
*/
public class ValidadorControllers {
	
	private ValidadorBase vb;
	
	public ValidadorControllers() {
		this.vb = new ValidadorBase();
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para o cadastramento do cliente.
	* 
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	* @param clientes o mapa de clientes
	*/ 
	public void validaCadastramentoCliente(String cpf, String nome, String email, String localizacao, Map<String, Cliente> clientes) {
		String msgErro = "Erro no cadastro do cliente: ";
		vb.validaNome(nome, msgErro);
		vb.validaEmail(email, msgErro);
		vb.validaLocalizacao(localizacao, msgErro);
		
		if (clientes.containsKey(cpf)) { 
			throw new IllegalArgumentException(msgErro + "cliente ja existe.");
		}
		vb.validaCpf(cpf, msgErro);
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a edição do cliente.
	* 
	* @param cpf o cpf do cliente
	* @param atributo o atributo o qual se quer editar
	* @param novoValor o novo valor para o atributo
	* @param clientes o mapa de clientes
	*/ 
	public void validaEdicaoCliente(String cpf, String atributo, String novoValor, Map<String, Cliente> clientes) {
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
	* Método auxiliar que valida os parâmetros passados para o cadastramento do fornecedor.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void validaCadastramentoFornecedor(String nome, String email, String telefone, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro no cadastro do fornecedor: ";
		vb.validaNome(nome, msgErro);
		vb.validaEmail(email, msgErro);
		
		if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a edição do fornecedor.
	* 
	* @param atributo o atributo o qual se quer editar
	* @param novoValor o novo valor para o atributo
	*/ 
	public void validaEdicaoFornecedor(String atributo, String novoValor) {
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
	* Método auxiliar que valida o nome do fornecedor passado como parâmetro.
	* 
	* @param nome o nome do fornecedor
	* @param msgErro a mensagem de erro a ser exibida
	*/
	private void validaFornecedor(String fornecedor, String msgErro) {
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para o cadastramento do produto.
	* 
	* @param fornecedor o nome do fornecedor
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void validaCadastramentoProduto(String fornecedor, String nome, String descricao, String preco, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro no cadastro de produto: ";
		validaFornecedor(fornecedor, msgErro);
		vb.validaNome(nome, msgErro);
		vb.validaDescricao(descricao, msgErro);
		
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		}
		vb.validaPreco(preco, msgErro);
		if (fornecedores.get(fornecedor).getProdutos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto ja existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a exibição do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param fornecedor o nome do fornecedor do produto
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void validaExibicaoProduto(String nome, String descricao, String fornecedor, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na exibicao de produto: ";
		vb.validaNome(nome, msgErro);
		validaFornecedor(fornecedor, msgErro); 
		
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		} 
		vb.validaDescricao(descricao, msgErro);
		if (!fornecedores.get(fornecedor).getProdutos().containsKey(nome + descricao) && 
				!fornecedores.get(fornecedor).getCombos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a edição do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o fornecedor do produto
	* @param novoPreco o novo preço para o produto
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void validaEdicaoProduto(String nome, String descricao, String fornecedor, String novoPreco, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na edicao de produto: ";
		validaFornecedor(fornecedor, msgErro);
		vb.validaPreco(novoPreco, msgErro);
		vb.validaDescricao(descricao, msgErro);
		vb.validaNome(nome, msgErro);
	
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a remoção do produto.
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o fornecedor do produto
	* @param fornecedores o mapa de fornecedores 
	*/
	public void validaRemocaoProduto(String nome, String descricao, String fornecedor, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na remocao de produto: ";
		vb.validaNome(nome, msgErro);
		vb.validaDescricao(descricao, msgErro);
		validaFornecedor(fornecedor, msgErro);
		
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe."); 
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(nome + descricao) && !fornecedores.get(fornecedor).getCombos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para o cadastramento do combo.
	* 
	* @param fornecedor o nome do fornecedor
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto do combo
	* @param produtos os produtos que farão parte do combo
	* @param fornecedores o mapa de fornecedores
	*/
	public void validaCadastramentoCombo(String fornecedor, String nome, String descricao, String fator, 
			String produtos, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro no cadastro de combo: ";
		String keyCombo = nome + descricao;
		
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");	
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		} else if (fornecedores.get(fornecedor).getCombos().containsKey(keyCombo)) {
			throw new IllegalArgumentException(msgErro + "combo ja existe.");
		}
		vb.validaCombo(nome, descricao, fator, produtos);
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a edição do combo.
	* 
	* @param nome o nome do combo
	* @param descricao a descricao do combo
	* @param fornecedor o fornecedor do combo
	* @param novoFator o novo fator de desconto do combo
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void validaEdicaoCombo(String nome, String descricao, String fornecedor, String novoFator, Map<String, Fornecedor> fornecedores) {
		String msgErro = "Erro na edicao de combo: ";
		vb.validaNome(nome, msgErro);
		vb.validaDescricao(descricao, msgErro);
		validaFornecedor(fornecedor, msgErro);
		
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		}
		vb.validaFator(novoFator, msgErro);
		if (!fornecedores.get(fornecedor).getCombos().containsKey(nome + descricao)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida se os produtos do combo.
	* 
	* @param produtos os produtos que farão parte do combo
	* @param fornecedor o nome do fornecedor
	* @param keyProd1 a chave do produto 1
	* @param keyProd2 a chave do produto 2
	* @param fornecedores o mapa de fornecedores
	*/ 
	public void validaProdutosCombo(String produtos, String fornecedor, String keyProd1, String keyProd2, Map<String, Fornecedor> fornecedores) {
		String keyProduto1 = keyProd1;
		String keyProduto2 = keyProd2;
		
		if (fornecedores.get(fornecedor).getCombos().containsKey(keyProduto1) || fornecedores.get(fornecedor).getCombos().
					containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(keyProduto1) || !fornecedores.get(fornecedor).
				getProdutos().containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		}
	}
}
