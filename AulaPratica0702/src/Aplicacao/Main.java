package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import View.ViewProduto;


public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader reader= new BufferedReader( new InputStreamReader(System.in));

		int menu=0;


		while(menu < 5) 	{
			//recebendo o retorno do m�todo ViewMenuPrincipal
			menu=ViewProduto.ViewMenuPrincipal(reader);



			try {
				//Mostrando o menu Principal
				//Fazendo um la�o de repeti��o e puxando os m�todos da classe "Crud"
				switch(menu){


				case 1:
					Crud.SalvarProduto(reader);
					break;

				case 2:
					Crud.ListarProduto();
					break;

				case 3:
					Crud.DeletarProdutos(reader);
					break;


				case 4:
					Crud.EditarProduto(reader);
					break;


				case 5:
					ViewProduto.ViewMensagens(3);
					break;



				}

			}

			catch (Exception e) {

			}

		}

	}
}




