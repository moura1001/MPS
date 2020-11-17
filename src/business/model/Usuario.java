package business.model;

import java.lang.Comparable;

public class Usuario implements Comparable<Usuario>{

    private String login;
    private String senha;

    public Usuario(){
        login = "default";
        senha = "12345678";
    }

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
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

}