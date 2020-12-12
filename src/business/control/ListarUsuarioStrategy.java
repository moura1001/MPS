package business.control;

import business.model.Usuario;
import java.util.TreeSet;

abstract class ListarUsuarioStrategy{
   abstract void listar(TreeSet<Usuario> usuariosSet);
}