package util;

public class PersistenciaException extends Exception{
    
    public PersistenciaException(){
        super("Erro de persistência");
    }
    
    public PersistenciaException(String mensagem){
        super(mensagem);
    }
}