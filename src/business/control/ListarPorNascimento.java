package business.control;
import java.util.TreeSet;
import business.model.Entregador;

public class ListarPorNascimento extends ListarEntregadorStrategy{

    public void listar(TreeSet<Entregador> entregadoresSet){
        TreeSet<Entregador> entregadores = new TreeSet<Entregador>(new ComparadorData());

        for(Entregador entregador : entregadoresSet)
            entregadores.add(entregador);

        System.out.println("\nUsuários:");
        for(Entregador entregador : entregadores)
            System.out.println(entregador + "\t" + entregador.getData());
        System.out.println();
    }
}