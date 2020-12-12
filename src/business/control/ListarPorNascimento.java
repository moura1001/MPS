package business.control;
import java.util.TreeSet;
import business.model.Usuario;

public class ListarPorNascimento extends ListarUsuarioStrategy{

    public void listar(TreeSet<Usuario> usuariosSet){
        TreeSet<Usuario> usuarios = new TreeSet<Usuario>(new ComparadorData());

        for(Usuario usuario : usuariosSet)
            usuarios.add(usuario);

        System.out.println("\nUsuários:");
        for(Usuario usuario : usuarios)
            System.out.println(usuario + "\t" + usuario.getData());
        System.out.println();
    }
}