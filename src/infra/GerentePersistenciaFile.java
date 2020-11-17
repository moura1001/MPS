package infra;

import java.util.TreeMap;
import business.model.Usuario;
import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    private String filename = "usuarios.txt";

    public TreeMap<String, Usuario> carregarUsuarios() throws PersistenciaException{
        TreeMap<String, Usuario> usuarios = new TreeMap<String, Usuario>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
               String[] usuario = line.split("\t");
               String login = usuario[0];
               String senha = usuario[1].split("\n")[0];
               usuarios.put(login, new Usuario(login, senha));
            }
        } catch (IOException exception) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }

        return usuarios;
    }

    public void salvarUsuarios(TreeMap<String, Usuario> usuarios) throws PersistenciaException {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
    
            for(Map.Entry<String, Usuario> entry : usuarios.entrySet()){
                Usuario usuario = entry.getValue();
                String login = usuario.getLogin();
                String senha = usuario.getSenha();
                out.write(login + "\t" + senha + "\n");
                out.flush();
            }
    
            out.close();  
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }
}