package business.model;

import java.util.Random;
import java.io.Serializable;

public class Data implements Serializable{

    private int dia, mes, ano;

    public Data(){
        Random random = new Random();
        this.dia = random.nextInt(31) + 1;
        this.mes = random.nextInt(12) + 1;
        this.ano = random.nextInt(438) + 1582;
    }
    
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString(){
        String dia = (this.dia <= 9) ? "0"+Integer.toString(this.dia) : Integer.toString(this.dia);
        String mes = (this.mes <= 9) ? "0"+Integer.toString(this.mes) : Integer.toString(this.mes);
        String ano = Integer.toString(this.ano);
        return dia + "/" + mes + "/" + ano;
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }

}