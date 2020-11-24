package business.report;

import infra.GerentePersistencia;
import infra.GerentePersistenciaFile;

public abstract class GeradorRelatorio{

    //atributes
    public int numero_usuarios;
    public String texto_relatorio;
    private TreeSet<Usuario> usuarios;
    private GerentePersistencia repositorioUsuario;

    // Template Method
    public void GerarRelatorio(){
        AdquirirDados();
        //GerarEstatistica();
        CriarTextoRelatorio();
        CriarEscreverArquivo();
    }


    public void AdquirirDados(){
        // Adquirir os dados para fazer o relatorio
        try{
            this.repositorioUsuario = new GerentePersistenciaFile();
            this.usuarios = this.repositorioUsuario.carregarUsuarios();
        } catch(PersistenciaException e){
            throw new ErroInternoException("Erro interno durante a inicialização. Por favor, entre em contato com o administrador. Erro: GeradorRelatorio.");
        }       
        
        this.numero_usuarios = usuarios.size();
    }

    /*
    public GerarEstatistica(){
        // Gerar valores estatisticos com os dados adquiridos
        
    }
    */

    public void CriarTextoRelatorio(){
        if (this.numero_usuarios == 0){
            this.texto_relatorio = "A quantidade de usuarios eh igual a zero" + Integer.toString(this.numero_usuarios);
        }
        else if (this.numero_usuarios == 0){
            this.texto_relatorio = "A quantidade de usuarios eh igual a:" + Integer.toString(this.numero_usuarios);
        }
    }

    public abstract void CriarEscreverArquivo();
}