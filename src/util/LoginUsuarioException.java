package util;

public class LoginUsuarioException extends AdicaoUsuarioException{
    
    public LoginUsuarioException(){
        super("mensagem default");
    }
    
    public LoginUsuarioException(String menssagem){
        super(menssagem);
    }
}