package dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface Locadora {
    public void inserir(Veiculo v) throws VeiculoJaCadastrado, SQLException;
    public void inserir(Cliente c) throws ClienteJaCadastrado, SQLException;
    public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado;
    public ArrayList<Veiculo> pesquisarMoto(int cilindrada);
    public ArrayList<Veiculo> pesquisarCarro(int autonomia);
    public ArrayList<Veiculo> pesquisarCaminhao(int carga);
    public ArrayList<Veiculo> pesquisarOnibus(int passageiros);

    //Seguro dominio.Moto = (valor do bem * 11%)/365
    //Seguro dominio.Carro = (valor do bem * 3%)/365
    //Seguro Caminhão = (valor do bem * 8%)/365
    //Seguro Ônibus = (valor do bem * 20%)/365
    //dominio.Aluguel = (valor da diária + seguro) * quantidade de dias

    public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado;

    public void registrarAluguel(String placa, Date data, int dias, int cpf) throws
            VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado;

    public void registrarDevolucao(String placa, Date data, int cpf) throws
            VeiculoNaoCadastrado, VeiculoNaoAlugado, ClienteNaoCadastrado;

    // tipo de veiculo
// 0 (todos), 1 (moto), 2 (carro), 3 (caminhão), 4 (ônibus)
    public void depreciarVeiculos(int tipo, double taxaDepreciacao);
    public void aumentarDiaria(int tipo, double taxaAumento);
    public double faturamentoTotal(int tipo, Date inicio, Date fim);
    public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim);
}