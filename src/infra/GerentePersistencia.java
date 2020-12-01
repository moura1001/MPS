package infra;

import java.util.TreeSet;
import util.PersistenciaException;

public interface GerentePersistencia{
    public TreeSet<?> carregar(String nomeArquivo) throws PersistenciaException;
    public void salvar(String nomeArquivo, TreeSet<?> dados) throws PersistenciaException;
}