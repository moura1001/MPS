package business.model;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable{
    private String nome;
    private double valor;
    
    public Item(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int compareTo(Item item){
        return this.nome.compareTo(item.nome);
    }

    public String toString(){
        return "Item: " + this.nome;
    }

    public double getValor(){
        return this.valor;
    }
    
    public void setValor(double valor){
    	this.valor = valor;
    }

}