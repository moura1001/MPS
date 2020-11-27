package util;

public class ItemException extends Exception{
    
    public ItemException(){
        super("Item não pode ser nulo nem pode conter espaços em branco");
    }
    
    public ItemException(String mensagem){
        super(mensagem);
    }
}