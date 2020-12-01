package util;

public class PagamentoException extends Exception{
    
    public PagamentoException(){
        super("Erro. Pagamento não aprovado.");
    }
    
    public PagamentoException(String mensagem){
        super(mensagem);
    }
}