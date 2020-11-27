package view;

import java.awt.*;
import java.util.Scanner;

import business.control.Sistema;
import business.report.FabricaGeradorRelatorio;
import business.authentication.FabricaAdaptadorAutenticador;

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
                "Adicionar item",
                "Remover item",
                "Lista todos itens",
                "Gerar relatório HTML",
                "Gerar relatório TXT",
                "Login com conta Google",
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
                System.out.println("\nDigite nome do item:");
                input = scanner.nextLine();
                sistema.adicionarItem(input);
                break;

            case "9":
                System.out.println("\nDigite nome do item:");
                input = scanner.nextLine();
                sistema.removerItem(input);
                break;

            case "10":
                System.out.println("\nTodos os itens:");
                sistema.listarItens();
                break;    

            case "11":
                sistema.gerarRelatorio(FabricaGeradorRelatorio.obterGeradorRelatorio("html"));
                break;
            
            case "12":
                sistema.gerarRelatorio(FabricaGeradorRelatorio.obterGeradorRelatorio("txt"));
                break;
            
            case "13":
                System.out.println("\nDigite login e senha do Google:");
                input = scanner.nextLine();
                sistema.login(input, FabricaAdaptadorAutenticador.obterAdaptadorAutenticador("google"));
                break;
            
            case "14":
                input = null;
                sistema.encerrarPrograma();
                break;

            default:
                System.out.println("\nOpção inválida. Tente novamente\n");    
        }

        return input; 

    }



}