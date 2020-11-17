package infra;

import java.util.TreeMap;
import business.model.Usuario;
import java.util.*;

public class GerentePersistenciaFile implements GerentePersistencia{
    private TreeMap<String, Usuario> usuarios = new TreeMap<String, Usuario>();

    public TreeMap<String, Usuario> carregar(){return null;}
    public void salvar(TreeMap<String, Usuario> usuarios){}

    public void criarUsuario(Usuario usuario) {
        System.out.println("Repositorio");
        usuarios.put(usuario.getLogin(), usuario);

        this.listarUsuarios();
    }

    public void listarUsuarios() {
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ". Login: " + entry.getValue());
       }
    }

    public boolean usuarioExistente(String login) {
        return usuarios.containsKey(login);
    }

    public void removeUsuario(String login) {
        usuarios.remove(login);
    }

    public TreeMap<String, Usuario> retornarUsuarios() {
        return this.usuarios;
    }
}