package business.report;

import java.io.*;

public class GeradorRelatorioTXT extends GeradorRelatorio{

    public void criarArquivo(){
        try {
            FileWriter fstream = new FileWriter("report.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            out.write(this.textoRelatorio);
            out.flush();
            out.close();
        
        } catch(IOException e) {
            throw new Error("Erro ao salvar arquivo.");
        }
    }
}