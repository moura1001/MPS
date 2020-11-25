package business.report;

import java.io.*;

public class GeradorRelatorioHTML extends GeradorRelatorio{

    public void criarArquivo(){
        try {
            FileWriter fstream = new FileWriter("report.html");
            BufferedWriter out = new BufferedWriter(fstream);
            
            out.write("<!DOCTYPE html>");
            out.write("<html>");
            out.write("<body>");
            out.write("");
            out.write("<h1>Relatorio Estatistico</h1>");
            out.write("");
            out.write("<p>" + this.textoRelatorio + "</p>");
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