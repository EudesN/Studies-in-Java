package dominio;

import java.util.Date;

public class Aluguel {
    Veiculo veiculo;
    Cliente cliente;
    Date data;
    int dias;
    Date dataDevolucao;

    public Aluguel(Veiculo v, Cliente c, Date data, int dias) {
        this.veiculo = v;
        this.cliente = c;
        this.data = data;
        this.dias = dias;
        this.dataDevolucao = null;
    }

    public void devolver(Date data){
        this.dataDevolucao = data;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo v) {
        this.veiculo = v;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
