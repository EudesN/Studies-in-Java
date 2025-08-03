package dominio;

public class ClienteJaCadastrado extends Exception {
    public ClienteJaCadastrado() {
        super("O cliente já possui cadastro no sistema.");
    }
}
