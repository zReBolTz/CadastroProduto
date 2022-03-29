package MarcaProd;
import MarcaProd.Produtos;
public class Marca {
	//Criando as variáveis privadas
	private  String nomeMarca;
	private double preco;
	
	
	//Quebrando as informações
	public Marca(String[] dados) {
		String[] mar = dados[3].split("=");
		this.nomeMarca = mar[1].trim();
		this.preco = Double.parseDouble(dados[4].trim());

		
		
		
	}
	
	public Marca() {
		
	}
	
	//Fazendo o processo de receber e enviar as informações para as variáveis
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return nomeMarca+ ", Preço= " + preco;
	}
	
	
	
	
	
		
	}
	

