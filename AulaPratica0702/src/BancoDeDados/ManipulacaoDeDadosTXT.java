package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import MarcaProd.Produtos;
import Util.ListaDeProdutos;





public class ManipulacaoDeDadosTXT {

	private static String nomeDoArquivo= "Cadastro De Produtos.txt";
		//Método responsável por criar uma lista TXT
		public static void SalvarProdutoTXT() throws IOException {
		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(nomeDoArquivo));
			PrintWriter pw= new PrintWriter(buffer)) {
			for (Produtos a: ListaDeProdutos.getInstance()) 
				pw.println(a);
		}
	}
		
		
	
//Método responsável por salvar todos os objetos na lista TXT
public static void LerArquivoTXT (List<Produtos> ListaDeProdutos) throws IOException {

		String line="";

		try (BufferedReader reader= new BufferedReader(new FileReader(nomeDoArquivo))){
			//Enquanto line for diferente que null"Vázio", estânciar a classe "Produtos" e adicionar o objeto na lista
			while((line= reader.readLine()) != null && !"".equals(line)) {
				Produtos al= new Produtos(line);
				ListaDeProdutos.add(al);
			}


		} catch (IOException e) {

			e.printStackTrace();


		}
		
		
		
		}


	
	
	
	
	
	
	
	
	
	
	
}
