package lab5;

import controllers.SAGAController;
import easyaccept.EasyAccept;

/**
* Representação da fachada do sistema, que inicializa o ClienteController e o FornecedorController.
*
* @author Arthur Guedes
*/
public class Facade {
	
	/**
	* Controlador intermediário entre os controladores de Cliente e Fornecedor.
	*/
	private SAGAController sc;
	
	/**
	* Constrói a fachada do sistema, inicializando o controlador do sistema.
	*
	*/
	public Facade() {
		sc = new SAGAController();
	}
	
	/**
	* Verifica se os parâmetros passados para o cadastramento do cliente são válidos e, caso sejam, cadastra o cliente, caso contrário, 
	* lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param nome o nome do cliente
	* @param email o email do cliente
	* @param localizacao o local de trabalho do cliente
	* @return o cpf do cliente
	*/
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return sc.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representação em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibeCliente(String cpf) {
		return sc.exibeCliente(cpf);
	}
	
	/**
	* Exibe a representação textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representação em String dos clientes cadastrados no sistema
	*/
	public String exibeClientes() {
		return sc.exibeClientes();
	}
	
	/**
	* Verifica se atributo e novoValor são válidos e se o cpf está cadastrado, em caso positivo, edita o atributo, caso contrário,
	* lança a exceção mais adequada.
	*
	* @param cpf o cpf do cliente
	* @param atributo o atributo a ser editado
	* @param novoValor o novo valor do atributo que vai ser editado
	*/
	public void editaCliente(String cpf, String atributo, String novoValor) {
		sc.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, remove o cadastro do cliente. 
	* 
	* @param cpf o cpf do cliente
	*/
	public void removeCliente(String cpf) {
		sc.removeCliente(cpf);
	}
	
	/**
	* Verifica se os parâmetros passados para o cadastramento do fornecedor são válidos e, caso sejam, cadastra o fornecedor, caso 
	* contrário, lança uma exceção. 
	*
	* @param nome o nome do fornecedor
	* @param email o email do fornecedor
	* @param telefone o telefone do fornecedor
	* @return o nome do cliente;
	*/
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return sc.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	* @return uma representação em String do fornecedor, se o mesmo estiver cadastrado.
	*/
	public String exibeFornecedor(String nome) {
		return sc.exibeFornecedor(nome);
	}
	
	/**
	* Exibe a representação textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representação em String dos fornecedores cadastrados
	*/
	public String exibeFornecedores() {
		return sc.exibeFornecedores();
	}
	
	/**
	* Verifica se os parâmetros passados do fornecedor são válidos e, caso sejam, edita os dados do fornecedor, caso não sejam, lança 
	* uma exceção.
	*
	* @param nome o nome do fornecedor
	* @param atributo o atributo o qual se deseja editar
	* @param novoValor o novo valor do atributo
	*/
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		sc.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro é válido e, caso não seja, lança uma exceção, caso seja, remove o 
	* cadastro do fornecedor.  
	* 
	* @param nome o nome do fornecedor
	*/
	public void removeFornecedor(String nome) {
		sc.removeFornecedor(nome);
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
		sc.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, exibe o produto desejado, caso contrário, lança uma exceção.
	* 
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	* @param fornecedor o fornecedor do produto
	* @return uma representação em String do produto
	*/
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return sc.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	* Exibe a representação textual de todos os produtos para um determinado fornecedor.
	*   
	* @param fornecedor o nome do fornecedor
	* @return uma representação em String dos produtos do fornecedor
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		return sc.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	* Exibe a representação textual de todos os produtos de todos os fornecedores (de maneira ordenada).
	*   
	* @return uma representação em String dos produtos dos fornecedores
	*/
	public String exibeProdutos() {
		return sc.exibeProdutos();
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
		sc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, remove o produto, caso contrário, lança uma exceção. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		sc.removeProduto(nome, descricao, fornecedor);
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
		sc.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
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
		sc.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, cadastra a compra, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	* @param data a data da compra
	* @param nomeProd o nome do produto
	* @param descProd a descrição do produto
	*/
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd) {
		sc.adicionaCompra(cpf, fornecedor, data, nomeProd, descProd);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, retorna o débito do cliente com determinado fornecedor, 
	* caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public String getDebito(String cpf, String fornecedor) {
		return sc.getDebito(cpf, fornecedor);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, retorna a representação em string das contas de um 
	* cliente com um fornecedor, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public String exibeContas(String cpf, String fornecedor) {
		return sc.exibeContas(cpf, fornecedor);
	}
	
	/**
	* Verifica se o parâmetros passado é válido e, caso seja, retorna a representação em string das contas de um 
	* cliente, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	*/
	public String exibeContasClientes(String cpf) {
		return sc.exibeContasClientes(cpf);
	}
	
	/**
	* Realiza o pagamento da conta de um cliente com um fornecedor.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public void realizaPagamento(String cpf, String fornecedor) {
		sc.realizaPagamento(cpf, fornecedor);
	}
	
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", 
				"testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt", "testes_aceitacao/use_case_5.txt", 
				"testes_aceitacao/use_case_6.txt"};
		EasyAccept.main(args);
	}
}
