package business.control;

import business.model.Entregador;
import java.util.TreeSet;

public interface ListarEntregadorStrategy{
   public void listar(TreeSet<Entregador> entregadoresSet);
}