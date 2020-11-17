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
    private TreeMap<String, Usuario> usuarios;

    public void carregarUsuarios() throws PersistenciaException{
        this.usuarios = new TreeMap<String, Usuario>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
               String[] usuario = line.split("\t");
               String login = usuario[0];
               String senha = usuario[1].split("\n")[0];
               this.usuarios.put(login, new Usuario(login, senha));
            }
        } catch (IOException exception) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }
    }

    public void salvarUsuarios() throws PersistenciaException {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
    
            for(Map.Entry<String, Usuario> entry : this.usuarios.entrySet()){
                Usuario usuario = entry.getValue();
                String login = usuario.getLogin();
                String senha = usuario.getSenha();
                out.write(login + "\t" + senha + "\n");
                //out.write(entry.getKey() + "\t" + entry.getValue() + "\n");
                out.flush();
            }
    
            out.close();  
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }

    public void criarUsuario(Usuario usuario) throws PersistenciaException{
        usuarios.put(usuario.getLogin(), usuario);

        //this.listarUsuarios();
        try {
            salvarUsuarios();
        } catch(PersistenciaException exception) {
            throw exception;
        }
    }

    public void listarUsuarios() {
        for(Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ". Login: " + entry.getValue());
       }
    }

    public boolean usuarioExistente(String login) {
        return usuarios.containsKey(login);
    }

    public Usuario removerUsuario(String login) throws PersistenciaException {
        Usuario usuario = this.usuarios.remove(login);
        try {
            salvarUsuarios();
        } catch(PersistenciaException exception) {
            throw exception;
        }
        return usuario;
    }

    public TreeMap<String, Usuario> retornarUsuarios() {
        return this.usuarios;
    }

    public Usuario retornarUsuario(String login){
        return this.usuarios.get(login);
    }
}