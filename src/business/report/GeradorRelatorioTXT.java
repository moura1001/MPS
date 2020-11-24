package business.report;

import infra.GerentePersistencia;
import infra.GerentePersistenciaFile;

public class GeradorRelatorioTXT extends GeradorRelatorio{

    public void CriarArquivo(){
            try {
                FileWriter fstream = new FileWriter("report.txt");
                BufferedWriter out = new BufferedWriter(fstream);

                out.write(GeradorRelatorioTXT.texto_relatorio);
                out.flush();
                out.close();


            } catch(IOException e) {
                throw new Error("Erro ao salvar arquivo.");
            }
        }
    }
}