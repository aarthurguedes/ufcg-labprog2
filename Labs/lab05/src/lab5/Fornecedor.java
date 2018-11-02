package lab5;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Representação de um fornecedor de lanches, que possui nome (identificação única), email e telefone.
*
* @author Arthur Guedes
*/
public class Fornecedor {
	
	/**
	* Nome do fornecedor.
	*/
	private String nome;
	/**
	* Email do fornecedor.
	*/
	private String email;
	/**
	* Telefone do fornecedor.
	*/
	private String telefone;
	/**
	* Mapa de produtos do fornecedor.
	*/
	private Map<String, Produto> produtos;
	/**
	* Objeto Verificador de parâmetros.
	*/
	private VerificadorBase vb = new VerificadorBase();
	/**
	* Objeto adicionador de strings em listas.
	*/
	private Adicionador a = new Adicionador();
	
	/**
	* Constrói o fornecedor a partir do seu nome, email e telefone.
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public Fornecedor(String nome, String email, String telefone) {
		vb.verificaParametrosFornecedor(nome, email, telefone);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	/**
	 * @return o nome do fornecedor
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome o novo nome do fornecedor
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o email do fornecedor
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email o novo email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return o telefone do fornecedor
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone o novo telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return os produtos do fornecedor
	 */
	public Map<String, Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos os novos produtos do fornecedor
	 */
	public void setProdutos(Map<String, Produto> produtos) {
		this.produtos = produtos;
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o produto para o fornecedor, caso contrário, lança uma 
	* exceção. 
	*
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
	*/
	public void adicionarProduto(String nome, String descricao, String preco) {
		vb.verificaParametrosAdicionarProduto(nome, descricao, preco);
		produtos.put((nome + descricao), new Produto(preco, nome, descricao));
	}
	
	/**
	* Exibe a representação textual de um determinado produto do fornecedor.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @return uma representação em String de um produto do fornecedor
	*/
	public String exibirProduto(String nome, String descricao) {
		vb.verificaParametrosExibirProduto(nome, descricao, produtos);
		return produtos.get(nome + descricao).toString(); 
	}
	
	/**
	* Exibe a representação textual de todos os produtos do fornecedor.
	*   
	* @return uma representação em String dos produtos do fornecedor
	*/
	public String exibirProdutos() {
		List<String> listaProdutosFornecedor = new ArrayList<>();
		a.adicionaProdutosFornecedorEmLista(this.nome, listaProdutosFornecedor, produtos);
		
		String retorno =  "";
		for (String s: listaProdutosFornecedor) {
			retorno += s;
		}
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita o preço do produto, caso não sejam, lança uma exceção.
	*
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param novoPreco o novo preço do produto
	*/
	public void editarProduto(String nome, String descricao, String novoPreco) {
		vb.verificaParametrosEditarProduto(nome, descricao, novoPreco, produtos);
		produtos.get(nome + descricao).setPreco(novoPreco);
		
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, remove o produto, caso contrário, lança uma exceção. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produtos
	*/
	public void removerProduto(String nome, String descricao) {
		vb.verificaParametrosRemoverProduto(nome, descricao, produtos);
		produtos.remove(nome + descricao);
	}

	/**
	* Retorna a String que representa o fornecedor no formato: nome - email - telefone.
	* 
	* @return a representação em String do fornecedor.
	*/
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	* Retorna o valor int que representa a posição do objeto na memória.
	* 
	* @return a representação numérica do objeto.  
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	* Retorna o valor boolean que representa se dois fornecedores são iguais, ou seja, se possuem
	* o mesmo nome (identificação única do fornecedor).
	* 
	* @param obj o objeto que representa o outro fornecedor
	* @return o valor boolean da igualdade (ou não) entre dois fornecedores.  
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
