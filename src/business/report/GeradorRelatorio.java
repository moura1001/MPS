package business.report;

import business.control.Sistema;
import business.control.GerenteUsuario;
import business.control.GerentePedido;

public abstract class GeradorRelatorio{

    //atributes
    protected int usuariosCadastrados;
    protected int acessosUsuarios;
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
        GerenteUsuario gerenteUsuario = GerenteUsuario.getGerente();
		GerentePedido gerentePedido = GerentePedido.getGerente();
		Sistema sistema = Sistema.obterInstancia();    
        
        this.usuariosCadastrados = gerenteUsuario.quantidadeUsuariosCadastrados();
        this.acessosUsuarios = sistema.numeroAcessos();
    }

    /*
    public gerarEstatistica(){
        // Gerar valores estatisticos com os dados adquiridos
        
    }
    */

    public void criarTextoRelatorio(){
        if (this.usuariosCadastrados != 0){
            this.textoRelatorio = "A quantidade de usuários cadastrados é igual a: " + Integer.toString(this.usuariosCadastrados);
            this.textoRelatorio += "\nA quantidade de acessos é igual a: " + Integer.toString(this.acessosUsuarios);            
        
        } else{
            this.textoRelatorio = "Não há usuários cadastrados";
        }
    }

    public abstract void criarArquivo();
}