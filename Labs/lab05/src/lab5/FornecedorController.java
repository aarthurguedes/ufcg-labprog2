package lab5;

import java.util.ArrayList;
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
	private Map<String, Fornecedor> fornecedores;
	/**
	* Objeto Verificador de parâmetros.
	*/
	private VerificadorControllers vc = new VerificadorControllers();
	/**
	* Objeto adicionador de strings em listas.
	*/
	private Adicionador a = new Adicionador();
	
	/**
	* Constrói o controle a partir do mapa de fornecedores. 
	*
	*/
	public FornecedorController() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	 * @return o mapa de fornecedores
	 */
	public Map<String, Fornecedor> getFornecedores() {
		return fornecedores;
	}

	/**
	 * @param fornecedores o novo mapa de fornecedores
	 */
	public void setFornecedores(Map<String, Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
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
		vc.verificaParametrosAdicionaFornecedor(nome, email, telefone, fornecedores);
		fornecedores.put(nome, new Fornecedor(nome, email, telefone));
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
	* Exibe a representação textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representação em String dos fornecedores
	*/
	public String exibeFornecedores() {
		List<String> listaFornecedores = new ArrayList<>();
		a.adicionaFornecedoresEmLista(listaFornecedores, fornecedores);
		
		String retorno = "";
		for (String f: listaFornecedores) {
			retorno += f;
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita os dados do fornecedor, caso não sejam, lança uma exceção.
	*
	* @param nome o nome do fornecedor
	* @param atributo o atributo o qual se deseja editar
	* @param novoValor o novo valor do atributo
	*/
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		vc.verificaParametrosEditaFornecedor(atributo, novoValor);
		
		if (atributo.equals("email")) {
			fornecedores.get(nome).setEmail(novoValor);
		} else {
			fornecedores.get(nome).setTelefone(novoValor);
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
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o produto para o fornecedor, caso contrário, lança uma 
	* exceção. 
	*
	* @param fornecedor o nome do fornecedor
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param preco o preço do produto
	*/
	public void adicionaProduto(String fornecedor, String nome, String descricao, String preco) {
		vc.verificaParametrosAdicionaProduto(fornecedor, nome, descricao, preco, fornecedores);
		fornecedores.get(fornecedor).adicionarProduto(nome, descricao, preco);
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
		vc.verificaParametrosExibeProduto(nome, descricao, fornecedor, fornecedores);
		return fornecedores.get(fornecedor).exibirProduto(nome, descricao);
	}
	
	/**
	* Exibe a representação textual de todos os produtos dado um fornecedor.
	*   
	* @param fornecedor o nome do fornecedor
	* @return uma representação em String dos produtos do fornecedor
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo."); 
		}
		return fornecedores.get(fornecedor).exibirProdutos();
	}

	/**
	* Exibe a representação textual de todos os produtos de todos os fornecedores.
	*   
	* @return uma representação em String dos produtos dos fornecedores
	*/
	public String exibeProdutos() {
		List<String> listaProdutos = new ArrayList<>();
		a.adicionaProdutosEmLista(listaProdutos, fornecedores);
		a.adicionaCombosEmLista(listaProdutos, fornecedores);
		
		String retorno = "";
		for (String p: listaProdutos) {
			retorno += p + " | "; 
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita o preço do produto, caso não sejam, lança uma exceção.
	*
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param fornecedor o nome do fornecedor
	* @param novoPreco o novo preço do produto
	*/
	public void editaProduto(String nome, String descricao, String fornecedor, String novoPreco) {
		vc.verificaParametrosEditaProduto(nome, descricao, fornecedor, novoPreco, fornecedores);
		fornecedores.get(fornecedor).editarProduto(nome, descricao, novoPreco);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, remove o produto, caso contrário, lança uma exceção. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		vc.verificaParametrosRemoveProduto(nome, descricao, fornecedor, fornecedores);
		fornecedores.get(fornecedor).removerProduto(nome, descricao);
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
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra o combo para o fornecedor, caso contrário, lança uma 
	* exceção. 
	*
	* @param fornecedor o nome do fornecedor
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fator o fator de desconto
	* @param produtos os produtos que vão compor o combo
	*/
	public void adicionaCombo(String fornecedor, String nome, String descricao, String fator, String produtos) {
		vc.verificaParametrosAdicionaCombo(fornecedor, nome, descricao, fator, produtos, fornecedores);
		String keyProduto1 = pegaKeyProduto(1, produtos);
		String keyProduto2 = pegaKeyProduto(2, produtos);
		
		if (fornecedores.get(fornecedor).getCombos().containsKey(keyProduto1) || fornecedores.get(fornecedor).getCombos().
					containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo n�o pode possuir combos na lista de produtos.");
		} else if (!fornecedores.get(fornecedor).getProdutos().containsKey(keyProduto1) || !fornecedores.get(fornecedor).
				getProdutos().containsKey(keyProduto2)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		}
		fornecedores.get(fornecedor).adicionarCombo(nome, descricao, fator, produtos); 
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, edita o fator de desconto do combo, caso não sejam, 
	* lança uma exceção.
	*
	* @param nome o nome do combo
	* @param descricao a descrição do combo
	* @param fornecedor o nome do fornecedor
	* @param novoFator o novo fator de desconto do combo
	*/
	public void editaCombo(String nome, String descricao, String fornecedor, String novoFator) {
		vc.verificaParametrosEditaCombo(nome, descricao, fornecedor, novoFator, fornecedores);
		fornecedores.get(fornecedor).editarCombo(nome, descricao, novoFator);
	}
}