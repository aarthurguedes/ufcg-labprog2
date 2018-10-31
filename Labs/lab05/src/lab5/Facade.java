package lab5;

import easyaccept.EasyAccept;

/**
* Representa��o da fachada do sistema, que inicializa o ClienteController e o FornecedorController.
*
* @author Arthur Guedes
*/
public class Facade {
	
	/**
	* Controlador da classe Cliente.
	*/
	private ClienteController cc;
	/**
	* Controlador da classe Fornecedor.
	*/
	private FornecedorController fc;
	
	/**
	* Constr�i a fachada do sistema, inicializando os controladores.
	*
	*/
	public Facade() {
		cc = new ClienteController();
		fc = new FornecedorController();
	}
	
	/**
	* Verifica se os par�metros passados para o cadastramento do cliente s�o v�lidos e, caso sejam, cadastra o cliente, caso contr�rio, 
	* lan�a uma exce��o.
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	* @return o cpf do cliente
	*/
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return cc.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	* Verifica se o cpf do cliente passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, retorna a representa��o em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representa��o em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}
	
	/**
	* Exibe a representa��o textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representa��o em String dos clientes cadastrados no sistema
	*/
	public String exibeClientes() {
		return cc.exibeClientes();
	}
	
	/**
	* Verifica se atributo e novoValor s�o v�lidos e se o cpf est� cadastrado, em caso positivo, edita o atributo, caso contr�rio,
	* lan�a a exce��o mais adequada.
	*
	* @param cpf o cpf do cliente
	* @param atributo o atributo a ser editado
	* @param novoValor o novo valor do atributo que vai ser editado
	*/
	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	* Verifica se o cpf do cliente passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, remove o cadastro do cliente. 
	* 
	* @param cpf o cpf do cliente
	*/
	public void removeCliente(String cpf) {
		cc.removeCliente(cpf);
	}
	
	/**
	* Verifica se os par�metros passados para o cadastramento do fornecedor s�o v�lidos e, caso sejam, cadastra o fornecedor, caso 
	* contr�rio, lan�a uma exce��o. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	* @return o nome do cliente;
	*/
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fc.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como par�metro est� cadastrado e, caso n�o esteja, lan�a a exce��o mais adequada, 
	* caso esteja, retorna a representa��o em String do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	* @return uma representa��o em String do fornecedor, se o mesmo estiver cadastrado.
	*/
	public String exibeFornecedor(String nome) {
		return fc.exibeFornecedor(nome);
	}
	
	/**
	* Exibe a representa��o textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representa��o em String dos fornecedores cadastrados
	*/
	public String exibeFornecedores() {
		return fc.exibeFornecedores();
	}
	
	/**
	* Verifica se os par�metros passados do fornecedor s�o v�lidos e, caso sejam, edita os dados do fornecedor, caso n�o sejam, lan�a 
	* uma exce��o.
	*
	* @param nome o nome do fornecedor
	* @param atributo o atributo o qual se deseja editar
	* @param novoValor o novo valor do atributo
	*/
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fc.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como par�metro � v�lido e, caso n�o seja, lan�a uma exce��o, caso seja, remove o 
	* cadastro do fornecedor.  
	* 
	* @param nome o nome do fornecedor
	*/
	public void removeFornecedor(String nome) {
		fc.removeFornecedor(nome);
	}
	
	/**
	* Verifica se os par�metros passados s�o v�lidos e, caso sejam, cadastra o produto para o fornecedor, caso contr�rio, lan�a uma 
	* exce��o. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	*/
	public void adicionaProduto(String fornecedor, String nome, String descricao, String preco) {
		fc.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	* Verifica se os par�metros passados s�o v�lidos e, caso sejam, exibe o produto desejado, caso contr�rio, lan�a uma exce��o.
	* 
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param fornecedor o fornecedor do produto
	* @return uma representa��o em String do produto
	*/
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return fc.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	* Exibe a representa��o textual de todos os produtos para um determinado fornecedor.
	*   
	* @param fornecedor o nome do fornecedor
	* @return uma representa��o em String dos produtos do fornecedor
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		return fc.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	* Exibe a representa��o textual de todos os produtos de todos os fornecedores (de maneira ordenada).
	*   
	* @return uma representa��o em String dos produtos dos fornecedores
	*/
	public String exibeProdutos() {
		return fc.exibeProdutos();
	}
	
	/**
	* Verifica se os par�metros passados s�o v�lidos e, caso sejam, edita o pre�o do produto, caso n�o sejam, lan�a uma exce��o.
	*
	* @param nome o nome do produto
	* @param descricao a descri��o do produto
	* @param novoPreco o novo pre�o do produto
	*/
	public void editaProduto(String nome, String descricao, String fornecedor, String novoPreco) {
		fc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	* Verifica se os par�metros passados s�o v�lidos e, caso sejam, remove o produto, caso contr�rio, lan�a uma exce��o. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		fc.removeProduto(nome, descricao, fornecedor);
	}
	
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", 
				"testes_aceitacao/use_case_3.txt"};
		EasyAccept.main(args);
	}
}
