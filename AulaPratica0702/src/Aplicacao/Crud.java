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




	//m�todo respons�vel em guardar todas as informa��es que o usu�rio digitar quando optar em cadastrar um Produto
	public static void SalvarProduto (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {

		//Instanciando a classe "Produtos" e "Marca" 
		Produtos produto= new Produtos();
		Marca marcas= new Marca();
		
		//Recebendo todas as informa��es que obteve no m�todo"ViewMenuSalvarProduto" e mandando para uma �nica vari�vel"dadosProdutos"
		String[] dadosProdutos= ViewProduto.ViewMenuSalvarProduto(reader);



		//separando todas informa��es que foi recebido do dadosProdutos e enviando para suas devidas vari�veis
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



	//m�todo respons�vel em gerar uma lista com todas todos os objetos salvos e mostrar ao usu�rio
	public static void ListarProduto() throws UnsupportedEncodingException, FileNotFoundException, IOException, ParserConfigurationException, SAXException {

		ListaDeProdutos.getInstance().clear();
		ManipulacaoDeDadosXMl.lerArquivoXml();
		//Puxando um m�todo da classe"ViewProduto"
		ViewProduto.ViewListaEditada();

	}		

	//M�todo respons�vel em deletar um objeto salvo da lista XML ou Txt
	public static void DeletarProdutos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{
		
		int indice=ViewProduto.ViewMenuEditarOuDeletarProduto("Deletar", reader);
		ListaDeProdutos.getInstance().remove(indice);

		ManipulacaoDeDadosTXT.SalvarProdutoTXT();
		ManipulacaoDeDadosXMl.SalvarArquivoXml();
		ViewProduto.ViewMensagens(2);
	}

	//M�todo respons�vel em Editar um objeto da lista XML E Txt
	public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{
		
		//Vari�vel definida para receber duas informa��es
		String[] ProdutosEditados={"",""};



		int indice=ViewProduto.ViewMenuEditarOuDeletarProduto("editar", reader);
		Produtos prod= ListaDeProdutos.getInstance().get(indice);
		
		//recebendo o retorno do m�todo "ViewOpcaoEdicao"
		ProdutosEditados=ViewProduto.ViewOpcaoEdicao(reader);


		//La�o de repeti��o respons�vel por editar a op��o escolhida pelo usu�rio
		//Switch est� recebendo a primeira informa��o do 'ProdutosEditados"
		switch(Integer.parseInt(ProdutosEditados[0])) {
		
		//Casos com a segunda informa��o do"ProdutosEditados" e enviando para uma vari�vel espec�fica
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
		
		
		//Enviando para a lista qual dos objetos foi modificado  e qual foi a sua modifica��o
		ListaDeProdutos.getInstance().set(indice, prod);
		
		//Salvando a modifica��o feita no Arquivo XML E Txt
		ManipulacaoDeDadosXMl.SalvarArquivoXml();
		ManipulacaoDeDadosTXT.SalvarProdutoTXT();
		ViewProduto.ViewMensagens(1);

	}	
}


		
		
		
		

	




	



