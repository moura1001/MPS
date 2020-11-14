package util;

public class LoginUsuarioException extends Exception{
    
    public LoginUsuarioException(){
        super("mensagem default");
    }
    
    public LoginUsuarioException(String menssagem){
        super(menssagem);
    }
}