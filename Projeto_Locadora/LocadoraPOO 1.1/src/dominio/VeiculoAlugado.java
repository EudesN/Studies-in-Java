package dominio;

public class VeiculoAlugado extends Exception{
    public VeiculoAlugado() {
        super("O veículo já está alugado.");
    }

    public VeiculoAlugado(String message) {
        super(message);
    }
}
