package business.report;

import business.control.GerenteUsuario;

public abstract class GeradorRelatorio{

    //atributes
    public int numeroUsuarios;
    public String textoRelatorio;

    // Template Method
    public void gerarRelatorio(){
        adquirirDados();
        //GerarEstatistica();
        criarTextoRelatorio();
        criarArquivo();
    }


    public void adquirirDados(){
        // Adquirir os dados para fazer o relatorio       
        this.numeroUsuarios = GerenteUsuario.getGerente().getUsuarios().size();
    }

    /*
    public gerarEstatistica(){
        // Gerar valores estatisticos com os dados adquiridos
        
    }
    */

    public void criarTextoRelatorio(){
        if (this.numeroUsuarios != 0){
            this.textoRelatorio = "A quantidade de usuarios eh igual a:" + Integer.toString(this.numeroUsuarios);            
        
        } else{
            this.textoRelatorio = "A quantidade de usuarios eh igual a zero";
        }
    }

    public abstract void criarArquivo();
}