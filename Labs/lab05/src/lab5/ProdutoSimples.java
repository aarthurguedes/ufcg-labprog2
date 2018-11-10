package lab5;

import abstrato.ProdutoAbstrato;

/**
* Representação de um produto (de responsabilidade de um fornecedor), que possui nome e descrição (indentificações únicas), além do preço. 
*
* @author Arthur Guedes
*/
public class ProdutoSimples extends ProdutoAbstrato {
	
	/**
	* Constrói o produto a partir do seu preço, nome e descrição.
	*
	* @param preco o preço do produto
	* @param nome o nome do produto
	* @param descricao a descrição do produto
	*/
	public ProdutoSimples(String preco, String nome, String descricao) {
		vb.validaProduto(nome, descricao, preco); 
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
	}
}
