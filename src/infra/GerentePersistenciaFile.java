package infra;

import java.util.TreeMap;
import business.model.Usuario;
import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    private String filename = "usuarios.txt";
    private TreeMap<String, Usuario> usuarios; 

    public TreeMap<String, Usuario> carregar(){return null;}
    public void salvar(TreeMap<String, Usuario> usuarios){}

    public GerentePersistenciaFile() {
        this.usuarios = new TreeMap<String, Usuario>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
               // System.out.println(line.split("rio: ")[1]);
               String login = line.split("rio: ")[1];
               this.usuarios.put(login, new Usuario(login, login));
            }
        } catch (Exception exception) {
            // TODO REVIEW THIS EXCEPTION
        }
    }

    public void salvar() throws PersistenciaException {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
    
            for (Map.Entry<String, Usuario> entry : this.usuarios.entrySet()) {
                out.write(entry.getKey() + "\t" + entry.getValue() + "\n");
                out.flush();
            }
    
            out.close();  
        } catch(Exception exception) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }

    public void criarUsuario(Usuario usuario) throws PersistenciaException{
        usuarios.put(usuario.getLogin(), usuario);

        this.listarUsuarios();
        try {
            salvar();
        } catch(PersistenciaException exception) {
            throw exception;
        }
    }

    public void listarUsuarios() {
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ". Login: " + entry.getValue());
       }
    }

    public boolean usuarioExistente(String login) {
        return usuarios.containsKey(login);
    }

    public void removeUsuario(String login) throws PersistenciaException {
        this.usuarios.remove(login);
        try {
            salvar();
        } catch(PersistenciaException exception) {
            throw exception;
        }
    }

    public TreeMap<String, Usuario> retornarUsuarios() {
        return this.usuarios;

    }
}