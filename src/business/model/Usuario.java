package business.model;

import java.lang.Comparable;

public class Usuario implements Comparable<Usuario>{

    private String login;
    private String senha;
    private Data dataNascimento;

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
        dataNascimento = new Data();
    }

    public Usuario(String login, String senha, Data data){
        this.login = login;
        this.senha = senha;
        this.dataNascimento = data;
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

    public void setData(Data data){
        this.dataNascimento = data;
    }
}