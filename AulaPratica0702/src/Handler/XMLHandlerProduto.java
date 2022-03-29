package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import MarcaProd.Marca;
import MarcaProd.Produtos;
import Util.ListaDeProdutos;


public class XMLHandlerProduto extends DefaultHandler {
	//Variável que consegue juntar as informações que o usuário digitar 
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

	//Para iniciar um elemento, primeiro temos que fazer uma verificação
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//Se qName for igual "Produto", deverá instânciar a classe Produtos e Marca
		//"Produto" é o nome do Elemento criado na classe ManipulaçaoDeDadosXMl
		if(qName.equals("Produto")) {
			produtos = new Produtos();
			marca= new Marca();
		}
		//Se caso qName não for igual "Produto", receber todas as informações que o usuário digitar e juntar na variável" texto= new StringeBuider"
		else {
			texto= new StringBuilder();
		}

	}
	//Método responsável por receber a variável "texto", separar cada informação e enviar-las para cada atributo do Produto
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//se qName for igual o nome do Elemento criado, enviar "texto" para uma determinada variável
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
		//Comando que permite a variável"texto" receber caracteres
		texto.append(ch, start, length);

	}
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub

	}


}
