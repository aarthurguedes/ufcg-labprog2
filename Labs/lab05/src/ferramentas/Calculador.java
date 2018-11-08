package ferramentas;

import java.util.List; 
import java.util.Map;

import lab5.Combo;
import lab5.Compra;
import lab5.ProdutoSimples;

/**
* Representação de um calculador de preços dos combos.
*
* @author Arthur Guedes
*/
public class Calculador {
	
	/**
	* Método auxiliar que calcula o preço do combo.
	* 
	* @param fator o fator de desconto
	* @param produtos a String que representa os produtos
	* @param produtosSimples o mapa de produtos que formam o combo
	* @return a String que representa o preço do combo
	*/ 
	public String calculaPrecoCombo(String fator, String produtos, Map<String, ProdutoSimples> produtosSimples, String keyProduto1, String keyProduto2) {
		Float precoProduto1 = Float.parseFloat(produtosSimples.get(keyProduto1).getPreco());
		Float precoProduto2 = Float.parseFloat(produtosSimples.get(keyProduto2).getPreco());
		Float desconto = (precoProduto1 + precoProduto2) * Float.parseFloat(fator);
		Float precoFinal = (precoProduto1 + precoProduto2) - desconto;
		return Float.toString(precoFinal);
	}
	
	/**
	* Método auxiliar que calcula o novopreço do combo.
	* 
	* @param nome o nome do combo
	* @param descricao a descricao do combo
	* @param novoFator o novo fator de desconto
	* @param combos o mapa de combos
	* @return a String que representa o preço do combo
	*/ 
	public String calculaNovoPrecoCombo(String nome, String descricao, String novoFator, Map<String, Combo> combos) {
		double fatorAntigo = Double.parseDouble(combos.get(nome + descricao).getFator());
		double precoAntigo = Double.parseDouble(combos.get(nome + descricao).getPreco());
		double porcentagemDescontoAntigo = 100 - (100 - (100 * fatorAntigo));
		double valorDescontoAntigo = (precoAntigo * porcentagemDescontoAntigo) / (100 - porcentagemDescontoAntigo);
		double precoAntigoTotal = precoAntigo + valorDescontoAntigo;
		double valorDescontoNovo = precoAntigoTotal * Double.parseDouble(novoFator);
		double novoPreco = precoAntigoTotal - valorDescontoNovo;
		return Double.toString(novoPreco);
	}
	
	/**
	* Método auxiliar que calcula o débito do cliente.
	* 
	* @return o debito do cliente
	*/
	public String calculaDebito(List<Compra> compras) {
		float debitoTotal = 0f;
		for (Compra c: compras) {
			debitoTotal += Float.parseFloat(c.getPreco());
		}
		String debito = String.format("%.2f", debitoTotal).replace(",", ".");
		return debito;
	}
}
