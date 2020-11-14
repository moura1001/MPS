package business.control;

import java.util.TreeMap;
import java.util.Map;
import business.model.Usuario;

public class GerenteUsuario{

    private TreeMap<String, Usuario> usuarios = new TreeMap<String, Usuario>();

	public void adicionar(String login, String senha){
        usuarios.put(login, new Usuario(login,senha));
    }

    public void remover(String login){
        usuarios.remove(login);
    }

    public void listar(String login){
        System.out.println(usuarios.get(login));
    }

    public void listarTodos(){
        System.out.println("\nUsuários:");
        for(Map.Entry usuario : usuarios.entrySet())
            System.out.println(usuario.getValue());
        System.out.println();    
    }

}