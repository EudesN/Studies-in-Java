public class Carro extends Veiculo {
    int autonomia;

    public Carro(String marca, String modelo, int ano, double valorAvaliado, double valorDiaria, String placa, int autonomia) {
        super(marca, modelo, ano, valorAvaliado, valorDiaria, placa);
        this.autonomia = autonomia;
    }


    public double calcularSeguro(){
        double seguro = (this.valorAvaliado * 0.03) / 365;
        return seguro;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
}


