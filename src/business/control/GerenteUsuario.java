package business.control;

import java.util.TreeMap;
import java.util.Map;
import business.model.Usuario;
import util.LoginUsuarioException;
import util.SenhaUsuarioException;
import util.AdicaoUsuarioException;

public class GerenteUsuario implements IGerente{

    private TreeMap<String, Usuario> usuarios = new TreeMap<String, Usuario>();

	public void adicionar(String usuario) throws AdicaoUsuarioException{

        if(usuario == null)
            throw new AdicaoUsuarioException();

        String[] info = usuario.split(" ");

        if(info.length != 2)
            throw new AdicaoUsuarioException();
        
        String login = info[0];
        String senha = info[1];
        
        if(login.matches("^$") || senha.matches("^$"))
            throw new AdicaoUsuarioException();

        if(login.length() > 20)
            throw new LoginUsuarioException("Login não pode ultrapassar 20 caracters");

        if(login.matches(".*\\d.*"))
            throw new LoginUsuarioException("Login não pode conter números");

        if(usuarios.containsKey(login))
            throw new LoginUsuarioException("Login já existe");    

        if(senha.length() < 8 || senha.length() > 12)
            throw new SenhaUsuarioException("Senha deve conter entre 8 e 12 caracters");

        if(!senha.matches("(.*\\d.*){2,}"))
            throw new SenhaUsuarioException("Senha deve conter pelo menos 2 números");
        
        usuarios.put(login, new Usuario(login,senha));
    }

    public void remover(String login) throws LoginUsuarioException{
        if(!usuarios.containsKey(login))
            throw new LoginUsuarioException("Login não existe");

        usuarios.remove(login);
    }

    public void listar(String login) throws LoginUsuarioException{
        if(!usuarios.containsKey(login))
            throw new LoginUsuarioException("Login não existe");

        System.out.println(usuarios.get(login));
    }

    public void listarTodos(){
        System.out.println("\nUsuários:");
        for(Map.Entry usuario : usuarios.entrySet())
            System.out.println(usuario.getValue());
        System.out.println();    
    }

}