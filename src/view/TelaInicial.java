package view;

import java.util.Scanner;

import business.control.Sistema;
import business.control.GerentePagamento;
import business.report.FabricaGeradorRelatorio;
import business.authentication.FabricaAdaptadorAutenticador;

public class TelaInicial{

    Sistema sistema;
    GerentePagamento gerentePagamento;

    public TelaInicial(Sistema sistema) {
        this.sistema = sistema;
        gerentePagamento = GerentePagamento.getGerente();
    }

    public String menu(){
        String[] acoes = {
                "",
                "Adicionar entregador",
                "Excluir entregador",
                "Listar todos os entregadores por ordem alfabética",
                "Listar todos os entregadores por ordem data de nascimento",
                "Adicionar lista de compra",
                "Remover lista de compra",
                "Listar todas as listas de compras",
                "Adicionar produto",
                "Remover produto",
                "Listar todos os produtos",
                "Adicionar pagamento",
                "Atualizar pagamento",
                "Buscar pagamento",
                "Desfazer atualização de pagamento",
                "Gerar relatório HTML",
                "Gerar relatório TXT",
                "Login com conta Google",
                "Encerrar programa\n"
        };

        for (int i = 0; i < acoes.length; i++) {
            if(i == 0)
                System.out.println("\n");
            else
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
                sistema.adicionarEntregador(input);
                break; 
            
            case "2":
                System.out.println("\nDigite login:");
                input = scanner.nextLine(); 
                sistema.excluirEntregador(input);
                break;
            
            case "3":
                sistema.listarEntregadores1();
                break;

            case "4":
                sistema.listarEntregadores2();
                break;    
            
            case "5":
                System.out.println("\nDigite login:");
                input = scanner.nextLine();
                sistema.adicionarNaListaDeCompra(input);
                break;

            case "6":
                System.out.println("\nDigite login:");
                input = scanner.nextLine();
                sistema.removerListaDeCompra(input);
                break;

            case "7":
                System.out.println("\nTodas as listas de compras:");
                sistema.listarListasDeCompras();
                break;

            case "8":
                System.out.println("\nDigite nome e valor do produto:");
                input = scanner.nextLine();
                sistema.adicionarProduto(input);
                break;

            case "9":
                System.out.println("\nDigite nome do produto:");
                input = scanner.nextLine();
                sistema.removerProduto(input);
                break;

            case "10":
                System.out.println("\nTodos os produtos:");
                sistema.listarProdutos();
                break;    

            case "11":
                System.out.println("\nDigite login e valor do pagamento:");
                input = scanner.nextLine();
                gerentePagamento.service("adicionar", input);
                break;
            
            case "12":
                System.out.println("\nDigite login, id do pagamento e novo valor:");
                input = scanner.nextLine();
                gerentePagamento.service("atualizar", input);
                break;
            
            case "13":
                System.out.println("\nDigite login e id do pagamento:");
                input = scanner.nextLine();
                gerentePagamento.service("buscar", input);
                break;
                
            case "14":
                gerentePagamento.desfazerAtualizacao();
                break;   
            
            case "15":
                sistema.gerarRelatorio(FabricaGeradorRelatorio.obterGeradorRelatorio("html"));
                break;
            
            case "16":
                sistema.gerarRelatorio(FabricaGeradorRelatorio.obterGeradorRelatorio("txt"));
                break;
            
            case "17":
                System.out.println("\nDigite login e senha do Google:");
                input = scanner.nextLine();
                sistema.login(input, FabricaAdaptadorAutenticador.obterAdaptadorAutenticador("google"));
                break;
            
            case "18":
                input = null;
                sistema.encerrarPrograma();
                System.out.println("\nAplicação encerrada");
                break;

            default:
                System.out.println("\nOpção inválida. Tente novamente\n");    
        }

        return input; 

    }



}