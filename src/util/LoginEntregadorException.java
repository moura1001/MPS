package util;

public class LoginEntregadorException extends AdicaoEntregadorException{
    
    public LoginEntregadorException(){
        super("Erro de login");
    }
    
    public LoginEntregadorException(String mensagem){
        super(mensagem);
    }
}