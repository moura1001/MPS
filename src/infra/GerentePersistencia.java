package infra;

import java.util.TreeMap;
import business.model.Usuario;
import util.PersistenciaException;

public interface GerentePersistencia{
    public TreeMap<String, Usuario> carregarUsuarios() throws PersistenciaException;
    public void salvarUsuarios(TreeMap<String, Usuario> usuarios) throws PersistenciaException;
}