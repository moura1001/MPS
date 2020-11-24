package view;

import java.awt.*;
import java.util.Scanner;

import business.control.GerentePedido;
import business.control.Sistema;
import util.AdicaoUsuarioException;
import util.LoginUsuarioException;
import util.ErroInternoException;
import business.control.GerenteUsuario;
import infra.GerentePersistenciaFile;

public class TelaInicial{

    Sistema sistema;

    public TelaInicial() {
        this.sistema = new Sistema();
    }

    public String menu(){
        String[] acoes = {
                "",
                "Adicionar usuário",
                "Excluir usuário",
                "Listar todos os usuários por ordem alfabética",
                "Listar todos os usuários por ordem data de nascimento",
                "Adicionar pedido",
                "Lista todos pedidos",
                "Encerrar programa"
        };

        for (int i = 0; i < acoes.length; i++) {
            System.out.println(String.valueOf(i) + ": " + acoes[i]);
        }


        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
        String output = null;

        if(input == null || !input.matches("^1|^2|^3|^4|^5|^6|^7|^8")){
            System.out.println("\nOpção inválida. Tente novamente\n");
            return "null";
        }

        switch(input){
            
            case "1":
                System.out.println("\nDigite login e senha:");
                //System.out.println("\nDigite login, senha e data de nascimento:");
                input = scanner.nextLine(); 
                output = input;
                sistema.adicionarUsuario(input);
                break; 
            
            case "2":
                System.out.println("\nDigite login:");
                input = scanner.nextLine(); 
                output = input;
                sistema.excluirUsuario(input);
                break;
            
            case "3":
                output = input;
                sistema.listarUsuarios1();
                break;

            case "4":
                output = input;
                sistema.listarUsuarios2();
                break;    
            
            case "5":
                System.out.println("\nDigite login:");
                input = scanner.nextLine();
                output = input;
                sistema.adicionarPedido(input);
                break;

            case "6":
                System.out.println("\nTodos pedidos:");
                sistema.listarPedidos();
                break;

            case "7":
                sistema.encerrarPrograma();
                break;
        }

        return output; 

    }



}