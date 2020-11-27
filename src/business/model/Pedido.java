package business.model;

import java.io.Serializable;

public class Pedido implements Serializable{
  private Item[] itens;
  private double valor;

  public Pedido(Item[] itens, double valor) {
    this.itens = itens;
    this.valor = valor;
  }

  public Item[] getItens(){
    return itens;
  } 

  public double getValor() {
    return valor;
  } 
}
