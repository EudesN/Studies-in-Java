package dominio;

public class VeiculoNaoAlugado extends Exception {
    public VeiculoNaoAlugado() {
        super("Ação não permitida: este veículo não consta como alugado.");
    }
}