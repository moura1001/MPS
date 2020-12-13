package business.control;
import java.util.TreeSet;
import business.model.Entregador;

public class ListarAlfabeticamente implements ListarEntregadorStrategy{

    public void listar(TreeSet<Entregador> entregadoresSet){

        System.out.println("\nUsuários:");
        for(Entregador entregador : entregadoresSet)
            System.out.println(entregador);
        System.out.println();
    }
}