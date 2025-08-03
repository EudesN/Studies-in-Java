public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int anoDeFabricacao;
    protected double valorAvaliado;
    protected double valorDiaria;
    protected String placa;

    public Veiculo(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa){
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.valorAvaliado = valorAvaliado;
        this.valorDiaria = valorDiaria;
        this.placa = placa;
    }

    public abstract double calcularSeguro() ;

    public double calcularAluguel(int dias){
        return (getValorDiaria() + calcularSeguro()) * dias;

    }

    public void depreciarBem(double percentual){
        this.valorAvaliado -= (valorAvaliado * percentual);
    }

    public void aumentarDiaria(double percentual){
        this.valorDiaria += (valorDiaria * percentual);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getValorAvaliado() {
        return valorAvaliado;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoDeFabricacao(int fabricacao) {
        this.anoDeFabricacao = fabricacao;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setValorAvaliado(double valorAvaliado) {
        this.valorAvaliado = valorAvaliado;
    }

}





