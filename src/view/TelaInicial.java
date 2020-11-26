package view;

import java.awt.*;
import java.util.Scanner;

import business.control.Sistema;

public class TelaInicial{

    Sistema sistema;

    public TelaInicial(Sistema sistema) {
        this.sistema = sistema;
    }

    public String menu(){
        String[] acoes = {
                "",
                "Adicionar usuário",
                "Excluir usuário",
                "Listar todos os usuários por ordem alfabética",
                "Listar todos os usuários por ordem data de nascimento",
                "Adicionar pedido",
                "Remover pedido",
                "Lista todos pedidos",
                "Gerar relatório HTML",
                "Gerar relatório TXT",
                "Encerrar programa"
        };

        for (int i = 1; i < acoes.length; i++) {
            System.out.println(String.valueOf(i) + ": " + acoes[i]);
        }


        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

        if(input == null){
            System.out.println("\nOpção inválida. Tente novamente\n");
            return "null";
        }

        switch(input){
            
            case "1":
                System.out.println("\nDigite login e senha:");
                //System.out.println("\nDigite login, senha e data de nascimento:");
                input = scanner.nextLine(); 
                sistema.adicionarUsuario(input);
                break; 
            
            case "2":
                System.out.println("\nDigite login:");
                input = scanner.nextLine(); 
                sistema.excluirUsuario(input);
                break;
            
            case "3":
                sistema.listarUsuarios1();
                break;

            case "4":
                sistema.listarUsuarios2();
                break;    
            
            case "5":
                System.out.println("\nDigite login:");
                input = scanner.nextLine();
                sistema.adicionarPedido(input);
                break;

            case "6":
                System.out.println("\nDigite login:");
                input = scanner.nextLine();
                sistema.removerPedido(input);
                break;

            case "7":
                System.out.println("\nTodos pedidos:");
                sistema.listarPedidos();
                break;

            case "8":
                sistema.gerarRelatorio("html");
                break;
            
            case "9":
                sistema.gerarRelatorio("txt");
                break;
            
            case "10":
                input = null;
                sistema.encerrarPrograma();
                break;

            default:
                System.out.println("\nOpção inválida. Tente novamente\n");    
        }

        return input; 

    }



}