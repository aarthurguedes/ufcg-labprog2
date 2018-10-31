package lab5;

import easyaccept.EasyAccept;

public class Facade {
	
	private ClienteController cc;
	private FornecedorController fc;
	
	public Facade() {
		inicializa();
	}
	
	public void inicializa() {
		cc = new ClienteController();
		fc = new FornecedorController();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return cc.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fc.adicionaFornecedor(nome, email, telefone);
	}
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, String preco) {
		fc.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}
	
	public String exibeFornecedor(String nome) {
		return fc.exibeFornecedor(nome);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return fc.exibeProduto(nome, descricao, fornecedor);
	}
	
	public String exibeClientes() {
		return cc.exibeClientes();
	}
	
	public String exibeFornecedores() {
		return fc.exibeFornecedores();
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return fc.exibeProdutosFornecedor(fornecedor);
	}
	
	public String exibeProdutos() {
		return fc.exibeProdutos();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fc.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void editaProduto(String nome, String descricao, String fornecedor, String novoPreco) {
		fc.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public void removeCliente(String cpf) {
		cc.removerCliente(cpf);
	}
	
	public void removeFornecedor(String nome) {
		fc.removeFornecedor(nome);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
		fc.removeProduto(nome, descricao, fornecedor);
	}
	
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", 
				"testes_aceitacao/use_case_3.txt"};
		EasyAccept.main(args);
	}
}
