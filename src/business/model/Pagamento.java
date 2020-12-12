package business.model;

import java.io.Serializable;

public class Pagamento implements Serializable{
    
    private int idPagamento;
    private double valor;
    private String formaDePagamento;
    private Entregador entregador;
    
    public Pagamento(int idPagamento, Entregador entregador, double valor) {
        this.idPagamento = idPagamento;
        this.entregador = entregador;
        this.valor = valor;
        this.formaDePagamento = "Dinheiro";        
    }

    public Pagamento(int idPagamento, Entregador entregador, double valor, String formaDePagamento) {
        this.idPagamento = idPagamento;
        this.entregador = entregador;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
    }
    
    public String getFormaDePagamento(){
        return this.formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento){
        this.formaDePagamento = formaDePagamento;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public Entregador getEntregador(){
        return this.entregador;
    } 

    public String toString(){
        return "ID Pagamento: " + Integer.toString(idPagamento) + 
                "\n" + entregador +
                "\n" + "Valor: " + Double.toString(valor) +
                "\n" + "Foma de pagamento: " + formaDePagamento;
    }
    
    public Pagamento getCopia(){
    	return new Pagamento(this.idPagamento, this.entregador, this.valor);
    }
}
