package dominio;

public class VeiculoJaCadastrado extends Exception{
    public VeiculoJaCadastrado() {
        super("Operação não concluida: Veículo não encontrado no sistema.");
    }

    public VeiculoJaCadastrado(String message) {
        super(message);
    }
}
