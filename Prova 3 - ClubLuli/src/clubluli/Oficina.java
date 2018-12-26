package clubluli;

import abstrato.Produto;

public class Oficina extends Produto {
	
	private double cargaHoraria;
	
	public Oficina(String nome, String categoria, double valor, double cargaHoraria) {
		super(nome, categoria, valor);
		this.cargaHoraria = cargaHoraria;
	}

	public double calcularPreco() {
		return this.cargaHoraria * this.valor;
	}
}
