package business.control;

import business.model.Entregador;
import java.util.TreeSet;

abstract class ListarEntregadorStrategy{
   abstract void listar(TreeSet<Entregador> entregadoresSet);
}