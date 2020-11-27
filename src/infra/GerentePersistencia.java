package infra;

import java.util.TreeSet;
import business.model.Usuario;
import business.model.Item;
import util.PersistenciaException;

public interface GerentePersistencia{
    public TreeSet<Usuario> carregarUsuarios() throws PersistenciaException;
    public void salvarUsuarios(TreeSet<Usuario> usuarios) throws PersistenciaException;
    public TreeSet<Item> carregarItens() throws PersistenciaException;
    public void salvarItens(TreeSet<Item> itens) throws PersistenciaException;
}