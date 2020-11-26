package infra;

import java.io.*;
import java.util.TreeSet;
import business.model.Usuario;
import business.model.Data;
import business.model.Pedido;
import java.util.ArrayList;
import java.util.*;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    private String filename = "usuarios";

    public TreeSet<Usuario> carregarUsuarios() throws PersistenciaException{
        TreeSet<Usuario> usuarios = new TreeSet<Usuario>();
        try{
            
        	FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            usuarios = (TreeSet<Usuario>) ois.readObject();
 
            ois.close();
            fis.close();
        	
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }

        return usuarios;
    }

    public void salvarUsuarios(TreeSet<Usuario> usuarios) throws PersistenciaException {
        try {
        	
        	FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(usuarios);
            
            oos.close();
            fos.close();
        	
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }

}