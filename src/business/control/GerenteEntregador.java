package business.control;

import java.util.TreeSet;
import business.model.Entregador;
import business.model.Data;
import util.LoginEntregadorException;
import util.SenhaEntregadorException;
import util.DataEntregadorException;
import util.AdicaoEntregadorException;
import util.PersistenciaException;
import util.ErroInternoException;
import infra.GerentePersistencia;
import infra.FabricaGerentePersistencia;

public class GerenteEntregador implements IGerente{

    private static GerenteEntregador gerente;
    private static ListarEntregadorStrategy listarEntregadorStrategy;
    private TreeSet<Entregador> entregadores;
    private GerentePersistencia repositorioEntregador;

    private GerenteEntregador() throws ErroInternoException{
        try{
            this.repositorioEntregador = FabricaGerentePersistencia.obterGerentePersistencia("arquivo");
            this.entregadores = (TreeSet<Entregador>) this.repositorioEntregador.carregar("entregadores");
            if(this.entregadores == null)
                this.entregadores = new TreeSet<Entregador>();
        } catch(PersistenciaException e){
            throw new ErroInternoException("Erro interno durante a inicialização. Por favor, entre em contato com o administrador");
        }        
    }

	public void adicionar(String entregador) throws AdicaoEntregadorException, ErroInternoException{

        if(entregador == null)
            throw new AdicaoEntregadorException();

        String[] info = entregador.split("[\\t ]");

        if(info.length != 2)
            throw new AdicaoEntregadorException();
        
        String login = info[0];
        String senha = info[1];
        //String data = info[2];
        
        if(login.matches("^$") || senha.matches("^$"))// || data.matches("^$"))
            throw new AdicaoEntregadorException();

        if(login.length() > 20)
            throw new LoginEntregadorException("Login não pode ultrapassar 20 caracters");

        if(login.matches(".*\\d.*"))
            throw new LoginEntregadorException("Login não pode conter números");

        if(existeEntregador(login) != null)
            throw new LoginEntregadorException("Login já existe");    

        if(senha.length() < 8 || senha.length() > 12)
            throw new SenhaEntregadorException("Senha deve conter entre 8 e 12 caracters");

        if(!senha.matches("(.*\\d.*){2,}"))
            throw new SenhaEntregadorException("Senha deve conter pelo menos 2 números");
        
        //if(!data.matches("[0-3][0-9]/[0-9]{2}/[0-9]{4}"))
        //    throw new DataEntregadorException("Data de nascimento deve seguir o formato DD/MM/AAAA");
        
        //int dia = Integer.parseInt(data.split("/")[0]);
        //int mes = Integer.parseInt(data.split("/")[1]);
        //int ano = Integer.parseInt(data.split("/")[2]);
        //Data d = new Data(dia,mes,ano);
        Entregador u = new Entregador(login, senha);
        this.entregadores.add(u);
        
        try {
            this.repositorioEntregador.salvar("entregadores", this.entregadores);
            System.out.println(u + " foi adicionado");
        } catch(PersistenciaException e) {
            throw new ErroInternoException("Erro interno ao tentar adicionar usuário. Por favor, entre em contato com o administrador");
        }
    }
    
    public void remover(String login) throws LoginEntregadorException, ErroInternoException{
        
        Entregador entregador = existeEntregador(login);
        
        if(entregador == null)
            throw new LoginEntregadorException("Login não existe");
        
        try {
            this.entregadores.remove(entregador);
            this.repositorioEntregador.salvar("entregadores", this.entregadores);
            System.out.println(entregador + " foi removido");
        } catch (PersistenciaException exception) {
            throw new ErroInternoException("Erro interno ao tentar remover usuário. Por favor, entre em contato com o administrador");
        }
    }

    public void listar(String login) throws LoginEntregadorException{
        
        Entregador entregador = existeEntregador(login);
        
        if(entregador == null)
            throw new LoginEntregadorException("Login não existe");

        System.out.println(entregador);
        
    }

    public void listarTodosPorOrdemAlfabetica(){

        listarEntregadorStrategy = new ListarAlfabeticamente();
        listarEntregadorStrategy.listar(this.entregadores);
    }

    public void listarTodosPorOrdemDataDeNascimento(){

        listarEntregadorStrategy = new ListarPorNascimento();
        listarEntregadorStrategy.listar(this.entregadores);
    }

    public void encerrar() throws ErroInternoException{        
        try {
            this.repositorioEntregador.salvar("entregadores", this.entregadores);
        } catch (PersistenciaException e) {
            throw new ErroInternoException("Erro interno durante o encerramento com possíveis perdas de dados. Por favor, entre em contato com o administrador");
        }
    }

    private Entregador existeEntregador(String login){
        for(Entregador entregador : entregadores)
            if(entregador.getLogin().equals(login))
                return entregador;
        return null;
    }

    public TreeSet<Entregador> getEntregadores(){
    	return this.entregadores;
    }

    public Entregador getEntregador(String login) throws LoginEntregadorException{
        Entregador entregador = existeEntregador(login);
        
        if(entregador == null)
            throw new LoginEntregadorException("Login não existe");
    	
        return entregador;
    }

    public static GerenteEntregador getGerente(){
        if(gerente == null){
            try{
                gerente = new GerenteEntregador();
            } catch(ErroInternoException e){
                System.out.println(e.getMessage());
                System.exit(-1);
            }            
        }

        return gerente;    
    }

    public int quantidadeEntregadoresCadastrados(){
    	return this.entregadores.size();
    }

}