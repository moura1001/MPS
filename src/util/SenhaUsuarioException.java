package util;

public class SenhaUsuarioException extends AdicaoUsuarioException{
    
    public SenhaUsuarioException(){
        super("Erro de senha");
    }
    
    public SenhaUsuarioException(String mensagem){
        super(mensagem);
    }
}