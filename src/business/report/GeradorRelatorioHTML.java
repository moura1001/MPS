package business.report;

import infra.GerentePersistencia;
import infra.GerentePersistenciaFile;

public class GeradorRelatorioHTML extends GeradorRelatorio{

    public void CriarArquivo(){
            try {
                FileWriter fstream = new FileWriter("report.html");
                BufferedWriter out = new BufferedWriter(fstream);

                out.write("<!DOCTYPE html>");
                out.write("<html>");
                out.write("<body>");
                out.write("");
                out.write("<h1>Relatorio Estatistico</h1>");
                out.write("");
                out.write("<p>" + GeradorRelatorioTXT.texto_relatorio + "</p>");
                out.write("");
                out.write("</body>");
                out.write("</html>");
                out.flush();
                out.close();


            } catch(IOException e) {
                throw new Error("Erro ao salvar arquivo.");
            }
        }
    }
}