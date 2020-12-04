package business.control;

import java.util.ArrayList;
import java.util.HashMap;
import business.model.Pagamento;
import business.model.Usuario;
import util.LoginUsuarioException;
import util.PagamentoException;

public class ComandoPagamentoAdicionar implements ComandoPagamento{

    public void executar(Object[] arg) throws PagamentoException{

        HashMap pagamentos =  (HashMap) arg[1];
        
        if(arg[0] == null)
            throw new PagamentoException();

        String[] info = ((String) arg[0]).split("[\\t ]");

        if(info.length != 2)
            throw new PagamentoException();

        double valor = 0;
        try{  
            valor = Double.parseDouble(info[1]); 
        } 
        catch(NumberFormatException e){ 
            throw new PagamentoException("Valor incorreto");
        }   
        
        String login = info[0];
        Usuario usuario = null;
        try{
            usuario = GerenteUsuario.getGerente().getUsuario(login);

        } catch(LoginUsuarioException e){
            System.out.println(e.getMessage());
            return;
        }

        ((PagamentoCareTaker) arg[2]).limparEstadosSalvos();
        
        ArrayList<Pagamento> pValue = null;
        int idPagamento = -1;
        Pagamento p = null;
        
        if(!pagamentos.containsKey(usuario)){
            pValue = new ArrayList<Pagamento>();
            idPagamento = 1;
            p = new Pagamento(idPagamento, usuario, valor);
            pValue.add(p);
            pagamentos.put(usuario, pValue);
        
        } else{
            pValue = (ArrayList<Pagamento>) pagamentos.get(usuario);
            if(pValue == null)
                pValue = new ArrayList<Pagamento>();
            
            idPagamento = pValue.size() + 1;
            p = new Pagamento(idPagamento, usuario, valor);
            pValue.add(p);
            //pagamentos.put(usuario, pValue);
        }

        System.out.println("Pagamento adicionado:");
        System.out.println(p);
        
    }
}