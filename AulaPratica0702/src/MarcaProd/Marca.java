package MarcaProd;
import MarcaProd.Produtos;
public class Marca {
	//Criando as vari�veis privadas
	private  String nomeMarca;
	private double preco;
	
	
	//Quebrando as informa��es
	public Marca(String[] dados) {
		String[] mar = dados[3].split("=");
		this.nomeMarca = mar[1].trim();
		this.preco = Double.parseDouble(dados[4].trim());

		
		
		
	}
	
	public Marca() {
		
	}
	
	//Fazendo o processo de receber e enviar as informa��es para as vari�veis
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
		return nomeMarca+ ", Pre�o= " + preco;
	}
	
	
	
	
	
		
	}
	

