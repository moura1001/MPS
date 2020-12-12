package util;

public class DataEntregadorException extends AdicaoEntregadorException{
    
    public DataEntregadorException(){
        super("Formato de data errado");
    }
    
    public DataEntregadorException(String mensagem){
        super(mensagem);
    }
}