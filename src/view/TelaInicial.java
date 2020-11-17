package view;

import java.util.Scanner;
import util.AdicaoUsuarioException;
import util.LoginUsuarioException;
import business.control.GerenteUsuario;
import infra.GerentePersistenciaFile;

public class TelaInicial{

    GerenteUsuario gerente = new GerenteUsuario(new GerentePersistenciaFile());

    public String menu(){
        System.out.println("\n1: Adicionar usuário");
        System.out.println("2: Excluir usuário");
        System.out.println("3: Encerrar programa");

        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
        String output = null;

        if(input == null || !input.matches("^1|^2|^3")){
            System.out.println("\nOpção inválida. Tente novamente\n");
            return "null";
        }

        switch(input){ 
            
            case "1":
                System.out.println("\nDigite login e senha:");
                input = scanner.nextLine(); 
                output = input;
                adicionarUsuario(input);
                break; 
            
            case "2":
                System.out.println("\nDigite login:");
                input = scanner.nextLine(); 
                output = input;
                excluirUsuario(input); 
                break;
            
            case "3": 
                break; 
        }

        //System.out.println();
        return output; 

    }

	private void adicionarUsuario(String args){
        try{
            gerente.adicionar(args);
		    gerente.listarTodos();        
        } catch(AdicaoUsuarioException e){
            System.out.println(e.getMessage());
        }

    }

    private void excluirUsuario(String args){
        try{
            gerente.remover(args);
            gerente.listarTodos();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}