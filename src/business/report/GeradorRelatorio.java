package business.report;

import business.control.Sistema;
import business.control.GerenteEntregador;
import business.control.GerenteListaDeCompra;

public abstract class GeradorRelatorio{

    //atributes
    protected int entregadoresCadastrados;
    protected int acessosEntregadores;
    protected String textoRelatorio;

    // Template Method
    public void gerarRelatorio(){
        adquirirDados();
        //GerarEstatistica();
        criarTextoRelatorio();
        criarArquivo();
    }


    public void adquirirDados(){
        // Adquirir os dados para fazer o relatorio   
        GerenteEntregador gerenteEntregador = GerenteEntregador.getGerente();
		GerenteListaDeCompra gerenteListaDeCompra = GerenteListaDeCompra.getGerente();
		Sistema sistema = Sistema.obterInstancia();    
        
        this.entregadoresCadastrados = gerenteEntregador.quantidadeEntregadoresCadastrados();
        this.acessosEntregadores = sistema.numeroAcessos();
    }

    /*
    public gerarEstatistica(){
        // Gerar valores estatisticos com os dados adquiridos
        
    }
    */

    public void criarTextoRelatorio(){
        if (this.entregadoresCadastrados != 0){
            this.textoRelatorio = "A quantidade de usuários cadastrados é igual a: " + Integer.toString(this.entregadoresCadastrados);
            this.textoRelatorio += "\nA quantidade de acessos é igual a: " + Integer.toString(this.acessosEntregadores);            
        
        } else{
            this.textoRelatorio = "Não há usuários cadastrados";
        }
    }

    public abstract void criarArquivo();
}