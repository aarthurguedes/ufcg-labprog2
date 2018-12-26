package controllers;

import java.util.HashMap;
import java.util.Map;

import abstrato.Produto;
import clubluli.CarrinhoDeCompras;

public class CarrinhoDeComprasController {
	
	private Map<Integer, CarrinhoDeCompras> carrinhos;
	
	public CarrinhoDeComprasController() {
		this.carrinhos = new HashMap<>();
	}
	
	public Map<Integer, CarrinhoDeCompras> getCarrinhos() {
		return this.carrinhos;
	}
	
	public void criarCarrinho(int id) {
		if (carrinhos.containsKey(id)) {
			throw new IllegalArgumentException("Carrinho ja existe.");
		}
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(id);
		carrinhos.put(id, carrinho);
	}
	
	public void adicionarProdutoAoCarrinho(int id, Produto produto) {
		if (!carrinhos.containsKey(id)) {
			throw new IllegalArgumentException("Carrinho nao existe.");
		}
		carrinhos.get(id).getProdutos().add(produto);
	}
	
	public double totalizarCarrinho(int id) {
		if (!carrinhos.containsKey(id)) {
			throw new IllegalArgumentException("Carrinho nao existe.");
		}
		
		double precoTotal = 0;
		for (Produto p: this.carrinhos.get(id).getProdutos()) {
			precoTotal += p.calcularPreco();
		}
		
		return precoTotal;
	}
}
