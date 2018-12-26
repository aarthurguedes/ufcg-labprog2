package clubluli;

import abstrato.Produto;

public class Livro extends Produto {
	
	private String estado;
	
	public Livro(String nome, String categoria, double valor, String estado) {
		super(nome, categoria, valor);
		this.estado = estado;
	}

	public double calcularPreco() {
		if (this.estado.equals("Usado")) {
			double desconto = 0.5 * this.valor;
			return this.valor - desconto;
		} else {
			return this.valor;
		}
	}
}
