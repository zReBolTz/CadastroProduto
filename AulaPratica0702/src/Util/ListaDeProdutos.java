package Util;

import java.util.ArrayList;
import java.util.List;

import MarcaProd.Produtos;

public class ListaDeProdutos {
	//Única lista criada em todo programa
	private static List<Produtos>ListaProdutos = new ArrayList<Produtos>();
	
	//Com o getInstance podemos fazer uma única lista para todas as classes do programa, excluindo assim a quantidade de listas que seriam criadas.
	//
	public static List<Produtos> getInstance(){

		return ListaProdutos;
	}
}

