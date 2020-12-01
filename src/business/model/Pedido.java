package business.model;

import java.io.Serializable;
import java.util.TreeSet;

public class Pedido implements Serializable{
    private TreeSet<Item> itens;
    private double valorTotal;
    
    public Pedido() {
        this.itens = new TreeSet<Item>();
	    this.valorTotal = 0;
    }

    public Pedido(TreeSet<Item> itens, double valorTotal) {
        this.itens = itens;
        this.valorTotal = valorTotal;
    }
    
    public TreeSet<Item> getItens(){
        return this.itens;
    }
    
    public double getValor() {
        return valorTotal;
    }

    public void setValorTotal(double valor){
        this.valorTotal = valor;
    } 
}
