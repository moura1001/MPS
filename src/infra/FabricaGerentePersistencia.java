package infra;

public class FabricaGerentePersistencia{
    public static GerentePersistencia obterGerentePersistencia(String tipo){

        GerentePersistencia gerentePersistencia = null;

        switch(tipo){            
            case "arquivo":
                gerentePersistencia = new GerentePersistenciaFile();
                break;
        }
        
        return gerentePersistencia;
    }
}