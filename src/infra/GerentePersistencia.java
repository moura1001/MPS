package infra;

import java.util.TreeMap;
import business.model.Usuario;

public interface GerentePersistencia{
    public TreeMap<String, Usuario> carregar();
    public void salvar(TreeMap<String, Usuario> usuarios);
    public void criarUsuario(Usuario usuario);
    public void removeUsuario(String login);
    public boolean usuarioExistente(String login);
    public TreeMap<String, Usuario> retornarUsuarios();
}