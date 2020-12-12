package business.model;

import business.model.ListaDeCompra;
import java.lang.Comparable;
import java.io.Serializable;

public class Entregador implements Comparable<Entregador>, Serializable{

    private String login;
    private String senha;
    private Data dataNascimento;
    
    private ListaDeCompra listaDeCompra;

    public Entregador(String login, String senha){
        this.login = login;
        this.senha = senha;
        dataNascimento = new Data();
    }

    public Entregador(String login, String senha, Data data, ListaDeCompra listaDeCompra){
        this.login = login;
        this.senha = senha;
        this.dataNascimento = data;
        this.listaDeCompra = listaDeCompra;
    }

    public int compareTo(Entregador entregador){
        return this.login.compareTo(entregador.login);
    }

    public String toString(){
        return "Entregador: " + this.login;
    }

    public String getLogin(){
        return this.login;
    }

    public String getSenha(){
        return this.senha;
    }

    public Data getData(){
        return this.dataNascimento;
    }

    public ListaDeCompra getListaDeCompra(){
        return this.listaDeCompra;
    }

    public void setData(Data data){
        this.dataNascimento = data;
    }

    public void setListaDeCompra(ListaDeCompra listaDeCompra) {
        this.listaDeCompra = listaDeCompra;
    }
}