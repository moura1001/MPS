package infra;

import java.util.TreeMap;
import business.model.Usuario;

public class GerentePersistenciaFile implements GerentePersistencia{
    public TreeMap<String, Usuario> carregar(){return null;}
    public void salvar(TreeMap<String, Usuario> usuarios){}
}