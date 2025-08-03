package dominio;

public class VeiculoNaoCadastrado extends Exception{
    public VeiculoNaoCadastrado() {
        super("O veiculo não foi cadastrado.");
    }
}
