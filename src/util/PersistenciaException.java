package util;

public class PersistenciaException extends Exception{
    
    public PersistenciaException(){
        super("mensagem default");
    }
    
    public PersistenciaException(String mensagem){
        super(mensagem);
    }
}