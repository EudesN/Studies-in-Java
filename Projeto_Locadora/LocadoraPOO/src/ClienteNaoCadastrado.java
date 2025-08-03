public class ClienteNaoCadastrado extends Exception{
    public ClienteNaoCadastrado() {
        super("O cliente não foi cadastrado.");
    }
}
