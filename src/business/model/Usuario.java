package business.model;

import business.model.Pedido;
import java.util.ArrayList;
import java.lang.Comparable;
import java.io.Serializable;

public class Usuario implements Comparable<Usuario>, Serializable{

    private String login;
    private String senha;
    private Data dataNascimento;



    private ArrayList<Pedido> pedidos;

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
        dataNascimento = new Data();
        this.pedidos = new ArrayList<Pedido>();
    }

    public Usuario(String login, String senha, Data data, ArrayList<Pedido> pedidos){
        this.login = login;
        this.senha = senha;
        this.dataNascimento = data;
        this.pedidos = pedidos;
    }

    public int compareTo(Usuario usuario){
        return this.login.compareTo(usuario.login);
    }

    public String toString(){
        return "Usuário: " + this.login;
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

    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void setData(Data data){
        this.dataNascimento = data;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}