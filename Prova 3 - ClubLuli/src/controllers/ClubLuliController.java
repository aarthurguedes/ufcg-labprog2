package controllers;

import abstrato.Produto;

public class ClubLuliController {
	
	private ProdutoController produtoController;
	private CarrinhoDeComprasController carrinhoController;
	
	public ClubLuliController() {
		this.produtoController = new ProdutoController();
		this.carrinhoController = new CarrinhoDeComprasController();
	}
	
	public void adicionaOficina(String nome,String categoria, double valor, double cargaHoraria) {
		this.produtoController.cadastrarOficina(nome, categoria, valor, cargaHoraria);
	}
	
	public void adicionaLivro(String nome,String categoria, double valor, String estado) {
		this.produtoController.cadastrarLivro(nome, categoria, valor, estado);
	}
	
	public void adicionaJogo(String nome,String categoria, double valor) {
		this.produtoController.cadastrarJogo(nome, categoria, valor);
	}
	
	public String exibirProduto(String nome) {
		return this.produtoController.exibirProduto(nome);
	}
	
	public double obterPreco(String nome) {
		return this.produtoController.obterPreco(nome);
	}
	
	public void criaCarrinho(int id) {
		this.carrinhoController.criarCarrinho(id);
	}
	
	public void adicionaProdutoAoCarrinho(int id, String nomeProduto) {
		if (!this.produtoController.getProdutos().containsKey(nomeProduto)) {
			throw new IllegalArgumentException("Produto nao existe.");
		}
		Produto produto = this.produtoController.getProdutos().get(nomeProduto);
		this.carrinhoController.adicionarProdutoAoCarrinho(id, produto);
	}
	
	public double totalizaCarrinho(int id) {
		return this.carrinhoController.totalizarCarrinho(id);
	}
	
	public void configuraOrdenacao(String ord) {
		this.produtoController.configurarOrdenacao(ord);
	}
	
	public String listar() {
		return this.produtoController.listar();
	}
}
