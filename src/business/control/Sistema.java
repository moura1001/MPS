package business.control;

import util.AdicaoUsuarioException;
import util.ErroInternoException;
import util.LoginUsuarioException;
import business.report.GeradorRelatorioHTML;
import business.report.GeradorRelatorioTXT;

import java.util.Scanner;

public class Sistema {

    private static Sistema sistema;
    GerenteUsuario gerenteUsuario;
    GerentePedido gerentePedido;

    public Sistema(GerenteUsuario gerenteUsuario, GerentePedido gerentePedido) {
        this.gerenteUsuario = gerenteUsuario;
        this.gerentePedido = gerentePedido;
    }

    public static Sistema obterInstancia(GerenteUsuario gerenteUsuario, GerentePedido gerentePedido) {
        if (sistema == null) {
            sistema = new Sistema(gerenteUsuario, gerentePedido);
        }
        return sistema;
    }

    public void adicionarUsuario(String args){
        try{
            gerenteUsuario.adicionar(args);
            //gerente.listarTodos();

        } catch(AdicaoUsuarioException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirUsuario(String args){
        try{
            gerenteUsuario.remover(args);
            //gerente.listarTodos();

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarUsuarios1(){
        gerenteUsuario.listarTodosPorOrdemAlfabetica();
    }

    public void listarUsuarios2(){
        gerenteUsuario.listarTodosPorOrdemDataDeNascimento();
    }

    public void adicionarPedido(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha 1 item e seu valor: ");
        String input = scanner.nextLine();
        String[] itens = {input.split(" ")[0]};
        double valor = Double.parseDouble(input.split(" ")[1]);
        gerentePedido.adicionar(itens, valor, login);
    }

    public void removerPedido(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o item a ser removido: ");
        String input = scanner.nextLine();
        gerentePedido.removerPedido(login, input);
    }

    public void listarPedidos() {
        gerentePedido.listarTodos();
    }

    public void gerarRelatorio(String tipo){
        switch(tipo){            
            case "html":
                new GeradorRelatorioHTML().gerarRelatorio();
                break;
            
            case "txt":
                new GeradorRelatorioTXT().gerarRelatorio();
                break;    
        }
    }

    public void encerrarPrograma(){
        try{
            gerenteUsuario.encerrar();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }
}
