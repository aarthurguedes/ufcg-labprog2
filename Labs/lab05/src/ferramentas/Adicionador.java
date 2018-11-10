package ferramentas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lab5.Cliente;
import lab5.Combo;
import lab5.Conta;
import lab5.Fornecedor;
import lab5.ProdutoSimples;

/**
* Representação de um objeto responsável por adicionar Strings em listas.
*
* @author Arthur Guedes
*/
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
	* Método auxiliar que adiciona as representações (em String) dos produtos (e combos) de um dado fornecedor em uma lista e os ordena 
	* alfabeticamente.
	* 
	* @param fornecedor o nome do fornecedor
	* @param listaProdutosFornecedor a lista que armazenará os produtos
	* @param produtos o mapa de produtos
	* @param combos o mapa de combos
	*/
	public void adicionaProdutosFornecedorEmLista(String fornecedor, List<String> listaProdutosFornecedor, Map<String, ProdutoSimples> produtos, Map<String, Combo> combos) {
		List<String> combosRestantes = new ArrayList<>();
		
		for (ProdutoSimples p: produtos.values()) {
			if (p != null) {
				listaProdutosFornecedor.add(fornecedor + " - " + p.toString() + " | ");
			}
		}
		
		for (Combo c: combos.values()) {
			if (c != null) {
				if (c.toString().contains("+")) {
					combosRestantes.add(fornecedor + " - " + c.toString() + " | ");
				} else {
					listaProdutosFornecedor.add(fornecedor + " - " + c.toString() + " | ");
				}
			}
		}
		
		Collections.sort(listaProdutosFornecedor);
		Collections.sort(combosRestantes);
		
		for (String s: combosRestantes) {
			listaProdutosFornecedor.add(s);
		}
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
				for (ProdutoSimples p: fornecedores.get(f.getNome()).getProdutos().values()) {
					if (p != null) {
						listaProdutos.add(f.getNome() + " - " + p.toString());
					} 
				}
			}
		}
		Collections.sort(listaProdutos);
	}
	
	/**
	* Método auxiliar que adiciona as representações (em String) dos combos de todos os fornecedores em uma lista e os ordena 
	* alfabeticamente pelos nomes dos fornecedores.
	* 
	* @param listaProdutos a lista que armazenará os combos
	* @param fornecedores o mapa de fornecedores
	*/
	public void adicionaCombosEmLista(List<String> listaProdutos, Map<String, Fornecedor> fornecedores) {
		List<String> combosRestantes = new ArrayList<>();
		
		for (Fornecedor f: fornecedores.values()) {
			if (f != null) {
				for (Combo c: fornecedores.get(f.getNome()).getCombos().values()) {
					if (c != null) {
						if (c.toString().contains("+")) {
							combosRestantes.add(f.getNome() + " - " + c.toString());
						} else {
							listaProdutos.add(f.getNome() + " - " + c.toString());
						}
						
					}
				}
			}
		}
		
		Collections.sort(listaProdutos);
		Collections.sort(combosRestantes);
		
		for (String s: combosRestantes) {
			listaProdutos.add(s);
		}
	}
	
	/**
	* Método auxiliar que adiciona as keys das contas em uma lista e as ordena.
	* 
	* @param keys a lista que armazenará as keys
	*/ 
	public void adicionaKeysContasEmLista(List<String> keys, Map<String, Conta> contas) {
		for (String s: contas.keySet()) {
			keys.add(s);
		}
		Collections.sort(keys);
	}	
}
