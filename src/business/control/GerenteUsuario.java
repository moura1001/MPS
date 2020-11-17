package business.control;

import java.util.TreeMap;
import java.util.Map;
import business.model.Usuario;
import util.LoginUsuarioException;
import util.SenhaUsuarioException;
import util.AdicaoUsuarioException;
import util.PersistenciaException;
import util.ErroInternoException;
import infra.GerentePersistencia;
import infra.GerentePersistenciaFile;

public class GerenteUsuario implements IGerente{
    private TreeMap<String, Usuario> usuarios;
    private GerentePersistencia repositorioUsuario;

    public GerenteUsuario() throws ErroInternoException{
        try{
            this.repositorioUsuario = new GerentePersistenciaFile();
            this.usuarios = this.repositorioUsuario.carregarUsuarios();
        } catch(PersistenciaException e){
            throw new ErroInternoException("Erro interno durante a inicialização. Por favor, entre em contato com o administrador");
        }        
    }

	public void adicionar(String usuario) throws AdicaoUsuarioException, ErroInternoException{

        if(usuario == null)
            throw new AdicaoUsuarioException();

        String[] info = usuario.split("[\\t ]");

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

        if(this.usuarios.containsKey(login))
            throw new LoginUsuarioException("Login já existe");    

        if(senha.length() < 8 || senha.length() > 12)
            throw new SenhaUsuarioException("Senha deve conter entre 8 e 12 caracters");

        if(!senha.matches("(.*\\d.*){2,}"))
            throw new SenhaUsuarioException("Senha deve conter pelo menos 2 números");
        
        Usuario u = new Usuario(login, senha);
        this.usuarios.put(u.getLogin(), u);
        
        try {
            this.repositorioUsuario.salvarUsuarios(this.usuarios);
            System.out.println(u + " foi adicionado");
        } catch(PersistenciaException e) {
            throw new ErroInternoException("Erro interno ao tentar adicionar usuário. Por favor, entre em contato com o administrador");
        }
    }
    
    public void remover(String login) throws LoginUsuarioException, ErroInternoException{
        if(!this.usuarios.containsKey(login))
            throw new LoginUsuarioException("Login não existe");
        
        try {
            Usuario usuario = this.usuarios.remove(login);
            this.repositorioUsuario.salvarUsuarios(this.usuarios);
            System.out.println(usuario + " foi removido");
        } catch (PersistenciaException exception) {
            throw new ErroInternoException("Erro interno ao tentar remover usuário. Por favor, entre em contato com o administrador");
        }
    }

    public void listar(String login) throws LoginUsuarioException{
        if(!this.usuarios.containsKey(login))
            throw new LoginUsuarioException("Login não existe");

        Usuario usuario = this.usuarios.get(login);
        System.out.println(usuario);
        
    }

    public void listarTodos(){
        System.out.println("\nUsuários:");
        for(Map.Entry usuario : this.usuarios.entrySet())
            System.out.println(usuario.getValue());
        System.out.println();    
    }

    public void encerrar() throws ErroInternoException{        
        try {
            this.repositorioUsuario.salvarUsuarios(this.usuarios);
        } catch (PersistenciaException e) {
            throw new ErroInternoException("Erro interno durante o encerramento com possíveis perdas de dados. Por favor, entre em contato com o administrador");
        }
    }

}