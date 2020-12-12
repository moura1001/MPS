package business.control;
import java.util.TreeSet;
import business.model.Usuario;

public class ListarAlfabeticamente extends ListarUsuarioStrategy{

    public void listar(TreeSet<Usuario> usuariosSet){

        System.out.println("\nUsuários:");
        for(Usuario usuario : usuariosSet)
            System.out.println(usuario);
        System.out.println();
    }
}