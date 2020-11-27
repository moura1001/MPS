package infra;

import java.io.*;
import java.util.TreeSet;
import business.model.Item;
import business.model.Usuario;
import business.model.Data;
import business.model.Pedido;
import java.util.ArrayList;
import java.util.*;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    private String arquivoUsuarios = "usuarios";
    private String arquivoItens = "itens";

    public TreeSet<Usuario> carregarUsuarios() throws PersistenciaException{
        TreeSet<Usuario> usuarios = new TreeSet<Usuario>();
        try{
            
        	FileInputStream fis = new FileInputStream(arquivoUsuarios);
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
        	
        	FileOutputStream fos = new FileOutputStream(arquivoUsuarios);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(usuarios);
            
            oos.close();
            fos.close();
        	
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }

    public TreeSet<Item> carregarItens() throws PersistenciaException{
        TreeSet<Item> itens = new TreeSet<Item>();
        try{
            
        	FileInputStream fis = new FileInputStream(arquivoItens);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            itens = (TreeSet<Item>) ois.readObject();
 
            ois.close();
            fis.close();
        	
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }

        return itens;
    }

    public void salvarItens(TreeSet<Item> itens) throws PersistenciaException {
        try {
        	
        	FileOutputStream fos = new FileOutputStream(arquivoItens);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(itens);
            
            oos.close();
            fos.close();
        	
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }

}