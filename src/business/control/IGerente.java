package business.control;

public interface IGerente {
    public void adicionar(String login, String senha);
    public void remover(String login);
    public void listar(String login);
    public void listarTodos();
}