package business.control;

import util.PagamentoException;

public interface ComandoPagamento{
    public void executar(String arg) throws PagamentoException;
}