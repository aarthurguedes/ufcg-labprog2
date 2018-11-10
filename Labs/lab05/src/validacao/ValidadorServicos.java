package validacao;

import controllers.ClienteController;
import controllers.FornecedorController;

/**
* Representação de um verificador dos parâmetros dos métodos de serviços entre clientes e fornecedores. 
*
* @author Arthur Guedes
*/
public class ValidadorServicos {
	
	/**
	* Método auxiliar que valida o cpf passado como parâmetro.
	* 
	* @param cpf o cpf do cliente
	* @param cc o controlador de cliente
	* @param msgErro a mensagem de erro a ser exibida
	*/ 
	private void validaCpf(String cpf, ClienteController cc, String msgErro) {
		if (cpf ==  null || cpf.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "cpf nao pode ser vazio ou nulo.");
		} else if (cpf.length() != 11) {
			throw new IllegalArgumentException(msgErro + "cpf invalido.");
		} else if (!cc.getClientes().containsKey(cpf)) {
			throw new IllegalArgumentException(msgErro + "cliente nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida o nome fornecedor passado como parâmetro.
	* 
	* @param fornecedor o nome do fornecedor
	* @param fc o controlador de fornecedores
	* @param msgErro a mensagem de erro a ser exibida
	*/ 
	private void validaFornecedor(String fornecedor, FornecedorController fc, String msgErro) {
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao pode ser vazio ou nulo.");
		} else if (!fc.getFornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "fornecedor nao existe.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para o cadastramento da compra.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	* @param data a data da compra
	* @param nomeProd o nome do produto
	* @param descProd a descrição do produto
	* @param cc o controlador de cliente
	* @param fc o controlador de fornecedor
	*/ 
	public void validaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd, 
			ClienteController cc, FornecedorController fc) {
		String msgErro = "Erro ao cadastrar compra: ";
		String keyProd = nomeProd + descProd;
		
		validaCpf(cpf,cc, msgErro);
		validaFornecedor(fornecedor, fc, msgErro);
		
		if (data.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "data nao pode ser vazia ou nula.");
		} else if (Integer.parseInt(data.split("/")[1]) > 12 ) {
			throw new IllegalArgumentException(msgErro + "data invalida.");
		} else if (nomeProd.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "nome do produto nao pode ser vazio ou nulo.");
		} else if (descProd.trim().equals("")) {
			throw new IllegalArgumentException(msgErro + "descricao do produto nao pode ser vazia ou nula.");
		} else if (!fc.getFornecedores().get(fornecedor).getProdutos().containsKey(keyProd) && 
				!fc.getFornecedores().get(fornecedor).getCombos().containsKey(keyProd)) {
			throw new IllegalArgumentException(msgErro + "produto nao existe.");
		} 
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a recuperação do valor do débito do cliente.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	* @param cc o controlador de cliente
	* @param fc o controlador de fornecedor
	*/ 
	public void validaDebito(String cpf, String fornecedor, ClienteController cc, FornecedorController fc) {
		String msgErro = "Erro ao recuperar debito: ";
		
		validaCpf(cpf,cc, msgErro);
		validaFornecedor(fornecedor, fc, msgErro);
		
		if (!cc.getClientes().get(cpf).getContas().containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "cliente nao tem debito com fornecedor.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a exibição das contas de determinado cliente com determinado 
	* fornecedor.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	* @param cc o controlador de cliente
	* @param fc o controlador de fornecedor
	*/ 
	public void validaContasClienteFornecedor(String cpf, String fornecedor, ClienteController cc, FornecedorController fc) {
		String msgErro = "Erro ao exibir conta do cliente: ";
		
		validaCpf(cpf,cc, msgErro);
		validaFornecedor(fornecedor, fc, msgErro);
		
		if (!cc.getClientes().get(cpf).getContas().containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "cliente nao tem nenhuma conta com o fornecedor.");
		}
	}
	
	/**
	* Método auxiliar que valida o parâmetro passado para a exibição das contas de determinado cliente.
	* 
	* @param cpf o cpf do cliente
	* @param cc o controlador de cliente
	*/ 
	public void validaContasCliente(String cpf, ClienteController cc) {
		String msgErro = "Erro ao exibir contas do cliente: ";
				
		validaCpf(cpf,cc, msgErro);
		
		if (cc.getClientes().get(cpf).getContas().size() == 0) {
			throw new IllegalArgumentException(msgErro + "cliente nao tem nenhuma conta.");
		}
	}
	
	/**
	* Método auxiliar que valida os parâmetros passados para a realização do pagamento do débito do cliente.
	* 
	* @param cpf o cpf do cliente
	* @param fornecedor o nome do fornecedor
	* @param cc o controlador de cliente
	* @param fc o controlador de fornecedor
	*/ 
	public void validaPagamento(String cpf, String fornecedor, ClienteController cc, FornecedorController fc) {
		String msgErro = "Erro no pagamento de conta: "; 	
		
		validaCpf(cpf,cc, msgErro);
		validaFornecedor(fornecedor, fc, msgErro);
		
		if (!cc.getClientes().get(cpf).getContas().containsKey(fornecedor)) {
			throw new IllegalArgumentException(msgErro + "nao ha debito do cliente associado a este fornecedor.");
		}
	}
}