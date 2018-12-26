package controllers;

public class Facade {
	
	private ClubLuliController clubController;
	
	public Facade() {
		this.clubController = new ClubLuliController();
	}
	
	public void adicionaOficina(String nome,String categoria, double valor, double cargaHoraria) {
		this.clubController.adicionaOficina(nome, categoria, valor, cargaHoraria);
	}
	
	public void adicionaLivro(String nome,String categoria, double valor, String estado) {
		this.clubController.adicionaLivro(nome, categoria, valor, estado);
	}
	
	public void adicionaJogo(String nome,String categoria, double valor) {
		this.clubController.adicionaJogo(nome, categoria, valor);
	}
	
	public String exibirProduto(String nome) {
		return this.clubController.exibirProduto(nome);
	}
	
	public double obterPreco(String nome) {
		return this.clubController.obterPreco(nome);
	}
	
	public void criaCarrinho(int id) {
		this.clubController.criaCarrinho(id);
	}
	
	public void adicionaProdutoAoCarrinho(int id, String nomeProduto) {
		this.clubController.adicionaProdutoAoCarrinho(id, nomeProduto);
	}
	
	public double totalizaCarrinho(int id) {
		return this.clubController.totalizaCarrinho(id);
	}
	
	public void configuraOrdenacao(String ord) {
		this.clubController.configuraOrdenacao(ord);
	}
	
	public String listar() {
		return this.clubController.listar();
	}
}
