package business.control;

import java.util.HashMap;
import java.util.ArrayList;
import business.model.Pagamento;
import business.model.Usuario;
import util.PagamentoException;

public class GerentePagamento{

    private static GerentePagamento gerente;
    private HashMap<Usuario, ArrayList<Pagamento>> pagamentos;
    private HashMap comandos;
    PagamentoCareTaker caretaker;

    private GerentePagamento(){
        this.pagamentos = new HashMap<Usuario, ArrayList<Pagamento>>();
        comandos = new HashMap();
        caretaker = new PagamentoCareTaker();
        iniciarComandos();            
    }

    private void iniciarComandos(){
        comandos.put("adicionar", new ComandoPagamentoAdicionar());
        comandos.put("atualizar", new ComandoPagamentoAtualizar());
        comandos.put("buscar", new ComandoPagamentoBuscar());
    }

	public void service(String comando, String pagamento) {
		
		ComandoPagamento c = (ComandoPagamento) comandos.get(comando);
		
		Object[] o = new Object[3];
		o[0] = pagamento;
		o[1] = this.pagamentos;
		o[2] = this.caretaker;

        try {
            c.executar(o);
        } catch (PagamentoException e) {
            System.out.println(e.getMessage());
        }        
    }
    
    public void desfazerAtualizacao(){
    	
    	PagamentoMemento estado = caretaker.getUltimoEstadoSalvo();
    	
    	if(estado == null){
    		System.out.println("\nNão há nenhuma atualização para ser desfeita.");
    		return;
    	}
    	
    	this.pagamentos = estado.getPagamentoSalvo();
    	System.out.println("\nAtualização desfeita.");
    }

    public static GerentePagamento getGerente(){
        if(gerente == null)
            gerente = new GerentePagamento();

        return gerente;    
    }

}