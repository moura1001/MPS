package main;

import business.control.Sistema;
import view.TelaInicial;

public class Main{

	public static void main(String[] args){

		Sistema sistema = Sistema.obterInstancia();

		TelaInicial tela = new TelaInicial(sistema);
		
		//System.out.println("Hello world");
		
		while(tela.menu() != null)
			;		

	}

}