package View;

import java.io.BufferedReader;
import java.io.IOException;


import MarcaProd.Produtos;
import Util.ListaDeProdutos;

public class ViewProduto {


	//Menu Principal, método responsável por mostrar todas as opções para o usuário
	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {

		System.out.println("[1] Cadastro de Produto");
		System.out.println("[2] Consultar Produtos Cadastrados");
		System.out.println("[3] Deletar Produto");
		System.out.println("[4] Editar Produto");
		System.out.println("[5] Sair");
		System.out.println("");
		//Retornando a resposta do usuário
		return Integer.parseInt(reader.readLine());

	}

	
	public static String[] ViewMenuSalvarProduto(BufferedReader reader) throws IOException {

		//variável responsável por receber todas as perguntas que fará ao usuário quando ele optar pela opçaõ 1
		String[] Produtos= {"\nDigite o nome do produto:", "\nDigite a categoria do produto:","\nDigite o nome da marca:", "\nDigite o preço do produto:"};

		//Variável recebendo todas as respostas que o ususáio digitou e colocando em uma posição, EXEMPLOS: resposta 0= posição [0],resposta 1= posição [1], resposta 2= posição [2], resposta 3= posição [3].
		String[] dadosProdutos={"","","",""};

		//Enquanto "i" for menor que a quantidade de informações do produtos= System.out.printl(produto)
		for(int i=0; i< Produtos.length;i++) {
			System.out.println(Produtos[i]);

			dadosProdutos[i]=reader.readLine();
		}
		//retornando as respostas do usuário
		return dadosProdutos;


	}

	//Método único tanto para o editar e Deletar, ele é responsável por apenas mostrar a lista dos objetos e receber o que o usuário digitar
	public static int ViewMenuEditarOuDeletarProduto(String editar_Deletar,  BufferedReader Reader) throws NumberFormatException, IOException {
		//Enquanto "i" for menor que o tamanho da lista de produtos, deverá mostrar na tela a Lista de Produtos
		for(int i=0; i<ListaDeProdutos.getInstance().size(); i++)
			System.out.println(i+ " - "+ ListaDeProdutos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja " + editar_Deletar);

		//retornando o que o usuário digitou
		return 	Integer.parseInt(Reader.readLine());
	}

	
	//Método apenas para a opção "editar"
	//Após o usuário optar pela opção"editar", o método mostrará um menu perguntando o que o usuário deseja editar
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws NumberFormatException, IOException{
		//Variável que receberá duas informações
		String[] ProdutosEditados={"",""};

		//Menu com todas as opções perguntando o que o usuário deseja editar
		System.out.println("escolha o Atributo que deseja editar:");
		System.out.println("1 - Produto\n" 
				+"2 - Categoria do Produto\n" 
				+"3 - Marca Do Produto\n"  
				+"4 - Preço do Produto\n");
		ProdutosEditados[0]=(reader.readLine());

		System.out.println("Digite o novo valor do atributo:");
		ProdutosEditados[1]=(reader.readLine());

		//retornando as duas respostas do usuário digitou
		return ProdutosEditados;
	
		
	}

	//
	//Responsável por mostrar a lista com todos os objetos cadastrados
	public static void ViewListaEditada(){
		System.out.println("------------------Produtos-------------------");
		for (Produtos a : ListaDeProdutos.getInstance()) {
			System.out.println("Nome do Produto: " + a.getNome());
			System.out.println("Categoria: " + a.getCategoria());
			System.out.println("Marca: " + a.getMarca().getNomeMarca());
			System.out.println("Preço: " + a.getMarca().getPreco());
			System.out.println("");

		}
		System.out.println("---------------------------------------------");
	}
	
	
	//Método responsável por mostrar uma mensagem após alguma ação
	public static void ViewMensagens(int op) {

		String linha="=======================================";

		String msg[]={"PRODUTO CADASTRADO COM SUCESSO","PRODUTO EDITADO COM SUCESSO", "PRODUTO DELETADO COM SUCESSO", "OBRIGADO POR UTILIZAR NOSSO PROGRAMA \n	  VOLTE SEMPRE =)"};
		System.out.println(linha);
		System.out.println(msg[op]);
		System.out.println(linha);
		System.out.println("");
	}
}
