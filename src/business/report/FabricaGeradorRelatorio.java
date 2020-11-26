package business.report;

public class FabricaGeradorRelatorio{
    public static GeradorRelatorio obterGeradorRelatorio(String tipo){

        GeradorRelatorio geradorRelatorio = null;

        switch(tipo){            
            case "html":
                geradorRelatorio = new GeradorRelatorioHTML();
                break;
            case "txt":
                geradorRelatorio = new GeradorRelatorioTXT();
                break;    
        }
        
        return geradorRelatorio;
    }
}