package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProduto;
import MarcaProd.Produtos;
import Util.ListaDeProdutos;

public class ManipulacaoDeDadosXMl {

	public static String nomeDoArquivo="CadastroDeProdutos.xml";
	//Método criando o XML
	public static void SalvarArquivoXml() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		//Comando que habilitar a manipulação em XML
		DocumentBuilderFactory DBF= DocumentBuilderFactory.newInstance();
		//Comando que cria o Documento Construtor, seria como uma empresa dentro de outra, no caso ela seria a empresa principal e o "Document" o que ficaria dentro. 
		//Ele que manipula todos os "document" criados
		DocumentBuilder DB= DBF.newDocumentBuilder();
	
		//Criando um documento
		Document doc= DB.newDocument();
		//Criando um elemento dentro do documento e colocando seus atributos
		Element ProdutoTag= doc.createElement("Produtos");
		doc.appendChild(ProdutoTag);

		for(Produtos a : ListaDeProdutos.getInstance()) {
			Element produtoTagElement= doc.createElement("Produto");
			ProdutoTag.setAttribute("id", "1");
			ProdutoTag.appendChild(produtoTagElement);

			Element nomeTag=doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			ProdutoTag.appendChild(nomeTag);

			Element catgoriaTag=doc.createElement("Categoria");
			catgoriaTag.setTextContent(a.getCategoria());
			ProdutoTag.appendChild(catgoriaTag);

			Element marcaTag=doc.createElement("Marca");
			marcaTag.setTextContent(a.getMarca().getNomeMarca());
			ProdutoTag.appendChild(marcaTag);


			Element precoTag=doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
			ProdutoTag.appendChild(precoTag);




		}
		//Comandos responsável por receber todas as informações do documento e transformar tudo em XML
		TransformerFactory TF= TransformerFactory.newDefaultInstance();
		Transformer trans= TF.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");



		DOMSource source =  new DOMSource(doc);
		
		
		try(OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){
			StreamResult result= new StreamResult(osw);
			trans.transform(source, result);
		}

	}
	
	
	//Método responsável por fazer a leitura do XML
	public static void lerArquivoXml() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {

		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){
			InputSource source = new InputSource(isr);
			
			XMLHandlerProduto handler = new XMLHandlerProduto();
			
			parser.parse(source, handler);
		}
	}
}
