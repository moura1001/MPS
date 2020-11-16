package util;

public class AdicaoUsuarioException extends Exception{
    
    public AdicaoUsuarioException(){
        super("Login e senha não podem ser nulos nem podem conter espaços em branco");
    }
    
    public AdicaoUsuarioException(String menssagem){
        super(menssagem);
    }
}