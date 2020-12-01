package business.control;

import java.util.TreeSet;
import business.model.Item;
import util.ItemException;
import util.PersistenciaException;
import util.ErroInternoException;
import infra.GerentePersistencia;
import infra.FabricaGerentePersistencia;
import java.lang.NumberFormatException;

public class GerenteItem{

    private static GerenteItem gerente;
    private TreeSet<Item> itens;
    private GerentePersistencia repositorioItem;

    private GerenteItem() throws ErroInternoException{
        try{
            this.repositorioItem = FabricaGerentePersistencia.obterGerentePersistencia("arquivo");
            this.itens = (TreeSet<Item>) this.repositorioItem.carregar("itens");
            if(this.itens == null)
                this.itens = new TreeSet<Item>();
        } catch(PersistenciaException e){
            throw new ErroInternoException("Erro interno durante a inicialização. Por favor, entre em contato com o administrador");
        }        
    }

	public void adicionar(String item) throws ItemException, ErroInternoException{

        if(item == null)
            throw new ItemException();

        String[] info = item.split("[\\t ]");

        if(info.length != 2)
            throw new ItemException();

        double valor = 0;
        try{  
            valor = Double.parseDouble(info[1]); 
        } 
        catch(NumberFormatException e){ 
            throw new ItemException("Valor incorreto");
        }   
        
        String nome = info[0];

        if(existeItem(nome) != null)
            throw new ItemException("Item já existe");
        
        Item i = new Item(nome, valor);
        this.itens.add(i);
        
        try {
            this.repositorioItem.salvar("itens", this.itens);
            System.out.println(i + " foi adicionado");
        } catch(PersistenciaException e) {
            throw new ErroInternoException("Erro interno ao tentar adicionar usuário. Por favor, entre em contato com o administrador");
        }
    }
    
    public void remover(String nome) throws ItemException, ErroInternoException{
        
        Item item = existeItem(nome);
        
        if(item == null)
            throw new ItemException("Item não existe");
        
        try {
            this.itens.remove(item);
            this.repositorioItem.salvar("itens", this.itens);
            System.out.println(item + " foi removido");
        } catch (PersistenciaException exception) {
            throw new ErroInternoException("Erro interno ao tentar remover item. Por favor, entre em contato com o administrador");
        }
    }

    public void listar(String nome) throws ItemException{
        
        Item item = existeItem(nome);
        
        if(item == null)
            throw new ItemException("Item não existe");

        System.out.println(item);
        
    }

    public void listarTodos(){
        System.out.println("\nItens:");
        for(Item item : this.itens)
            System.out.println(item);
        System.out.println();    
    }

    public void encerrar() throws ErroInternoException{        
        try {
            this.repositorioItem.salvar("itens", this.itens);
        } catch (PersistenciaException e) {
            throw new ErroInternoException("Erro interno durante o encerramento com possíveis perdas de dados. Por favor, entre em contato com o administrador");
        }
    }

    private Item existeItem(String nome){
        for(Item item : itens)
            if(item.getNome().equals(nome))
                return item;
        return null;
    }

    public TreeSet<Item> getItens(){
    	return this.itens;
    }

    public Item getItem(String nome) throws ItemException{
    	Item item = existeItem(nome);
        
        if(item == null)
            throw new ItemException("Item não existe");
    	
        return item;
    }

    public static GerenteItem getGerente(){
        if(gerente == null){
            try{
                gerente = new GerenteItem();
            } catch(ErroInternoException e){
                System.out.println(e.getMessage());
                System.exit(-1);
            }            
        }

        return gerente;    
    }

}