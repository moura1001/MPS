package view;

import java.util.Scanner;
import business.control.GerenteUsuario;

public class TelaInicial{

    GerenteUsuario gerente = new GerenteUsuario();

    public String menu(){
        System.out.println("1: Adicionar usuário");
        System.out.println("2: Excluir usuário");
        System.out.println("3: Encerrar programa");

        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
        String output = null;

        switch(input){ 
            
            case "1":
                System.out.println("\nDigite login e senha:");
                input = scanner.nextLine(); 
                output = input;
                String[] usuario = input.split(" ");
                adicionarUsuario(usuario);
                break; 
            
            case "2":
                System.out.println("\nDigite login:");
                input = scanner.nextLine(); 
                output = input;
                excluirUsuario(input); 
                break;
            
            case "3": 
                break; 
            
            default: 
                input = null; 
        }

        if(input == null){
            System.out.println("\nOpção inválida. Tente novamente\n");
            return "null";
        }
        //System.out.println();
        return output; 

    }

	private void adicionarUsuario(String[] args){
        gerente.adicionar(args[0], args[1]);
		gerente.listarTodos();
    }

    private void excluirUsuario(String arg){
        gerente.remover(arg);
        gerente.listarTodos();
    }

}