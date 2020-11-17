package infra;

import java.util.TreeMap;
import business.model.Usuario;
import util.PersistenciaException;

public interface GerentePersistencia{
    //public TreeMap<String, Usuario> carregar();
    //public void salvar(TreeMap<String, Usuario> usuarios) throws PersistenciaException;
    public void carregarUsuarios() throws PersistenciaException;
    public void salvarUsuarios() throws PersistenciaException;
    public void criarUsuario(Usuario usuario) throws PersistenciaException;
    public Usuario removerUsuario(String login) throws PersistenciaException;
    public boolean usuarioExistente(String login);
    public TreeMap<String, Usuario> retornarUsuarios();
    public Usuario retornarUsuario(String login);
}