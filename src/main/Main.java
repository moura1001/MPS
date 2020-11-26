package main;

import business.control.GerentePedido;
import business.control.GerenteUsuario;
import business.control.Sistema;
import view.TelaInicial;

public class Main{

	public static void main(String[] args){
		GerenteUsuario gerenteUsuario = GerenteUsuario.getGerente();
		GerentePedido gerentePedido = GerentePedido.getGerente();

		Sistema sistema = Sistema.obterInstancia(gerenteUsuario, gerentePedido);

		TelaInicial tela = new TelaInicial(sistema);
		
		//System.out.println("Hello world");
		
		while(tela.menu() != null)
			;		

	}

}