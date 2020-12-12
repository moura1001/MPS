package business.model;

import java.io.Serializable;
import java.util.TreeSet;

public class ListaDeCompra implements Serializable{
    private TreeSet<Produto> produtos;
    private double valorTotal;
    
    public ListaDeCompra() {
        this.produtos = new TreeSet<Produto>();
	    this.valorTotal = 0;
    }

    public ListaDeCompra(TreeSet<Produto> produtos, double valorTotal) {
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }
    
    public TreeSet<Produto> getProdutos(){
        return this.produtos;
    }
    
    public double getValor() {
        return valorTotal;
    }

    public void setValorTotal(double valor){
        this.valorTotal = valor;
    } 
}
