package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Comparators.ComparadorDeProdutoPelaCategoria;
import Comparators.ComparadorDeProdutoPeloNome;
import Comparators.ComparadorDeProdutoPeloPreco;
import abstrato.Produto;
import clubluli.Jogo;
import clubluli.Livro;
import clubluli.Oficina;

public class ProdutoController {
	
	private Map<String, Produto> produtos;
	private String tipoOrdenacao;
	
	public ProdutoController() {
		this.produtos = new HashMap<>();
		this.tipoOrdenacao = "NOME";
	}
	
	public String getTipoOrdenacao() {
		return this.tipoOrdenacao;
	}
	
	public Map<String, Produto> getProdutos() {
		return this.produtos;
	}
	
	public void cadastrarOficina(String nome,String categoria, double valor, double cargaHoraria) {
		if (produtos.containsKey(nome)) {
			throw new IllegalArgumentException("Oficina ja existe.");
		}
		Produto oficina = new Oficina(nome, categoria, valor, cargaHoraria);
		produtos.put(nome, oficina);
	}
	
	public void cadastrarLivro(String nome,String categoria, double valor,String estado) {
		if (produtos.containsKey(nome)) {
			throw new IllegalArgumentException("Livro ja existe.");
		}
		Produto livro = new Livro(nome, categoria, valor, estado);
		produtos.put(nome, livro);
	}
	
	public void cadastrarJogo(String nome,String categoria, double valor) {
		if (produtos.containsKey(nome)) {
			throw new IllegalArgumentException("Jogo ja existe.");
		}
		Produto jogo = new Jogo(nome, categoria, valor);
		produtos.put(nome, jogo);
	}
	
	public String exibirProduto(String nome) {
		if (!produtos.containsKey(nome)) {
			throw new IllegalArgumentException("Produto nao existe.");
		}
		return produtos.get(nome).toString();
	}
	
	public double obterPreco(String nome) {
		if (!produtos.containsKey(nome)) {
			throw new IllegalArgumentException("Produto nao existe.");
		}
		return produtos.get(nome).calcularPreco();
	}
	
	public void configurarOrdenacao(String ord) {
		this.tipoOrdenacao = ord;
	}
	
	private void adicionaProdutosEmLista(List<Produto> listaProdutos) {
		for (Produto p: produtos.values()) {
			listaProdutos.add(p);
		}
	}
	
	private void ordenaProdutos(List<Produto> listaProdutos) {
		if (this.tipoOrdenacao.equals("NOME")) {
			Collections.sort(listaProdutos, new ComparadorDeProdutoPeloNome());
		} else if (this.tipoOrdenacao.equals("PRECO")) {
			Collections.sort(listaProdutos, new ComparadorDeProdutoPeloPreco());
		} else if (this.tipoOrdenacao.equals("CATEGORIA")){
			Collections.sort(listaProdutos, new ComparadorDeProdutoPelaCategoria());
		}
	}
	
	public String listar() {
		List<Produto> listaProdutos = new ArrayList<>();
		adicionaProdutosEmLista(listaProdutos);
		ordenaProdutos(listaProdutos);
		
		String saida = "[";
		for (Produto p: listaProdutos) {
			saida += p.toString()  + ", ";
		}
		
		saida = saida.substring(0, saida.length() - 3);
		saida += "]";
		return saida;
	}
}
