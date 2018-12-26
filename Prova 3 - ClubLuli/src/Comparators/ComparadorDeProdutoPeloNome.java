package Comparators;

import java.util.Comparator;

import abstrato.Produto;

public class ComparadorDeProdutoPeloNome implements Comparator <Produto>{

	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
