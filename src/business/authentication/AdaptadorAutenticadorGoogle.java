package business.authentication;

public class AdaptadorAutenticadorGoogle implements AdaptadorAutenticador{
    private AutenticadorGoogle autenticador;

    public AdaptadorAutenticadorGoogle(){
        this.autenticador = new AutenticadorGoogle();
    }
	
    public boolean autenticar(String email, String senha){
        if(autenticador.autenticarComGoogle(email, senha))
            return true;

        return false;
    }
}