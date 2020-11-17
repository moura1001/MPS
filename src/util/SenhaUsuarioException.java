package util;

public class SenhaUsuarioException extends AdicaoUsuarioException{
    
    public SenhaUsuarioException(){
        super("mensagem default");
    }
    
    public SenhaUsuarioException(String mensagem){
        super(mensagem);
    }
}