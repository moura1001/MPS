package util;

public class PersistenciaException extends Exception{
    
    public PersistenciaException(){
        super("mensagem default");
    }
    
    public PersistenciaException(String menssagem){
        super(menssagem);
    }
}