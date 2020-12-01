package business.model;

import java.io.Serializable;

public class Pagamento implements Serializable{
    
    private int idPagamento;
    private double valor;
    private String formaDePagamento;
    private Usuario usuario;
    
    public Pagamento(int idPagamento, Usuario usuario, double valor) {
        this.idPagamento = idPagamento;
        this.usuario = usuario;
        this.valor = valor;
        this.formaDePagamento = "Dinheiro";        
    }

    public Pagamento(int idPagamento, Usuario usuario, double valor, String formaDePagamento) {
        this.idPagamento = idPagamento;
        this.usuario = usuario;
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

    public Usuario getUsuario(){
        return this.usuario;
    } 

    public String toString(){
        return "Pagamento: " + Integer.toString(idPagamento) + 
                "\n" + usuario +
                "\n" + "Valor: " + Double.toString(valor) +
                "\n" + "Foma de pagamento: " + formaDePagamento;
    }
}
