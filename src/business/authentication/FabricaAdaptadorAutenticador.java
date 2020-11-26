package business.authentication;

public class FabricaAdaptadorAutenticador{
    public static AdaptadorAutenticador obterAdaptadorAutenticador(String tipo){

        AdaptadorAutenticador adaptadorAutenticador = null;

        switch(tipo){            
            case "google":
                adaptadorAutenticador = new AdaptadorAutenticadorGoogle();
                break;    
        }
        
        return adaptadorAutenticador;
    }
}