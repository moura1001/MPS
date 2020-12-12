package business.control;

import java.util.ArrayList;
import java.util.HashMap;
import business.model.Pagamento;
import business.model.Entregador;
import util.LoginEntregadorException;
import util.PagamentoException;

public class ComandoPagamentoBuscar implements ComandoPagamento{

    public void executar(Object[] arg) throws PagamentoException{
        
        HashMap pagamentos =  (HashMap) arg[1];
        
        if(arg[0] == null)
            throw new PagamentoException();

        String[] info = ((String) arg[0]).split("[\\t ]");

        if(info.length != 2)
            throw new PagamentoException("Pagamento não encontrado por consulta incorreta");

        String login = info[0];
        Entregador entregador = null;
        try{
            entregador = GerenteEntregador.getGerente().getEntregador(login);

        } catch(LoginEntregadorException e){
            System.out.println(e.getMessage());
            return;
        }

        int idPagamento = 0;
        try{  
            idPagamento = Integer.parseInt(info[1]); 
        } 
        catch(NumberFormatException e){ 
            throw new PagamentoException("Pagamento não encontrado por consulta incorreta");
        }

        if(!pagamentos.containsKey(entregador)){
            throw new PagamentoException("Usuário não realizou nenhum pagamento");
        
        } else{
            ArrayList<Pagamento> pValue = (ArrayList<Pagamento>) pagamentos.get(entregador);
            if(pValue != null && idPagamento >= 0 && idPagamento <= pValue.size()){

                Pagamento p = pValue.get(idPagamento - 1);                
                System.out.println("Pagamento encontrado:");
                System.out.print(p);

            } else
                throw new PagamentoException("Pagamento não existe");            
            
        }

    }
}