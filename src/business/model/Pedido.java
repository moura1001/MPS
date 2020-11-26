package business.model;

import java.io.Serializable;

public class Pedido implements Serializable{
  private String[] itens;
  private double valor;

  public Pedido(String[] itens, double valor) {
    this.itens = itens;
    this.valor = valor;
  }

  public String[] getItens() {
    return itens;
  } 

  public double getValor() {
    return valor;
  } 
}
