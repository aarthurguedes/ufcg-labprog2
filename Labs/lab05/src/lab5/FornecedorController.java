package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Representação de um controlador para os fornecedores, responsável por cadastrá-los, representá-los textualmente, editar os seus 
* cadastros e removê-los.
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
	* Método auxiliar que verifica os parâmetros passados para a construção do fornecedor e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/ 
	private void verificaAtributosFornecedor(String nome, String email, String telefone) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		} else if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o fornecedor, caso contrário, lança uma exceção. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	* @return o nome do cliente;
	*/
	public String adicionaFornecedor(String nome, String email, String telefone) {
		verificaAtributosFornecedor(nome, email, telefone);
		
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, fornecedor);
		return nome;
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	* @return uma representação em String do fornecedor, se o mesmo estiver cadastrado.
	*/
	public String exibeFornecedor(String nome) {
		if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return fornecedores.get(nome).toString();
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos fornecedores em uma lista e os ordena alfabeticamente.
	* 
	* @param listaFornecedores a lista que armazenará os fornecedores
	*/
	private void adicionaFornecedoresEmLista(List<String> listaFornecedores) {
		for (Fornecedor f: fornecedores.values()) {
			if (f != null) {
				listaFornecedores.add(f.toString() + " | ");
			}
		} 
		Collections.sort(listaFornecedores);
	}
	
	/**
	* Exibe a representação textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representação em String dos fornecedores
	*/
	public String exibeFornecedores() {
		List<String> listaFornecedores = new ArrayList<>();
		adicionaFornecedoresEmLista(listaFornecedores);
		
		String retorno = "";
		for (String f: listaFornecedores) {
			retorno += f;
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a edição do fornecedor e lança a exceção adequada quando necessário.
	* 
	* @param atributo o atributo o qual se quer editar
	* @param novoValor o novo valor para o atributo
	*/ 
	private void verificaDadosFornecedorParaEdicao(String atributo, String novoValor) {
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
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita os dados do fornecedor, caso não sejam, lança uma exceção.
	*
	* @param nome o nome do fornecedor
	* @param atributo o atributo o qual se deseja editar
	* @param novoValor o novo valor do atributo
	*/
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		verificaDadosFornecedorParaEdicao(atributo, novoValor);
		
		Fornecedor fornecedor = fornecedores.get(nome);
		if (atributo.equals("email")) {
			fornecedor.setEmail(novoValor);
		} else {
			fornecedor.setTelefone(novoValor);
		}
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro é válido e, caso não seja, lança uma exceção, caso seja, remove o cadastro
	* do fornecedor.  
	* 
	* @param nome o nome do fornecedor
	*/
	public void removeFornecedor(String nome) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		} else if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a construção do produto e lança a exceção adequada quando necessário.
	* 
	* @param fornecedor o nome do fornecedor
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
	*/ 
	private void verificaAtributosProduto(String fornecedor, String nome, String descricao, String preco) {
		String msgErro = "Erro no cadastro de produto: ";
		String keyProduto = nome + descricao;
		
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
		} else if (fornecedores.get(fornecedor).getProdutos().containsKey(keyProduto)) {
			throw new IllegalArgumentException(msgErro + "produto ja existe.");
		}
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o produto para o fornecedor, caso contrário, lança uma 
	* exceção. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void adicionaProduto(String fornecedor, String nome, String descricao, String preco) {
		verificaAtributosProduto(fornecedor, nome, descricao, preco);
		
		Produto produto = new Produto(preco, nome, descricao);
		String keyProduto = nome + descricao;
		fornecedores.get(fornecedor).getProdutos().put(keyProduto, produto); 
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a construção do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param fornecedor o nome do fornecedor do produto
	*/ 
	private void verificaAtributosProduto(String nome, String descricao, String fornecedor) {
		String msgErro = "Erro na exibicao de produto: ";
		String keyProduto = nome + descricao;
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo."); 
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(keyProduto)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso seja, exibe o produto desejado, caso contrário, lança uma exceção.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param fornecedor o fornecedor do produto
	* @return uma representação em String do produto
	*/
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		verificaAtributosProduto(nome, descricao, fornecedor);
		String keyProduto = nome + descricao;
		return fornecedores.get(fornecedor).getProdutos().get(keyProduto).toString();
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos produtos de um dado fornecedor em uma lista e os ordena 
	* alfabeticamente.
	* 
	* @param nomeFornecedor o nome do fornecedor
	* @param listaProdutosFornecedor a lista que armazenará os produtos
	*/
	private void adicionaProdutosFornecedorEmLista(String nomeFornecedor, List<String> listaProdutosFornecedor) {
		for (Produto p: fornecedores.get(nomeFornecedor).getProdutos().values()) {
			if (p != null) {
				listaProdutosFornecedor.add(p.toString());
			}
		}
		Collections.sort(listaProdutosFornecedor);
	}
	
	/**
	* Exibe a representação textual de todos os produtos dado um fornecedor.
	*   
	* @param fornecedor o nome do fornecedor
	* @return uma representação em String dos produtos do fornecedor
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		List<String> listaProdutosFornecedor = new ArrayList<>();
		adicionaProdutosFornecedorEmLista(fornecedor, listaProdutosFornecedor);
		
		String retorno = "";
		for (String p: listaProdutosFornecedor) {
			retorno += fornecedor + " - " + p + " | ";
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos produtos de todos os fornecedores em uma lista e os ordena 
	* alfabeticamente pelos nomes dos fornecedores.
	* 
	* @param listaProdutos a lista que armazenará os produtos
	*/
	private void adicionaProdutosEmLista(List<String> listaProdutos) {
		for (Fornecedor f: fornecedores.values()) {
			if (f != null) {
				for (Produto p: fornecedores.get(f.getNome()).getProdutos().values()) {
					if (p != null) {
						listaProdutos.add(f.getNome() + " - " + p.toString());
					} 
				}
			}
		}
		Collections.sort(listaProdutos);
	}
	
	/**
	* Exibe a representação textual de todos os produtos de todos os fornecedores.
	*   
	* @return uma representação em String dos produtos dos fornecedores
	*/
	public String exibeProdutos() {
		List<String> listaProdutos = new ArrayList<>();
		adicionaProdutosEmLista(listaProdutos);
		
		String retorno = "";
		for (String p: listaProdutos) {
			retorno += p + " | "; 
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a edição do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o fornecedor do produto
	* @param novoPreco o novo preço para o produto
	*/ 
	private void verificaDadosProdutoParaEdicao(String nome, String descricao, String fornecedor, String novoPreco) {
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
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita o preço do produto, caso não sejam, lança uma exceção.
	*
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param novoPreco o novo preço do produto
	*/
	public void editaProduto(String nome, String descricao, String fornecedor, String novoPreco) {
		verificaDadosProdutoParaEdicao(nome, descricao, fornecedor, novoPreco);
		String keyProduto = nome + descricao;
		
		Produto produto = fornecedores.get(fornecedor).getProdutos().get(keyProduto);
		produto.setPreco(novoPreco);
	}
	
	/**
	* Método auxiliar que verifica os parâmetros passados para a remoção do produto e lança a exceção adequada quando necessário.
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o fornecedor do produto
	*/
	private void verificaDadosProdutoParaRemocao(String nome, String descricao, String fornecedor) {
		String msgErro = "Erro na remocao de produto: ";
		String keyProduto = nome + descricao;
		
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao nao pode ser vazia ou nula.");
		} else if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");
		} else if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe."); 
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(keyProduto)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		}
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, remove o produto, caso contrário, lança uma exceção. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		verificaDadosProdutoParaRemocao(nome, descricao, fornecedor);
		String keyProduto = nome + descricao;
		fornecedores.get(fornecedor).getProdutos().remove(keyProduto);
	}
}