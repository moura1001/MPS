package util;

public class DataUsuarioException extends AdicaoUsuarioException{
    
    public DataUsuarioException(){
        super("Formato de data errado");
    }
    
    public DataUsuarioException(String mensagem){
        super(mensagem);
    }
}