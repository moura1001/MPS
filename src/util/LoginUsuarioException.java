package util;

public class LoginUsuarioException extends AdicaoUsuarioException{
    
    public LoginUsuarioException(){
        super("Erro de login");
    }
    
    public LoginUsuarioException(String mensagem){
        super(mensagem);
    }
}