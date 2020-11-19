package infra;

import java.util.TreeSet;
import business.model.Usuario;
import util.PersistenciaException;

public interface GerentePersistencia{
    public TreeSet<Usuario> carregarUsuarios() throws PersistenciaException;
    public void salvarUsuarios(TreeSet<Usuario> usuarios) throws PersistenciaException;
}