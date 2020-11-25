package business.control;

import util.AdicaoUsuarioException;
import util.ErroInternoException;
import util.LoginUsuarioException;

import java.util.Scanner;

public class Sistema {

    GerenteUsuario gerente;
    GerentePedido gerentePedido;
    
    public Sistema() {
        this.gerente = GerenteUsuario.getGerente();
        this.gerentePedido = GerentePedido.getGerente();        
    }

    public void adicionarUsuario(String args){
        try{
            gerente.adicionar(args);
            //gerente.listarTodos();

        } catch(AdicaoUsuarioException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirUsuario(String args){
        try{
            gerente.remover(args);
            //gerente.listarTodos();

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarUsuarios1(){
        gerente.listarTodosPorOrdemAlfabetica();
    }

    public void listarUsuarios2(){
        gerente.listarTodosPorOrdemDataDeNascimento();
    }

    public void adicionarPedido(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha 1 item e seu valor: ");
        String input = scanner.nextLine();
        String[] itens = {input.split(" ")[0]};
        double valor = Double.parseDouble(input.split(" ")[1]);
        gerentePedido.adicionar(itens, valor, login);
    }

    public void listarPedidos() {
        gerentePedido.listarTodos();
    }

    public void encerrarPrograma(){
        try{
            gerente.encerrar();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }
}
