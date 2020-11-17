package util;

public class ErroInternoException extends AdicaoUsuarioException {
    
    public ErroInternoException(){
        super("Erro interno");
    }
    
    public ErroInternoException(String mensagem){
        super(mensagem);
    }
}