package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import MarcaProd.Marca;
import MarcaProd.Produtos;
import Util.ListaDeProdutos;


public class XMLHandlerProduto extends DefaultHandler {
	//Vari�vel que consegue juntar as informa��es que o usu�rio digitar 
	private StringBuilder texto;

	Produtos produtos;
	Marca marca;

	//Quando for inicio de documento, mostrar mensagem
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Inicio do Documento");
	}

	//Quando for fim de documento, mostrar mensagem
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Fim do Documento");
	}

	//Para iniciar um elemento, primeiro temos que fazer uma verifica��o
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//Se qName for igual "Produto", dever� inst�nciar a classe Produtos e Marca
		//"Produto" � o nome do Elemento criado na classe Manipula�aoDeDadosXMl
		if(qName.equals("Produto")) {
			produtos = new Produtos();
			marca= new Marca();
		}
		//Se caso qName n�o for igual "Produto", receber todas as informa��es que o usu�rio digitar e juntar na vari�vel" texto= new StringeBuider"
		else {
			texto= new StringBuilder();
		}

	}
	//M�todo respons�vel por receber a vari�vel "texto", separar cada informa��o e enviar-las para cada atributo do Produto
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//se qName for igual o nome do Elemento criado, enviar "texto" para uma determinada vari�vel
		if(qName.equals("Nome")) {
			produtos.setNome(texto.toString());
		}else if(qName.equals("Categoria")) {
			produtos.setCategoria(texto.toString());
		}else if(qName.equals("Marca")) {
			marca.setNomeMarca(texto.toString());
		}else if(qName.equals("Preco")){
			marca.setPreco(Double.parseDouble(texto.toString()));
			produtos.setMarca(marca);
			//Adicionado o onjeto e seus atributos na lista
			ListaDeProdutos.getInstance().add(produtos);
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//Comando que permite a vari�vel"texto" receber caracteres
		texto.append(ch, start, length);

	}
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub

	}


}
