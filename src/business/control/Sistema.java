package business.control;

import util.AdicaoEntregadorException;
import util.ErroInternoException;
import util.LoginEntregadorException;
import util.ProdutoException;
import business.report.GeradorRelatorio;
import business.authentication.AdaptadorAutenticador;
import business.model.Produto;
import java.util.Scanner;

public class Sistema {

    private static Sistema sistema;
    GerenteEntregador gerenteEntregador;
    GerenteListaDeCompra gerenteListaDeCompra;
    GerenteProduto gerenteProduto;
    private int numeroAcessosEntregadores;

    private Sistema() {
        this.gerenteEntregador = GerenteEntregador.getGerente();
        this.gerenteListaDeCompra = GerenteListaDeCompra.getGerente();
        this.gerenteProduto = GerenteProduto.getGerente();
        this.numeroAcessosEntregadores = 0;
    }

    public static Sistema obterInstancia() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    public void adicionarEntregador(String args){
        try{
            gerenteEntregador.adicionar(args);
            //gerente.listarTodos();

        } catch(AdicaoEntregadorException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirEntregador(String args){
        try{
            gerenteEntregador.remover(args);
            //gerente.listarTodos();

        } catch(LoginEntregadorException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarEntregadores1(){
        gerenteEntregador.listarTodosPorOrdemAlfabetica();
    }

    public void listarEntregadores2(){
        gerenteEntregador.listarTodosPorOrdemDataDeNascimento();
    }

    public void adicionarNaListaDeCompra(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha 1 produto: ");
        String input = scanner.nextLine();
        Produto produto = null;
        try{
            produto = GerenteProduto.getGerente().getProduto(input.split(" ")[0]);

        } catch(ProdutoException e){
            System.out.println(e.getMessage());
            return;
        }
        gerenteListaDeCompra.adicionar(produto, login);
    }

    public void removerDaListaDeCompra(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o produto a ser removido: ");
        String input = scanner.nextLine();
        gerenteListaDeCompra.removerProdutoDaListaDeCompra(login, input);
    }

    public void removerListaDeCompra(String login) {
        gerenteListaDeCompra.removerListaDeCompra(login);
    }

    public void listarListasDeCompras() {
        gerenteListaDeCompra.listarTodos();
    }

    public void adicionarProduto(String produto){

        try{
            gerenteProduto.adicionar(produto);

        } catch(ProdutoException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void removerProduto(String nome) {
        try{
            gerenteProduto.remover(nome);

        } catch(ProdutoException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarProdutos() {
        gerenteProduto.listarTodos();
    }

    public void gerarRelatorio(GeradorRelatorio geradorRelatorio){
        geradorRelatorio.gerarRelatorio();
    }

    public void login(String entregador, AdaptadorAutenticador autenticador){
        if(entregador == null)
            System.out.println("\nFalha na autenticação. Digite Login e senha\n");

        String[] info = entregador.split("[\\t ]");

        if(info.length != 2){
            System.out.println("\nFalha na autenticação. Login ou senha não informados\n");
            return;
        }

        String email = info[0];
        String senha = info[1];
        
        if(autenticador.autenticar(email, senha)){
            System.out.println("\nAutenticação realizada. Login bem-sucedido.\n");
            this.numeroAcessosEntregadores++;
        }
        else
            System.out.println("\nFalha na autenticação. Login ou senha incorretos.\n");
    }

    public int numeroAcessos() {
        return this.numeroAcessosEntregadores;
    }

    public void encerrarPrograma(){
        try{
            gerenteEntregador.encerrar();
            gerenteProduto.encerrar();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }
}
