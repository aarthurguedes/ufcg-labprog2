package Comparators;

import java.util.Comparator;

import abstrato.Produto;

public class ComparadorDeProdutoPeloPreco implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		if (o1.getPreco() < o2.getPreco()) {
			return 1;
		} else if (o1.getPreco() == o2.getPreco()) {
			return 0;
		} else {
			return -1;
		}
	}
}
