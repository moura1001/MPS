package util;

public class AdicaoUsuarioException extends Exception{
    
    public AdicaoUsuarioException(){
        super("Login e senha não podem ser nulos nem podem conter espaços em branco");
        //super("Login e senha não podem ser nulos nem podem conter espaços em branco." +
        //"\nData de nascimento deve seguir o formato DD/MM/AAAA");
    }
    
    public AdicaoUsuarioException(String mensagem){
        super(mensagem);
    }
}