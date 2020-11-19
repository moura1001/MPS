package business.control;

import java.util.Comparator;
import business.model.Usuario;
import business.model.Data;

public class ComparadorData implements Comparator<Usuario>{

    public int compare(Usuario u1, Usuario u2){
        Data data1 = u1.getData();
        Data data2 = u2.getData();

        int ano = data1.getAno() - data2.getAno();
        int mes = data1.getMes() - data2.getMes();
        int dia = data1.getDia() - data2.getDia();

        if(ano >= 0){
            if(mes > 0)
                return -1;
            else if(mes == 0){
                if(dia > 0)
                    return -1;
                else
                    return 1;
            } else
                return 1;
        } else
            return 1;    
    }
}