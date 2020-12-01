package business.control;

import java.util.HashMap;
import java.util.ArrayList;
import business.model.Pagamento;
import business.model.Usuario;
import util.PagamentoException;
import java.lang.NumberFormatException;

public class GerentePagamento{

    private static GerentePagamento gerente;
    private HashMap<Usuario, ArrayList<Pagamento>> pagamentos;
    private HashMap comandos;

    private GerentePagamento(){
        this.pagamentos = new HashMap<Usuario, ArrayList<Pagamento>>();
        comandos = new HashMap();
        iniciarComandos();            
    }

    private void iniciarComandos(){
        comandos.put("adicionar", new ComandoPagamentoAdicionar());
        comandos.put("atualizar", new ComandoPagamentoAtualizar());
        comandos.put("buscar", new ComandoPagamentoBuscar());
    }

	public void service(String comando, String pagamento) {

        ComandoPagamento c = (ComandoPagamento) comandos.get(comando);

        try {
            c.executar(pagamento);
        } catch (PagamentoException e) {
            System.out.println(e.getMessage());
        }        
    }

    public HashMap<Usuario, ArrayList<Pagamento>> getPagamentos(){
    	return this.pagamentos;
    }

    public static GerentePagamento getGerente(){
        if(gerente == null)
            gerente = new GerentePagamento();

        return gerente;    
    }

}