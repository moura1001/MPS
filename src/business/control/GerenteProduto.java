package business.control;

import java.util.TreeSet;
import business.model.Produto;
import util.ProdutoException;
import util.PersistenciaException;
import util.ErroInternoException;
import infra.GerentePersistencia;
import infra.FabricaGerentePersistencia;
import java.lang.NumberFormatException;

public class GerenteProduto{

    private static GerenteProduto gerente;
    private TreeSet<Produto> produtos;
    private GerentePersistencia repositorioProduto;

    private GerenteProduto() throws ErroInternoException{
        try{
            this.repositorioProduto = FabricaGerentePersistencia.obterGerentePersistencia("arquivo");
            this.produtos = (TreeSet<Produto>) this.repositorioProduto.carregar("produtos");
            if(this.produtos == null)
                this.produtos = new TreeSet<Produto>();
        } catch(PersistenciaException e){
            throw new ErroInternoException("Erro interno durante a inicialização. Por favor, entre em contato com o administrador");
        }        
    }

	public void adicionar(String produto) throws ProdutoException, ErroInternoException{

        if(produto == null)
            throw new ProdutoException();

        String[] info = produto.split("[\\t ]");

        if(info.length != 2)
            throw new ProdutoException();

        double valor = 0;
        try{  
            valor = Double.parseDouble(info[1]); 
        } 
        catch(NumberFormatException e){ 
            throw new ProdutoException("Valor incorreto");
        }   
        
        String nome = info[0];

        if(existeProduto(nome) != null)
            throw new ProdutoException("Produto já existe");
        
        Produto i = new Produto(nome, valor);
        this.produtos.add(i);
        
        try {
            this.repositorioProduto.salvar("produtos", this.produtos);
            System.out.println(i + " foi adicionado");
        } catch(PersistenciaException e) {
            throw new ErroInternoException("Erro interno ao tentar adicionar produto. Por favor, entre em contato com o administrador");
        }
    }
    
    public void remover(String nome) throws ProdutoException, ErroInternoException{
        
        Produto produto = existeProduto(nome);
        
        if(produto == null)
            throw new ProdutoException("Produto não existe");
        
        try {
            this.produtos.remove(produto);
            this.repositorioProduto.salvar("produtos", this.produtos);
            System.out.println(produto + " foi removido");
        } catch (PersistenciaException exception) {
            throw new ErroInternoException("Erro interno ao tentar remover produto. Por favor, entre em contato com o administrador");
        }
    }

    public void listar(String nome) throws ProdutoException{
        
        Produto produto = existeProduto(nome);
        
        if(produto == null)
            throw new ProdutoException("Produto não existe");

        System.out.println(produto);
        
    }

    public void listarTodos(){
        System.out.println("\nProdutos:");
        for(Produto produto : this.produtos)
            System.out.println(produto);
        System.out.println();    
    }

    public void encerrar() throws ErroInternoException{        
        try {
            this.repositorioProduto.salvar("produtos", this.produtos);
        } catch (PersistenciaException e) {
            throw new ErroInternoException("Erro interno durante o encerramento com possíveis perdas de dados. Por favor, entre em contato com o administrador");
        }
    }

    private Produto existeProduto(String nome){
        for(Produto produto : produtos)
            if(produto.getNome().equals(nome))
                return produto;
        return null;
    }

    public TreeSet<Produto> getProdutos(){
    	return this.produtos;
    }

    public Produto getProduto(String nome) throws ProdutoException{
    	Produto produto = existeProduto(nome);
        
        if(produto == null)
            throw new ProdutoException("Produto não existe");
    	
        return produto;
    }

    public static GerenteProduto getGerente(){
        if(gerente == null){
            try{
                gerente = new GerenteProduto();
            } catch(ErroInternoException e){
                System.out.println(e.getMessage());
                System.exit(-1);
            }            
        }

        return gerente;    
    }

}