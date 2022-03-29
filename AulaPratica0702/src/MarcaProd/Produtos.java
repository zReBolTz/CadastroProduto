package MarcaProd;

public class Produtos {
	//Criando as variáveis privadas
	private String nome;
	private Marca marca;
	private String categoria;

	//Quebrando as informações do usuário
	public Produtos(String dados) {
		String[] atributos = dados.split(",");

		String[] categoria = atributos[2].split("=");
		String[] nome = atributos[1].split("=");

		Marca marcas = new Marca(atributos);

		this.categoria = categoria[1].trim();
		this.nome = nome[1].trim();
		this.marca = marcas;


	}


	public Produtos() {

	}


	//Fazendo o processo de receber e enviar as informações para as variáveis
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}





	@Override
	public String toString() {
		return "Produto X, Nome = " + nome + ", Categoria = " + categoria + ", Marca = " + marca;
	}




}
