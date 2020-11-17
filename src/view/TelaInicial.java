package view;

import java.util.Scanner;
import util.AdicaoUsuarioException;
import util.LoginUsuarioException;
import util.ErroInternoException;
import business.control.GerenteUsuario;
import infra.GerentePersistenciaFile;

public class TelaInicial{

    GerenteUsuario gerente;
    
    public TelaInicial(){
        try{
            gerente = new GerenteUsuario();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }        
    }

    public String menu(){
        System.out.println("\nEscolha uma das opções abaixo:");
        System.out.println("1: Adicionar usuário");
        System.out.println("2: Excluir usuário");
        System.out.println("3: Listar todos os usuários");
        System.out.println("4: Encerrar programa");

        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
        String output = null;

        if(input == null || !input.matches("^1|^2|^3|^4")){
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
                output = input;
                listarUsuarios(); 
                break;
            
            case "4":
                encerrarPrograma(); 
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
        
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    private void excluirUsuario(String args){
        try{
            gerente.remover(args);
            gerente.listarTodos();
        
        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
        
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    private void listarUsuarios(){
        gerente.listarTodos();
    }

    private void encerrarPrograma(){
        try{
            gerente.encerrar();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

}