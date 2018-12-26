package clubluli;

import java.util.ArrayList;
import java.util.List;

import abstrato.Produto;

public class CarrinhoDeCompras {
	
	private int id;
	private List<Produto> produtos;
	
	public CarrinhoDeCompras(int id) {
		this.id = id;
		this.produtos = new ArrayList<>();
	}
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}
}
