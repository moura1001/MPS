package business.control;

import util.AdicaoEntregadorException;
import util.LoginEntregadorException;
import util.ErroInternoException;

public interface IGerente {
    public void adicionar(String entregador) throws AdicaoEntregadorException, ErroInternoException;
    public void remover(String login) throws LoginEntregadorException, ErroInternoException;
    public void listar(String login) throws LoginEntregadorException;
    public void listarTodosPorOrdemAlfabetica();
    public void listarTodosPorOrdemDataDeNascimento();
}