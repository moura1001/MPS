package util;

public class SenhaEntregadorException extends AdicaoEntregadorException{
    
    public SenhaEntregadorException(){
        super("Erro de senha");
    }
    
    public SenhaEntregadorException(String mensagem){
        super(mensagem);
    }
}