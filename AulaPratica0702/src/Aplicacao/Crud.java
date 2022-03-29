package Aplicacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import BancoDeDados.ManipulacaoDeDadosTXT;
import BancoDeDados.ManipulacaoDeDadosXMl;
import MarcaProd.Marca;
import MarcaProd.Produtos;
import Util.ListaDeProdutos;
import View.ViewProduto;




public class Crud {




	//método responsável em guardar todas as informações que o usuário digitar quando optar em cadastrar um Produto
	public static void SalvarProduto (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {

		//Instanciando a classe "Produtos" e "Marca" 
		Produtos produto= new Produtos();
		Marca marcas= new Marca();
		
		//Recebendo todas as informações que obteve no método"ViewMenuSalvarProduto" e mandando para uma única variável"dadosProdutos"
		String[] dadosProdutos= ViewProduto.ViewMenuSalvarProduto(reader);



		//separando todas informações que foi recebido do dadosProdutos e enviando para suas devidas variáveis
		produto.setNome(dadosProdutos[0]);
		produto.setCategoria(dadosProdutos[1]);
		marcas.setNomeMarca(dadosProdutos[2]);
		marcas.setPreco(Double.parseDouble(dadosProdutos[3]));
		produto.setMarca(marcas);

		ListaDeProdutos.getInstance().add(produto);
		//Salvando o objeto e seus atributos em uma Lista TXT e XML
		ManipulacaoDeDadosTXT.SalvarProdutoTXT();
		ManipulacaoDeDadosXMl.SalvarArquivoXml();
		ViewProduto.ViewMensagens(0);
	}



	//método responsável em gerar uma lista com todas todos os objetos salvos e mostrar ao usuário
	public static void ListarProduto() throws UnsupportedEncodingException, FileNotFoundException, IOException, ParserConfigurationException, SAXException {

		ListaDeProdutos.getInstance().clear();
		ManipulacaoDeDadosXMl.lerArquivoXml();
		//Puxando um método da classe"ViewProduto"
		ViewProduto.ViewListaEditada();

	}		

	//Método responsável em deletar um objeto salvo da lista XML ou Txt
	public static void DeletarProdutos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{
		
		int indice=ViewProduto.ViewMenuEditarOuDeletarProduto("Deletar", reader);
		ListaDeProdutos.getInstance().remove(indice);

		ManipulacaoDeDadosTXT.SalvarProdutoTXT();
		ManipulacaoDeDadosXMl.SalvarArquivoXml();
		ViewProduto.ViewMensagens(2);
	}

	//Método responsável em Editar um objeto da lista XML E Txt
	public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{
		
		//Variável definida para receber duas informações
		String[] ProdutosEditados={"",""};



		int indice=ViewProduto.ViewMenuEditarOuDeletarProduto("editar", reader);
		Produtos prod= ListaDeProdutos.getInstance().get(indice);
		
		//recebendo o retorno do método "ViewOpcaoEdicao"
		ProdutosEditados=ViewProduto.ViewOpcaoEdicao(reader);


		//Laço de repetição responsável por editar a opção escolhida pelo usuário
		//Switch está recebendo a primeira informação do 'ProdutosEditados"
		switch(Integer.parseInt(ProdutosEditados[0])) {
		
		//Casos com a segunda informação do"ProdutosEditados" e enviando para uma variável específica
		case 1:
			prod.setNome(ProdutosEditados[1]);
			break;

		case 2:
			prod.setCategoria(ProdutosEditados[1]);
			break;

		case 3:
			prod.getMarca().setNomeMarca(ProdutosEditados[1]);
			break;
		case 4:
			prod.getMarca().setPreco(Double.parseDouble(ProdutosEditados[1]));
			break;

		}
		
		
		//Enviando para a lista qual dos objetos foi modificado  e qual foi a sua modificação
		ListaDeProdutos.getInstance().set(indice, prod);
		
		//Salvando a modificação feita no Arquivo XML E Txt
		ManipulacaoDeDadosXMl.SalvarArquivoXml();
		ManipulacaoDeDadosTXT.SalvarProdutoTXT();
		ViewProduto.ViewMensagens(1);

	}	
}


		
		
		
		

	




	



