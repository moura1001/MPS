package util;

public class AdicaoEntregadorException extends Exception{
    
    public AdicaoEntregadorException(){
        super("Login e senha não podem ser nulos nem podem conter espaços em branco");
        //super("Login e senha não podem ser nulos nem podem conter espaços em branco." +
        //"\nData de nascimento deve seguir o formato DD/MM/AAAA");
    }
    
    public AdicaoEntregadorException(String mensagem){
        super(mensagem);
    }
}