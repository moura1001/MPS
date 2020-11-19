package infra;

import java.util.TreeSet;
import business.model.Usuario;
import business.model.Data;
import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    private String filename = "usuarios.txt";

    public TreeSet<Usuario> carregarUsuarios() throws PersistenciaException{
        TreeSet<Usuario> usuarios = new TreeSet<Usuario>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] usuario = line.split("\t");
                String login = usuario[0];
                String senha = usuario[1];
                String data = usuario[2].split("\n")[0];
                int dia = Integer.parseInt(data.split("/")[0]);
                int mes = Integer.parseInt(data.split("/")[1]);
                int ano = Integer.parseInt(data.split("/")[2]);
                //Data d = new Data(dia,mes,ano);
                Usuario u = new Usuario(login, senha, new Data(dia,mes,ano));
                usuarios.add(u);
            }
        } catch (IOException exception) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }

        return usuarios;
    }

    public void salvarUsuarios(TreeSet<Usuario> usuarios) throws PersistenciaException {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
    
            for(Usuario usuario : usuarios){
                String login = usuario.getLogin();
                String senha = usuario.getSenha();
                String data = usuario.getData().toString();
                out.write(login + "\t" + senha + "\t" + data + "\n");
                out.flush();
            }
    
            out.close();  
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }
}