package business.model;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable{
    private String nome;
    
    public Item(String nome){
        this.nome = nome;
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

}