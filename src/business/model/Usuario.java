package business.model;

import business.model.Pedido;
import java.lang.Comparable;
import java.io.Serializable;

public class Usuario implements Comparable<Usuario>, Serializable{

    private String login;
    private String senha;
    private Data dataNascimento;
    
    private Pedido pedido;

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
        dataNascimento = new Data();
    }

    public Usuario(String login, String senha, Data data, Pedido pedido){
        this.login = login;
        this.senha = senha;
        this.dataNascimento = data;
        this.pedido = pedido;
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

    public Pedido getPedido(){
        return this.pedido;
    }

    public void setData(Data data){
        this.dataNascimento = data;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}