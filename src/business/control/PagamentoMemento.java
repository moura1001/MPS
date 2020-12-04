package business.control;

import java.util.HashMap;

public class PagamentoMemento {
	private HashMap estadoPagamento;
	
	public PagamentoMemento(HashMap pagamento){
		estadoPagamento = pagamento;
	}
	
	public HashMap getPagamentoSalvo(){
		return estadoPagamento;
	}
}
