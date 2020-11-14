package infra;

import java.util.TreeMap;
import business.model.Usuario;

public interface GerentePersistencia{
    public TreeMap<String, Usuario> carregar();
    public void salvar(TreeMap<String, Usuario> usuarios);
}