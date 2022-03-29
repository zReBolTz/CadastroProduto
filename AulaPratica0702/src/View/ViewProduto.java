package View;

import java.io.BufferedReader;
import java.io.IOException;


import MarcaProd.Produtos;
import Util.ListaDeProdutos;

public class ViewProduto {


	//Menu Principal, m�todo respons�vel por mostrar todas as op��es para o usu�rio
	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {

		System.out.println("[1] Cadastro de Produto");
		System.out.println("[2] Consultar Produtos Cadastrados");
		System.out.println("[3] Deletar Produto");
		System.out.println("[4] Editar Produto");
		System.out.println("[5] Sair");
		System.out.println("");
		//Retornando a resposta do usu�rio
		return Integer.parseInt(reader.readLine());

	}

	
	public static String[] ViewMenuSalvarProduto(BufferedReader reader) throws IOException {

		//vari�vel respons�vel por receber todas as perguntas que far� ao usu�rio quando ele optar pela op�a� 1
		String[] Produtos= {"\nDigite o nome do produto:", "\nDigite a categoria do produto:","\nDigite o nome da marca:", "\nDigite o pre�o do produto:"};

		//Vari�vel recebendo todas as respostas que o usus�io digitou e colocando em uma posi��o, EXEMPLOS: resposta 0= posi��o [0],resposta 1= posi��o [1], resposta 2= posi��o [2], resposta 3= posi��o [3].
		String[] dadosProdutos={"","","",""};

		//Enquanto "i" for menor que a quantidade de informa��es do produtos= System.out.printl(produto)
		for(int i=0; i< Produtos.length;i++) {
			System.out.println(Produtos[i]);

			dadosProdutos[i]=reader.readLine();
		}
		//retornando as respostas do usu�rio
		return dadosProdutos;


	}

	//M�todo �nico tanto para o editar e Deletar, ele � respons�vel por apenas mostrar a lista dos objetos e receber o que o usu�rio digitar
	public static int ViewMenuEditarOuDeletarProduto(String editar_Deletar,  BufferedReader Reader) throws NumberFormatException, IOException {
		//Enquanto "i" for menor que o tamanho da lista de produtos, dever� mostrar na tela a Lista de Produtos
		for(int i=0; i<ListaDeProdutos.getInstance().size(); i++)
			System.out.println(i+ " - "+ ListaDeProdutos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja " + editar_Deletar);

		//retornando o que o usu�rio digitou
		return 	Integer.parseInt(Reader.readLine());
	}

	
	//M�todo apenas para a op��o "editar"
	//Ap�s o usu�rio optar pela op��o"editar", o m�todo mostrar� um menu perguntando o que o usu�rio deseja editar
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws NumberFormatException, IOException{
		//Vari�vel que receber� duas informa��es
		String[] ProdutosEditados={"",""};

		//Menu com todas as op��es perguntando o que o usu�rio deseja editar
		System.out.println("escolha o Atributo que deseja editar:");
		System.out.println("1 - Produto\n" 
				+"2 - Categoria do Produto\n" 
				+"3 - Marca Do Produto\n"  
				+"4 - Pre�o do Produto\n");
		ProdutosEditados[0]=(reader.readLine());

		System.out.println("Digite o novo valor do atributo:");
		ProdutosEditados[1]=(reader.readLine());

		//retornando as duas respostas do usu�rio digitou
		return ProdutosEditados;
	
		
	}

	//
	//Respons�vel por mostrar a lista com todos os objetos cadastrados
	public static void ViewListaEditada(){
		System.out.println("------------------Produtos-------------------");
		for (Produtos a : ListaDeProdutos.getInstance()) {
			System.out.println("Nome do Produto: " + a.getNome());
			System.out.println("Categoria: " + a.getCategoria());
			System.out.println("Marca: " + a.getMarca().getNomeMarca());
			System.out.println("Pre�o: " + a.getMarca().getPreco());
			System.out.println("");

		}
		System.out.println("---------------------------------------------");
	}
	
	
	//M�todo respons�vel por mostrar uma mensagem ap�s alguma a��o
	public static void ViewMensagens(int op) {

		String linha="=======================================";

		String msg[]={"PRODUTO CADASTRADO COM SUCESSO","PRODUTO EDITADO COM SUCESSO", "PRODUTO DELETADO COM SUCESSO", "OBRIGADO POR UTILIZAR NOSSO PROGRAMA \n	  VOLTE SEMPRE =)"};
		System.out.println(linha);
		System.out.println(msg[op]);
		System.out.println(linha);
		System.out.println("");
	}
}
