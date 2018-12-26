package clubluli;

import abstrato.Produto;

public class Jogo extends Produto {
	
	public Jogo(String nome, String categoria, double valor) {
		super(nome, categoria, valor);
	}

	public double calcularPreco() {
		if (this.categoria.equals("Infantil")) {
			double desconto = 0.05 * this.valor;
			return this.valor - desconto;
		} else {
			return this.valor;
		}
	}
}
