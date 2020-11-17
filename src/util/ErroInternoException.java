package util;

public class ErroInternoException extends Exception {
    
    public ErroInternoException(){
        super("Erro interno. Por favor, entre em contato com o administrador");
    }
    
    public ErroInternoException(String mensagem){
        super(mensagem);
    }
}