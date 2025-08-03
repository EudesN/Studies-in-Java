public class Caminhao extends Veiculo {
    int cargaMaxima;

    public Caminhao(String marca, String modelo, int AnoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int cargaMaxima) {
        super(marca, modelo, AnoDeFabricacao,valorAvaliado , valorDiaria, placa);
        this.cargaMaxima = cargaMaxima;
    }


    public double calcularSeguro(){
        double seguro = (this.valorAvaliado * 0.08) / 365;
        return seguro;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }   
}


