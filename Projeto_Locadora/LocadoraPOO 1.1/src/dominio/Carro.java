package dominio;

public class Carro extends Veiculo {
    String categoria;
    int autonomia;

    public Carro(String marca, String modelo, int ano, double valorAvaliado, double valorDiaria, String placa, int autonomia, String categoria) {
        super(marca, modelo, ano, valorAvaliado, valorDiaria, placa);
        this.autonomia = autonomia;
        this.categoria = categoria;
    }

    public double calcularSeguro(){
        double seguro = (this.valorAvaliado * 0.03) / 365;
        return seguro;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}


