package infra;

import java.io.*;
import java.util.TreeSet;
import java.util.*;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    
    public TreeSet<?> carregar(String nomeArquivo) throws PersistenciaException{
        TreeSet<?> dados = null;
        try{
            
        	FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            dados = (TreeSet<?>) ois.readObject();
 
            ois.close();
            fis.close();
        	
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }

        return dados;
    }

    public void salvar(String nomeArquivo, TreeSet<?> dados) throws PersistenciaException {
        try {
        	
        	FileOutputStream fos = new FileOutputStream(nomeArquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(dados);
            
            oos.close();
            fos.close();
        	
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }
}