package dominio;

public class Onibus extends Veiculo {
    int passageiros;

    public Onibus(String marca, String modelo, int AnoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int passageiros) {
        super(marca, modelo, AnoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.passageiros = passageiros;
    }


    public double calcularSeguro(){
        double seguro = (this.valorAvaliado * 0.20) / 365;
        return seguro;
    }

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(int passageiros) {
        this.passageiros = passageiros;
    }
}

