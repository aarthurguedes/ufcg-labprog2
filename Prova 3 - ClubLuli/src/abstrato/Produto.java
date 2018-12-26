package abstrato;

public abstract class Produto {
	
	protected String nome;
	protected String categoria;
	protected double valor;
	protected double preco;
	
	public Produto(String nome, String categoria, double valor) {
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public abstract double calcularPreco();
	
	@Override
	public String toString() {
		return "[" + this.nome + ", " + this.categoria + ", " + this.valor + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
