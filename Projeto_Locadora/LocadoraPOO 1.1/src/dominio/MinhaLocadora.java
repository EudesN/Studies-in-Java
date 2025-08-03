package dominio;

import java.util.ArrayList;
import java.util.Date;

public class MinhaLocadora implements Locadora{
    private ArrayList <Veiculo> frota;
    private ArrayList <Cliente> clientes;
    private ArrayList <Aluguel> alugueis;

    public MinhaLocadora(){
    this.frota = new ArrayList<>();
    this.clientes = new ArrayList<>();
    this.alugueis = new ArrayList<>();
    }
    public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado {
        for (Veiculo veiculo : this.frota) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        throw new VeiculoNaoCadastrado();
    }

    public Cliente pesquisarCliente(int cpf) throws ClienteNaoCadastrado {
        for(Cliente cliente : clientes){
            if(cliente.getCpf() == cpf){
                return cliente;
            }
        }
        throw new ClienteNaoCadastrado();
    }

    public void inserir(Veiculo v) throws VeiculoJaCadastrado {
        try {
            pesquisar(v.getPlaca());
            throw new VeiculoJaCadastrado();
        }
        catch (VeiculoNaoCadastrado e){
            this.frota.add(v);
        }
    }

    public void inserir(Cliente c) throws ClienteJaCadastrado{
        try {
            pesquisarCliente(c.getCpf());
            throw new ClienteJaCadastrado();
        } catch (ClienteNaoCadastrado e) {
            clientes.add(c);
        }
    }


    public ArrayList<Veiculo> pesquisarMoto(int cilindrada){
        ArrayList <Veiculo> motosEncotradas = new ArrayList<>();

        for(Veiculo v : frota){
            if(v instanceof Moto){
                Moto moto = (Moto) v;

                if(moto.getCilindradas() >= cilindrada){
                    motosEncotradas.add(moto);
                }
            }
        }
        return motosEncotradas;
    }


    // carros agora podem ser separados por categoria e são pesquisados por ela
    public ArrayList<Veiculo> pesquisarCarro(String categoria){
        ArrayList <Veiculo> carrosEncotrados = new ArrayList<>();

        for(Veiculo v : frota){
            if(v instanceof Carro){
                Carro carro = (Carro) v;
                if(carro.getCategoria() == categoria){carrosEncotrados.add(carro);}
            }
        }
        return carrosEncotrados;
    }

    public ArrayList<Veiculo> pesquisarCarro(int autonomia){
        ArrayList <Veiculo> carrosEncotrados = new ArrayList<>();

        for(Veiculo v : frota){
            if(v instanceof Carro){
                Carro carro = (Carro) v;
                if(carro.getAutonomia() >= autonomia){carrosEncotrados.add(carro);}
            }
        }
        return carrosEncotrados;
    }

    public ArrayList<Veiculo> pesquisarCaminhao(int carga){
        ArrayList<Veiculo> caminhoesEncontrados = new ArrayList<>();

        for(Veiculo v : frota){
            if(v instanceof Caminhao){
                Caminhao caminhao = (Caminhao) v;
                if(caminhao.getCargaMaxima() >= carga){caminhoesEncontrados.add(caminhao);}
            }
        }
        return caminhoesEncontrados;
    }

    public ArrayList<Veiculo> pesquisarOnibus(int passageiros){
        ArrayList<Veiculo> onibusEncotrados = new ArrayList<>();

        for(Veiculo v : frota){
            if(v instanceof Onibus){
                Onibus onibus = (Onibus) v;
                if(onibus.getPassageiros() >= passageiros){
                    onibusEncotrados.add(onibus);
                }
            }
        }
        return onibusEncotrados;
    }

    public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado{
        try{
            Veiculo v = pesquisar(placa);
            return v.calcularAluguel(dias);
        }
        catch (VeiculoNaoCadastrado e){
            throw new VeiculoNaoCadastrado();
        }

    }

    public void registrarAluguel(String placa, Date data, int dias, int cpf) throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado{
        Veiculo v = pesquisar(placa);
        Cliente c = pesquisarCliente(cpf);

        for(Aluguel aluguel : alugueis){
            if(aluguel.getVeiculo().getPlaca().equals(placa) && aluguel.getDataDevolucao() == null){
                throw new VeiculoAlugado();
            }
        }
        Aluguel novo = new Aluguel(v, c, data, dias);
        alugueis.add(novo);

    }

    public void registrarDevolucao(String placa, Date data, int cpf) throws VeiculoNaoCadastrado, VeiculoNaoAlugado, ClienteNaoCadastrado{
        Veiculo v = pesquisar(placa);
        Cliente c = pesquisarCliente(cpf);

        for(Aluguel a : alugueis){
            if(a.getVeiculo().getPlaca().equals(placa) && a.getDataDevolucao() == null){
                a.devolver(data);
                return;
            }
        }
        throw new VeiculoNaoAlugado();
    }
    public void depreciarVeiculos(int tipo, double taxaDepreciacao){
        for(Veiculo v : frota){
            if(tipo == 0 || (tipo == 1 && v instanceof Moto) || (tipo == 2 && v instanceof Carro) ||
                    (tipo == 3 && v instanceof Caminhao) || (tipo == 4 && v instanceof Onibus)){
                v.depreciarBem(taxaDepreciacao);
            }
        }
    }

    public void aumentarDiaria(int tipo, double taxaAumento){
        for(Veiculo v : frota){
            if(tipo == 0 || (tipo == 1 && v instanceof Moto) || (tipo == 2 && v instanceof Carro) ||
                    (tipo == 3 && v instanceof Caminhao) || (tipo == 4 && v instanceof Onibus)){
                v.aumentarDiaria(taxaAumento);
            }
        }
    }

    public double faturamentoTotal(int tipo, Date inicio, Date fim){
        double total = 0;
        for(Aluguel aluguel : alugueis){
            if(!aluguel.getData().before(inicio) && !aluguel.getData().after(fim)){
                Veiculo v = aluguel.getVeiculo();
                if (tipo==0 || (tipo==1&&v instanceof Moto) || (tipo==2&&v instanceof Carro)
                        || (tipo==3&&v instanceof Caminhao) || (tipo==4&&v instanceof Onibus)) {
                    total += v.calcularAluguel(aluguel.getDias());
                }
            }
        }
        return total;
    }

    public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim){
        int soma = 0;
        for(Aluguel aluguel : alugueis){
            if(!aluguel.getData().before(inicio) && !aluguel.getData().after(fim)){
                Veiculo v = aluguel.getVeiculo();
                if (tipo==0 || (tipo==1 && v instanceof Moto) || (tipo==2 && v instanceof Carro)
                        || (tipo==3 && v instanceof Caminhao) || (tipo==4 && v instanceof Onibus)) {
                    soma += aluguel.getDias();
                }
            }
        }
        return soma;
    }

    public void removerTudo() {
        frota.clear();
        alugueis.clear();
        clientes.clear();
    }
}
