package business.authentication;

public interface AdaptadorAutenticador {
	public boolean autenticar(String email, String senha);
}