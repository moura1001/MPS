package business.control;

import util.AdicaoUsuarioException;
import util.LoginUsuarioException;

public interface IGerente {
    public void adicionar(String usuario) throws AdicaoUsuarioException;
    public void remover(String login) throws LoginUsuarioException;
    public void listar(String login) throws LoginUsuarioException;
    public void listarTodos();
}