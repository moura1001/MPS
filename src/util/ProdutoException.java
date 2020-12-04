package util;

public class ProdutoException extends Exception{
    
    public ProdutoException(){
        super("Produto não pode ser nulo nem pode conter espaços em branco");
    }
    
    public ProdutoException(String mensagem){
        super(mensagem);
    }
}