package business.control;

import util.AdicaoUsuarioException;
import util.ErroInternoException;
import util.LoginUsuarioException;
import util.ItemException;
import business.report.GeradorRelatorio;
import business.authentication.AdaptadorAutenticador;
import business.model.Item;
import java.util.Scanner;

public class Sistema {

    private static Sistema sistema;
    GerenteUsuario gerenteUsuario;
    GerentePedido gerentePedido;
    GerenteItem gerenteItem;
    private int numeroAcessosUsuarios;

    private Sistema() {
        this.gerenteUsuario = GerenteUsuario.getGerente();
        this.gerentePedido = GerentePedido.getGerente();
        this.gerenteItem = GerenteItem.getGerente();
        this.numeroAcessosUsuarios = 0;
    }

    public static Sistema obterInstancia() {
        if (sistema == null) {
            sistema = new Sistema();
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

    public void adicionarNoPedido(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha 1 item: ");
        String input = scanner.nextLine();
        Item item = null;
        try{
            item = GerenteItem.getGerente().getItem(input.split(" ")[0]);

        } catch(ItemException e){
            System.out.println(e.getMessage());
            return;
        }
        gerentePedido.adicionar(item, login);
    }

    public void removerDoPedido(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o item a ser removido: ");
        String input = scanner.nextLine();
        gerentePedido.removerItemDoPedido(login, input);
    }

    public void removerPedido(String login) {
        gerentePedido.removerPedido(login);
    }

    public void listarPedidos() {
        gerentePedido.listarTodos();
    }

    public void adicionarItem(String item){

        try{
            gerenteItem.adicionar(item);

        } catch(ItemException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void removerItem(String nome) {
        try{
            gerenteItem.remover(nome);

        } catch(ItemException e){
            System.out.println(e.getMessage());

        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }

    public void listarItens() {
        gerenteItem.listarTodos();
    }

    public void gerarRelatorio(GeradorRelatorio geradorRelatorio){
        geradorRelatorio.gerarRelatorio();
    }

    public void login(String usuario, AdaptadorAutenticador autenticador){
        if(usuario == null)
            System.out.println("\nFalha na autenticação. Digite Login e senha\n");

        String[] info = usuario.split("[\\t ]");

        if(info.length != 2){
            System.out.println("\nFalha na autenticação. Login ou senha não informados\n");
            return;
        }

        String email = info[0];
        String senha = info[1];
        
        if(autenticador.autenticar(email, senha)){
            System.out.println("\nAutenticação realizada. Login bem-sucedido.\n");
            this.numeroAcessosUsuarios++;
        }
        else
            System.out.println("\nFalha na autenticação. Login ou senha incorretos.\n");
    }

    public int numeroAcessos() {
        return this.numeroAcessosUsuarios;
    }

    public void encerrarPrograma(){
        try{
            gerenteUsuario.encerrar();
            gerenteItem.encerrar();
        } catch(ErroInternoException e){
            System.out.println(e.getMessage());
        }
    }
}
