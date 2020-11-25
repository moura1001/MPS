package infra;

import java.io.*;
import java.util.TreeSet;
import business.model.Usuario;
import business.model.Data;
import business.model.Pedido;
import java.util.ArrayList;
import java.util.*;

import jdk.nashorn.internal.parser.JSONParser;
import util.PersistenciaException;

public class GerentePersistenciaFile implements GerentePersistencia{
    private String filename = "usuarios.txt";

    public TreeSet<Usuario> carregarUsuarios() throws PersistenciaException{
        TreeSet<Usuario> usuarios = new TreeSet<Usuario>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] usuario = line.split("[\\t\\n]");
                String login = usuario[0];
                String senha = usuario[1];
                String data = usuario[2];
                ArrayList<Pedido> pedidosArrayList = new ArrayList<Pedido>();
                if (usuario.length > 3) {
                    String[] pedidos = usuario[3].split("# ");
                    for (int i = 0; i < pedidos.length; i++ ) {
                        if (pedidos[i].equals("")) {
                            continue;
                        }
                        String[] dados = pedidos[i].split(" ");
                        String item = dados[0];
                        double valor = Double.valueOf(dados[1]);
                        String[] itens = {item};
                        pedidos[i].split(" ");
                        pedidosArrayList.add(new Pedido(itens, valor));
                    }
                }
                int dia = Integer.parseInt(data.split("/")[0]);
                int mes = Integer.parseInt(data.split("/")[1]);
                int ano = Integer.parseInt(data.split("/")[2]);
                //Data d = new Data(dia,mes,ano);

                Usuario u = new Usuario(login, senha, new Data(dia,mes,ano), pedidosArrayList);
                usuarios.add(u);
            }
        } catch (IOException exception) {
            throw new PersistenciaException("Erro ao carregar arquivo.");
        }

        return usuarios;
    }

    public void salvarUsuarios(TreeSet<Usuario> usuarios) throws PersistenciaException {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
    
            for(Usuario usuario : usuarios){
                String login = usuario.getLogin();
                String senha = usuario.getSenha();
                String data = usuario.getData().toString();
                ArrayList<Pedido> pedidos = usuario.getPedidos();
                String pedidosOutput = "";
                for (int i = 0; i < pedidos.size(); i++) {
                    pedidosOutput +=  "# " + String.join(" ", pedidos.get(i).getItens()) + " ";
                    pedidosOutput +=  pedidos.get(i).getValor();
                }
                out.write(login + "\t" + senha + "\t" + data + "\t" + pedidosOutput + "\n");
                out.flush();
            }
    
            out.close();  
        } catch(IOException e) {
            throw new PersistenciaException("Erro ao salvar arquivo.");
        }
    }
}