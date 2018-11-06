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
	private Map<String, ProdutoSimples> produtosSimples;
	/**
	* Mapa de combos do fornecedor.
	*/
	private Map<String, Combo> combos;
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
		this.produtosSimples = new HashMap<>();
		this.combos = new HashMap<>();
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
	public Map<String, ProdutoSimples> getProdutos() {
		return produtosSimples;
	}

	/**
	 * @param produtos os novos produtos do fornecedor
	 */
	public void setProdutos(Map<String, ProdutoSimples> produtos) {
		this.produtosSimples = produtos;
	}
	
	/**
	 * @return os combos do fornecedor
	 */
	public Map<String, Combo> getCombos() {
		return combos;
	}

	/**
	 * @param combos os novos combos do fornecedor
	 */
	public void setCombos(Map<String, Combo> combos) {
		this.combos = combos;
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
		produtosSimples.put((nome + descricao), new ProdutoSimples(preco, nome, descricao));
	}
	
	/**
	* Exibe a representação textual de um determinado produto do fornecedor.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @return uma representação em String de um produto do fornecedor
	*/
	public String exibirProduto(String nome, String descricao) {
		vb.verificaParametrosExibirProduto(nome, descricao, produtosSimples, combos); 
		if (produtosSimples.containsKey(nome + descricao)) {
			return produtosSimples.get(nome + descricao).toString();
		} else {
			return combos.get(nome + descricao).toString();
		}
		 
	}
	
	/**
	* Exibe a representação textual de todos os produtos do fornecedor.
	*   
	* @return uma representação em String dos produtos do fornecedor
	*/
	public String exibirProdutos() {
		List<String> listaProdutosFornecedor = new ArrayList<>();
		a.adicionaProdutosFornecedorEmLista(this.nome, listaProdutosFornecedor, produtosSimples, combos);
		
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
		vb.verificaParametrosEditarProduto(nome, descricao, novoPreco, produtosSimples);
		produtosSimples.get(nome + descricao).setPreco(novoPreco);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, remove o produto, caso contrário, lança uma exceção. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	*/
	public void removerProduto(String nome, String descricao) {
		vb.verificaParametrosRemoverProduto(nome, descricao, produtosSimples, combos);
		if (produtosSimples.containsKey(nome + descricao)) {
			produtosSimples.remove(nome + descricao);
		} else {
			combos.remove(nome + descricao); 
		}
	}
	
	/**
	* Método auxiliar que forma as chaves dos produtos passados como parâmetros.
	* 
	* @param numProduto o numero do produto que se quer a chave
	* @param produtos a String que representa os produtos
	* @return a String que representa a key do produto
	*/ 
	private String pegaKeyProduto(int numProduto, String produtos) {
		String produto[] = produtos.split(", ");
		
		if (numProduto == 1) {
			String p[] = produto[0].split(" - ");
			String key = p[0] + p[1];
			return key;
		} else {
			String p[] = produto[1].split(" - ");
			String key = p[0] + p[1];
			return key;
		}
	}
	
	/**
	* Método auxiliar que calcula o preço do combo.
	* 
	* @param fator o fator de desconto
	* @param produtos a String que representa os produtos
	* @param produtosSimples o mapa de produtos que formam o combo
	* @return a String que representa o preço do combo
	*/ 
	private String calculaPrecoCombo(String fator, String produtos, Map<String, ProdutoSimples> produtosSimples) {
		Float precoProduto1 = Float.parseFloat(produtosSimples.get(pegaKeyProduto(1, produtos)).getPreco());
		Float precoProduto2 = Float.parseFloat(produtosSimples.get(pegaKeyProduto(2, produtos)).getPreco());
		Float desconto = (precoProduto1 + precoProduto2) * Float.parseFloat(fator);
		Float precoFinal = (precoProduto1 + precoProduto2) - desconto;
		return Float.toString(precoFinal);
	}
	
	/**
	* Método auxiliar que verifica se os produtos do combo são válidos.
	* 
	* @param produtos os produtos que farão parte do combo
	*/ 
	private void verificaProdutosCombo(String produtos) {
		String keyProduto1 = pegaKeyProduto(1, produtos);
		String keyProduto2 = pegaKeyProduto(2, produtos);
		
		if (!produtosSimples.containsKey(keyProduto1) || !produtosSimples.containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		} else if (combos.containsKey(keyProduto1) || combos.containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo não pode possuir combos na lista de produtos.");
		}
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o combo para o fornecedor, caso contrário, lança uma 
	* exceção. 
	*
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto
	* @param produtos os produtos que vão compor o combo
	*/
	public void adicionarCombo(String nome, String descricao, String fator, String produtos) {
		vb.verificaParametrosAdicionarCombo(nome, descricao, fator, produtos, combos);
		verificaProdutosCombo(produtos);
		String keyCombo = nome + descricao;
		String keyProduto1 = pegaKeyProduto(1, produtos);
		String keyProduto2 = pegaKeyProduto(2, produtos);
		combos.put((keyCombo), new Combo(nome, descricao, fator, produtos));
		combos.get(keyCombo).setPreco(calculaPrecoCombo(fator, produtos, produtosSimples));
		combos.get(keyCombo).getProdutosSimples().put(keyProduto1, produtosSimples.get(keyProduto1));
		combos.get(keyCombo).getProdutosSimples().put(keyProduto2, produtosSimples.get(keyProduto2));
	}
	
	/**
	* Método auxiliar que calcula o novopreço do combo.
	* 
	* @param nome o nome do combo
	* @param descricao a descricao do combo
	* @param novoFator o novo fator de desconto
	* @return a String que representa o preço do combo
	*/ 
	private String calculaNovoPrecoCombo(String nome, String descricao, String novoFator) {
		double fatorAntigo = Double.parseDouble(combos.get(nome + descricao).getFator());
		double precoAntigo = Double.parseDouble(combos.get(nome + descricao).getPreco());
		double porcentagemDescontoAntigo = 100 - (100 - (100 * fatorAntigo));
		double valorDescontoAntigo = (precoAntigo * porcentagemDescontoAntigo) / (100 - porcentagemDescontoAntigo);
		double precoAntigoTotal = precoAntigo + valorDescontoAntigo;
		double valorDescontoNovo = precoAntigoTotal * Double.parseDouble(novoFator);
		double novoPreco = precoAntigoTotal - valorDescontoNovo;
		return Double.toString(novoPreco);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita o preço do combo, caso não sejam, lança uma exceção.
	*
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param novoFator o novo fator de desconto do combo
	*/
	public void editarCombo(String nome, String descricao, String novoFator) {
		vb.verificaParametrosEditarCombo(nome, descricao, novoFator, combos);
		combos.get(nome + descricao).setPreco(calculaNovoPrecoCombo(nome, descricao, novoFator));
		combos.get(nome + descricao).setFator(novoFator);
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
