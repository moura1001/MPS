package business.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import business.model.Pedido;
import business.model.Usuario;
import business.model.Item;
import util.LoginUsuarioException;
import util.PersistenciaException;
import util.ErroInternoException;
import infra.GerentePersistencia;
import infra.FabricaGerentePersistencia;

public class GerentePedido {
    
    private static GerentePedido gerente;
    private TreeSet<Usuario> usuarios;
    private GerentePersistencia repositorio;

    private GerentePedido(TreeSet<Usuario> usuarios) {
        this.repositorio = FabricaGerentePersistencia.obterGerentePersistencia("arquivo");
        this.usuarios = usuarios;        
    }

    public void adicionar(Item item, String login){

        Usuario usuario = null;
        try{
            usuario = GerenteUsuario.getGerente().getUsuario(login);

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
            return;
        }
        
        if(usuario.getPedido() == null)
        	usuario.setPedido(new Pedido());
        
        Pedido pedido = usuario.getPedido();
        pedido.getItens().add(item);
        pedido.setValorTotal(pedido.getValor() + item.getValor());
        System.out.println("PEDIDO CADASTRADO");
        
        try {
            this.repositorio.salvar("usuarios", this.usuarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarTodos() {
        for (Usuario usuario : usuarios) {
            System.out.print("# ");
            Pedido pedido = usuario.getPedido();
            if(pedido == null)
                break;
            for(Item item : pedido.getItens()){
                System.out.print("item: " + item + " ");
                System.out.print("valor: " + item.getValor() + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public void removerPedido(String login) {

        Usuario usuario = null;
        try{
            usuario = GerenteUsuario.getGerente().getUsuario(login);

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
            return;
        }

        usuario.setPedido(null);

        try {
            this.repositorio.salvar("usuarios", this.usuarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void removerItemDoPedido(String login, String item) {

        Usuario usuario = null;
        try{
            usuario = GerenteUsuario.getGerente().getUsuario(login);

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
            return;
        }

        Pedido pedido = usuario.getPedido();
        if (pedido.getItens().size() > 0){
            for (Item i: pedido.getItens()) {
                if (i.getNome().equals(item)) {
                    pedido.getItens().remove(i);
                    break;
                }
            }
        }
        
        try {
            this.repositorio.salvar("usuarios", this.usuarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static GerentePedido getGerente(){
        if(gerente == null)
            gerente = new GerentePedido(GerenteUsuario.getGerente().getUsuarios());

        return gerente;    
    }
}
