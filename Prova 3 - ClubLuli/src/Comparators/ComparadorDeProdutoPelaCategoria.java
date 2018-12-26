package Comparators;

import java.util.Comparator;

import abstrato.Produto;

public class ComparadorDeProdutoPelaCategoria implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		if (o1.getCategoria().equals("Infantil")) {
			return 1;
		} else if (o1.getCategoria().equals(o2.getCategoria())) {
			return 0;
		} else {
			return -1;
		}
	}
}
