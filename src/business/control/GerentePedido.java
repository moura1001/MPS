package business.control;

import java.util.TreeSet;

import business.model.ListaDeCompra;
import business.model.Entregador;
import business.model.Produto;
import util.LoginEntregadorException;
import util.PersistenciaException;
import infra.GerentePersistencia;
import infra.FabricaGerentePersistencia;

public class GerentePedido {
    
    private static GerentePedido gerente;
    private TreeSet<Entregador> entregadores;
    private GerentePersistencia repositorio;

    private GerentePedido(TreeSet<Entregador> entregadores) {
        this.repositorio = FabricaGerentePersistencia.obterGerentePersistencia("arquivo");
        this.entregadores = entregadores;        
    }

    public void adicionar(Produto produto, String login){

        Entregador entregador = null;
        try{
            entregador = GerenteEntregador.getGerente().getEntregador(login);

        } catch(LoginEntregadorException e){
            System.out.println(e.getMessage());
            return;
        }
        
        if(entregador.getListaDeCompra() == null)
        	entregador.setListaDeCompra(new ListaDeCompra());
        
        ListaDeCompra listaDeCompra = entregador.getListaDeCompra();
        listaDeCompra.getProdutos().add(produto);
        listaDeCompra.setValorTotal(listaDeCompra.getValor() + produto.getValor());
        System.out.println("PEDIDO CADASTRADO");
        
        try {
            this.repositorio.salvar("entregadores", this.entregadores);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarTodos() {
        for (Entregador entregador : entregadores) {
            System.out.print("# ");
            ListaDeCompra listaDeCompra = entregador.getListaDeCompra();
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

        Entregador entregador = null;
        try{
            entregador = GerenteEntregador.getGerente().getEntregador(login);

        } catch(LoginEntregadorException e){
            System.out.println(e.getMessage());
            return;
        }

        entregador.setListaDeCompra(null);

        try {
            this.repositorio.salvar("entregadores", this.entregadores);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void removerProdutoDoPedido(String login, String produto) {

        Entregador entregador = null;
        try{
            entregador = GerenteEntregador.getGerente().getEntregador(login);

        } catch(LoginEntregadorException e){
            System.out.println(e.getMessage());
            return;
        }

        ListaDeCompra listaDeCompra = entregador.getListaDeCompra();
        if (listaDeCompra.getProdutos().size() > 0){
            for (Produto i: listaDeCompra.getProdutos()) {
                if (i.getNome().equals(produto)) {
                    listaDeCompra.getProdutos().remove(i);
                    break;
                }
            }
        }
        
        try {
            this.repositorio.salvar("entregadores", this.entregadores);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static GerentePedido getGerente(){
        if(gerente == null)
            gerente = new GerentePedido(GerenteEntregador.getGerente().getEntregadores());

        return gerente;    
    }
}
