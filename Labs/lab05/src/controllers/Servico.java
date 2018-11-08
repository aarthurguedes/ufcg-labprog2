package controllers;

import lab5.Compra;
import lab5.Conta;
import validacao.VerificadorServico;

/**
* Representação de um serviço, que associa um cliente a um fornecedor.
*
* @author Arthur Guedes
*/
public class Servico {

	/**
	* Controlador dos clientes.
	*/
	private ClienteController cc;
	/**
	* Controlador dos fornecedores.
	*/
	private FornecedorController fc;
	/**
	* Verificador de parâmetros
	*/
	private VerificadorServico vs = new VerificadorServico();
	
	/**
	* Constrói o serviço a partir dos controladores associados.
	*
	* @param cc o controlador dos clientes
	* @param fc o controlador dos fornecedores
	*/
	public Servico(ClienteController cc, FornecedorController fc) {
		this.cc = cc;
		this.fc = fc;
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
		vs.verificaAdicionaCompra(cpf, fornecedor, data, nomeProd, descProd, cc, fc);
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
		vs.verificaGetDebito(cpf, fornecedor, cc, fc);
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
		vs.verificaExibeContas(cpf, fornecedor, cc, fc);
		return cc.getClientes().get(cpf).exibirConta(fornecedor);
	}
	
	/**
	* Verifica se o parâmetros passado é válido e, caso seja, retorna a representação em string das contas de um 
	* cliente, caso contrário, lança uma exceção.
	*
	* @param cpf o cpf do cliente
	*/
	public String exibeContasClientes(String cpf) {
		vs.verificaExibeContasCliente(cpf, cc);
		return cc.getClientes().get(cpf).exibirContas();
	}
	
	/**
	* Realiza o pagamento da conta de um cliente com um fornecedor.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	*/
	public void realizaPagamento(String cpf, String fornecedor) {
		vs.verificaRealizaPagamento(cpf, fornecedor, cc, fc);
		cc.getClientes().get(cpf).realizarPagamento(fornecedor);
	}
}