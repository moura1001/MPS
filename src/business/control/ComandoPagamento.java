package business.control;

import util.PagamentoException;

public interface ComandoPagamento{
    public void executar(Object[] arg) throws PagamentoException;
}