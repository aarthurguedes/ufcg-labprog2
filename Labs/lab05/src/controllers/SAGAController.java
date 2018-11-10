package controllers;

import lab5.Compra;
import lab5.Conta;
import validacao.ValidadorServicos;

/**
* Representação de um controlador intermediário, que associa os controladores de Cliente e Fornecedor.
*
* @author Arthur Guedes
*/
public class SAGAController {

	/**
	* Controlador dos clientes.
	*/
	private ClienteController cc;
	/**
	* Controlador dos fornecedores.
	*/
	private FornecedorController fc;
	/**
	* Verificador de parâmetros.
	*/
	private ValidadorServicos vs;
	
	/**
	* Constrói o controlador a partir dos controladores associados.
	*
	*/
	public SAGAController() {
		this.cc = new ClienteController();
		this.fc = new FornecedorController();
		this.vs = new ValidadorServicos();
	}
	
	/**
	* @return o controlador de clientes
	*/
	public ClienteController getCc() {
		return cc;
	}

	/**
	* @param cc o novo controlador de clientes
	*/
	public void setCc(ClienteController cc) {
		this.cc = cc;
	}

	/**
	* @return o controlador de fornecedores
	*/
	public FornecedorController getFc() {
		return fc;
	}

	/**
	* @param fc o novo controlador de fornecedores
	*/
	public void setFc(FornecedorController fc) {
		this.fc = fc;
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
		return cc.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do cliente. 
	* 
	* @param cpf o cpf do cliente
	* @return uma representação em String do cliente, se o mesmo estiver cadastrado.
	*/
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}
	
	/**
	* Exibe a representação textual de todos os clientes cadastrados no sistema.
	*   
	* @return uma representação em String dos clientes cadastrados no sistema
	*/
	public String exibeClientes() {
		return cc.exibeClientes();
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
		cc.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	* Verifica se o cpf do cliente passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, remove o cadastro do cliente. 
	* 
	* @param cpf o cpf do cliente
	*/
	public void removeCliente(String cpf) {
		cc.removeCliente(cpf);
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
		return fc.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro está cadastrado e, caso não esteja, lança a exceção mais adequada, 
	* caso esteja, retorna a representação em String do fornecedor. 
	* 
	* @param nome o nome do fornecedor
	* @return uma representação em String do fornecedor, se o mesmo estiver cadastrado.
	*/
	public String exibeFornecedor(String nome) {
		return fc.exibeFornecedor(nome);
	}
	
	/**
	* Exibe a representação textual de todos os fornecedores cadastrados no sistema.
	*   
	* @return uma representação em String dos fornecedores cadastrados
	*/
	public String exibeFornecedores() {
		return fc.exibeFornecedores();
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
		fc.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	* Verifica se o nome do fornecedor passado como parâmetro é válido e, caso não seja, lança uma exceção, caso seja, remove o 
	* cadastro do fornecedor.  
	* 
	* @param nome o nome do fornecedor
	*/
	public void removeFornecedor(String nome) {
		fc.removeFornecedor(nome);
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
		fc.adicionaProduto(fornecedor, nome, descricao, preco);
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
		return fc.exibeProduto(nome, descricao, fornecedor);
	}
	
	/**
	* Exibe a representação textual de todos os produtos para um determinado fornecedor.
	*   
	* @param fornecedor o nome do fornecedor
	* @return uma representação em String dos produtos do fornecedor
	*/
	public String exibeProdutosFornecedor(String fornecedor) {
		return fc.exibeProdutosFornecedor(fornecedor);
	}
	
	/**
	* Exibe a representação textual de todos os produtos de todos os fornecedores (de maneira ordenada).
	*   
	* @return uma representação em String dos produtos dos fornecedores
	*/
	public String exibeProdutos() {
		return fc.exibeProdutos();
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
		fc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, remove o produto, caso contrário, lança uma exceção. 
	* 
	* @param nome o nome do produto
	* @param descricao a descricao do produto
	* @param fornecedor o nome do fornecedor
	*/
	public void removeProduto(String nome, String descricao, String fornecedor) {
		fc.removeProduto(nome, descricao, fornecedor);
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
		fc.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
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
		fc.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	/**
	* Método auxiliar que pega o preço do produto a partir do fornecedor, do nome e da descrição do produto.
	* 
	* @param fornecedor o nome do fornecedor
	* @param nomeProd o nome do produto
	* @param descProd a descrição do produto
	*/ 
	private String pegaPrecoProduto(String fornecedor, String nomeProd, String descProd) {
		String keyProd = nomeProd + descProd;
		if (fc.getFornecedores().get(fornecedor).getProdutos().containsKey(keyProd)) {
			return fc.getFornecedores().get(fornecedor).getProdutos().get(keyProd).getPreco();
		} else {
			return fc.getFornecedores().get(fornecedor).getCombos().get(keyProd).getPreco();
		}
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
		vs.validaCompra(cpf, fornecedor, data, nomeProd, descProd, cc, fc);
		
		String idProd = nomeProd +  " - " + descProd;
		String precoProd = pegaPrecoProduto(fornecedor, nomeProd, descProd);
		
		if (!cc.getClientes().get(cpf).getContas().containsKey(fornecedor)) {
			cc.getClientes().get(cpf).getContas().put(fornecedor, new Conta());
		}
		
		Compra c = new Compra(data, idProd, precoProd);
		cc.getClientes().get(cpf).getContas().get(fornecedor).getCompras().add(c);
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, retorna o débito do cliente com determinado fornecedor, 
	* caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public String getDebito(String cpf, String fornecedor) {
		vs.validaDebito(cpf, fornecedor, cc, fc);
		return cc.getClientes().get(cpf).getContas().get(fornecedor).getDebito();
	}
	
	/**
	* Verifica se os parâmetros passados são válidos e, caso sejam, retorna a representação em string das contas de um 
	* cliente com um fornecedor, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public String exibeContas(String cpf, String fornecedor) {
		vs.validaContasClienteFornecedor(cpf, fornecedor, cc, fc);
		return cc.getClientes().get(cpf).exibirConta(fornecedor);
	}
	
	/**
	* Verifica se o parâmetros passado é válido e, caso seja, retorna a representação em string das contas de um 
	* cliente, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	*/
	public String exibeContasClientes(String cpf) {
		vs.validaContasCliente(cpf, cc);
		return cc.getClientes().get(cpf).exibirContas();
	}
	
	/**
	* Realiza o pagamento da conta de um cliente com um fornecedor.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public void realizaPagamento(String cpf, String fornecedor) {
		vs.validaPagamento(cpf, fornecedor, cc, fc);
		cc.getClientes().get(cpf).realizarPagamento(fornecedor);
	}
}