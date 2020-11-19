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
        System.out.println("3: Listar todos os usuários por ordem alfabética");
        System.out.println("4: Listar todos os usuários por ordem data de nascimento");
        System.out.println("5: Encerrar programa");

        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
        String output = null;

        if(input == null || !input.matches("^1|^2|^3|^4|^5")){
            System.out.println("\nOpção inválida. Tente novamente\n");
            return "null";
        }

        switch(input){ 
            
            case "1":
                System.out.println("\nDigite login e senha:");
                //System.out.println("\nDigite login, senha e data de nascimento:");
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
                listarUsuarios1(); 
                break;

            case "4":
                output = input;
                listarUsuarios2(); 
                break;    
            
            case "5":
                encerrarPrograma(); 
                break; 
        }

        return output; 

    }

	private void adicionarUsuario(String args){
        try{
            gerente.adicionar(args);
		    //gerente.listarTodos();        
        
        } catch(AdicaoUsuarioException e){
            System.out.println(e.getMessage());
        
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    private void excluirUsuario(String args){
        try{
            gerente.remover(args);
            //gerente.listarTodos();
        
        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
        
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    private void listarUsuarios1(){
        gerente.listarTodosPorOrdemAlfabetica();
    }

    private void listarUsuarios2(){
        gerente.listarTodosPorOrdemDataDeNascimento();
    }

    private void encerrarPrograma(){
        try{
            gerente.encerrar();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

}