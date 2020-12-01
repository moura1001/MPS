package business.control;

import java.util.ArrayList;
import java.util.HashMap;
import business.model.Pagamento;
import business.model.Usuario;
import util.LoginUsuarioException;
import util.PagamentoException;

public class ComandoPagamentoAtualizar implements ComandoPagamento{

    public void executar(String arg) throws PagamentoException{
        
        HashMap pagamentos =  GerentePagamento.getGerente().getPagamentos();
        
        if(arg == null)
            throw new PagamentoException();

        String[] info = arg.split("[\\t ]");

        if(info.length != 3)
            throw new PagamentoException("Pagamento não encontrado por consulta incorreta");

        int idPagamento = 0;
        try{  
            idPagamento = Integer.parseInt(info[1]); 
        } 
        catch(NumberFormatException e){ 
            throw new PagamentoException("Pagamento não encontrado por consulta incorreta");
        }
        
        double valor = 0;
        try{  
            valor = Double.parseDouble(info[2]); 
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

        ArrayList<Pagamento> pValue = null;
        Pagamento p = null;
        
        if(!pagamentos.containsKey(usuario)){
            throw new PagamentoException("Usuário não realizou nenhum pagamento");
        
        } else{
            pValue = (ArrayList<Pagamento>) pagamentos.get(usuario);
            if(pValue != null && idPagamento >= 0 && idPagamento <= pValue.size()){

                p = pValue.get(idPagamento - 1); 
                p.setValor(valor) ;

            } else
                throw new PagamentoException("Pagamento não existe");
        }

        System.out.println("Pagamento atualizado:");
        System.out.println(p);

    }
}