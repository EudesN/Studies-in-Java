public class Moto extends Veiculo {
    int cilindradas;

    public Moto(String marca, String modelo, int AnoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int cilindradas) {
        super(marca, modelo, AnoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.cilindradas = cilindradas;
    }


    public double calcularSeguro(){
        double seguro = (this.valorAvaliado * 0.11) / 365;
        return seguro;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}


