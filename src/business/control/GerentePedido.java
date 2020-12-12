package business.control;

import java.util.TreeSet;

import business.model.ListaDeCompra;
import business.model.Usuario;
import business.model.Produto;
import util.LoginUsuarioException;
import util.PersistenciaException;
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

    public void adicionar(Produto produto, String login){

        Usuario usuario = null;
        try{
            usuario = GerenteUsuario.getGerente().getUsuario(login);

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
            return;
        }
        
        if(usuario.getListaDeCompra() == null)
        	usuario.setListaDeCompra(new ListaDeCompra());
        
        ListaDeCompra listaDeCompra = usuario.getListaDeCompra();
        listaDeCompra.getProdutos().add(produto);
        listaDeCompra.setValorTotal(listaDeCompra.getValor() + produto.getValor());
        System.out.println("PEDIDO CADASTRADO");
        
        try {
            this.repositorio.salvar("usuarios", this.usuarios);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarTodos() {
        for (Usuario usuario : usuarios) {
            System.out.print("# ");
            ListaDeCompra listaDeCompra = usuario.getListaDeCompra();
            if(listaDeCompra == null)
                break;
            for(Produto produto : listaDeCompra.getProdutos()){
                System.out.print("produto: " + produto + " ");
                System.out.print("valor: " + produto.getValor() + " ");
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

        usuario.setListaDeCompra(null);

        try {
            this.repositorio.salvar("usuarios", this.usuarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void removerProdutoDoPedido(String login, String produto) {

        Usuario usuario = null;
        try{
            usuario = GerenteUsuario.getGerente().getUsuario(login);

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
            return;
        }

        ListaDeCompra listaDeCompra = usuario.getListaDeCompra();
        if (listaDeCompra.getProdutos().size() > 0){
            for (Produto i: listaDeCompra.getProdutos()) {
                if (i.getNome().equals(produto)) {
                    listaDeCompra.getProdutos().remove(i);
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
