package lab5;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Adicionador {
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos clientes em uma lista e os ordena alfabeticamente.
	* 
	* @param listaClientes a lista que armazenará os clientes
	* @param clientes o mapa de clientes
	*/
	public void adicionaClientesEmLista(List<String> listaClientes, Map<String, Cliente> clientes) {
		for (Cliente c: clientes.values()) {
			if (c != null) {
				listaClientes.add(c.toString() + " | ");
			}
		} 
		Collections.sort(listaClientes);
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos fornecedores em uma lista e os ordena alfabeticamente.
	* 
	* @param listaFornecedores a lista que armazenará os fornecedores
	* @param fornecedores o mapa de fornecedores
	*/
	public void adicionaFornecedoresEmLista(List<String> listaFornecedores, Map<String, Fornecedor> fornecedores) {
		for (Fornecedor f: fornecedores.values()) {
			if (f != null) {
				listaFornecedores.add(f.toString() + " | ");
			}
		} 
		Collections.sort(listaFornecedores);
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos produtos de um dado fornecedor em uma lista e os ordena 
	* alfabeticamente.
	* 
	* @param fornecedor o nome do fornecedor
	* @param listaProdutosFornecedor a lista que armazenará os produtos
	* @param produtos o mapa de produtos
	*/
	public void adicionaProdutosFornecedorEmLista(String fornecedor, List<String> listaProdutosFornecedor, Map<String, Produto> produtos) {
		for (Produto p: produtos.values()) {
			if (p != null) {
				listaProdutosFornecedor.add(fornecedor + " - " + p.toString() + " | ");
			}
		}
		Collections.sort(listaProdutosFornecedor);
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos produtos de todos os fornecedores em uma lista e os ordena 
	* alfabeticamente pelos nomes dos fornecedores.
	* 
	* @param listaProdutos a lista que armazenará os produtos
	* @param fornecedores o mapa de fornecedores
	*/
	public void adicionaProdutosEmLista(List<String> listaProdutos, Map<String, Fornecedor> fornecedores) {
		for (Fornecedor f: fornecedores.values()) {
			if (f != null) {
				for (Produto p: fornecedores.get(f.getNome()).getProdutos().values()) {
					if (p != null) {
						listaProdutos.add(f.getNome() + " - " + p.toString());
					} 
				}
			}
		}
		Collections.sort(listaProdutos);
	}
}
