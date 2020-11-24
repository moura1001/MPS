package business.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import business.model.Pedido;
import business.model.Usuario;
import business.model.Data;
import util.LoginUsuarioException;
import util.SenhaUsuarioException;
import util.DataUsuarioException;
import util.AdicaoUsuarioException;
import util.PersistenciaException;
import util.ErroInternoException;
import infra.GerentePersistencia;
import infra.GerentePersistenciaFile;

public class GerentePedido {
    private TreeSet<Usuario> usuarios;
    private GerentePersistencia repositorio;

    public GerentePedido() {
        try {
            this.repositorio = new GerentePersistenciaFile();
            this.usuarios = this.repositorio.carregarUsuarios();
        } catch (PersistenciaException e) {
            // throw new ErroInternoException("Erro interno durante a inicialização. Por favor, entre em contato com o administrador");
        }
    }

    public void adicionar(String[] itens, double valor, String login) {
        System.out.println("PEDIDO CADASTRADO");
        for (Usuario usuario : usuarios)
            if (usuario.getLogin().equals(login))
                usuario.getPedidos().add(new Pedido(itens, valor));

        try {
            this.repositorio.salvarUsuarios(usuarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarTodos() {
        for (Usuario usuario : usuarios) {
            ArrayList<Pedido> pedidos = usuario.getPedidos();
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.print("itens: " + String.join(" ", pedidos.get(i).getItens()) + " ");
                System.out.print("valor: " + pedidos.get(i).getValor());
            }
        }

    }

    public void remover(int id) {

    }
}
