package business.control;

import java.util.ArrayList;

public class PagamentoCareTaker {
	protected ArrayList<PagamentoMemento> estados;
	
	public PagamentoCareTaker(){
		estados = new ArrayList<PagamentoMemento>();
	}
	
	public void adicionarMemento(PagamentoMemento memento){
		estados.add(memento);
	}
	
	public PagamentoMemento getUltimoEstadoSalvo(){
		if(estados.size() <= 0)
			return null;
		
		PagamentoMemento estadoSalvo = estados.remove(estados.size() - 1);
		return estadoSalvo;
	}
	
	public void limparEstadosSalvos(){
		estados.clear();
	}
}
