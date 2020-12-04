package business.model;

import java.io.Serializable;

public class Produto implements Comparable<Produto>, Serializable{
    private String nome;
    private double valor;
    
    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int compareTo(Produto produto){
        return this.nome.compareTo(produto.nome);
    }

    public String toString(){
        return "Produto: " + this.nome;
    }

    public double getValor(){
        return this.valor;
    }
    
    public void setValor(double valor){
    	this.valor = valor;
    }

}