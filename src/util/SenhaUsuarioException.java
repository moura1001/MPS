package util;

public class SenhaUsuarioException extends Exception{
    
    public SenhaUsuarioException(){
        super("mensagem default");
    }
    
    public SenhaUsuarioException(String menssagem){
        super(menssagem);
    }
}