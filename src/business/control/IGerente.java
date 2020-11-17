package business.control;

import util.AdicaoUsuarioException;
import util.LoginUsuarioException;
import util.ErroInternoException;

public interface IGerente {
    public void adicionar(String usuario) throws AdicaoUsuarioException, ErroInternoException;
    public void remover(String login) throws LoginUsuarioException, ErroInternoException;
    public void listar(String login) throws LoginUsuarioException;
    public void listarTodos();
}