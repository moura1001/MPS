package business.model;

import java.io.Serializable;
import java.util.TreeSet;

public class Pedido implements Serializable{
    private TreeSet<Produto> produtos;
    private double valorTotal;
    
    public Pedido() {
        this.produtos = new TreeSet<Produto>();
	    this.valorTotal = 0;
    }

    public Pedido(TreeSet<Produto> produtos, double valorTotal) {
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
