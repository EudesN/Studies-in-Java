import java.util.ArrayList;
import java.util.List;

public class SistemaDeRegistro implements Rastreavel{

    private List<Fazenda> fazendas;

    public SistemaDeRegistro(){
        this.fazendas = new ArrayList<>();
    }

    public
    @Override
    public boolean cadastrarFazenda(Fazenda f) {
        return false;
    }

    @Override
    public boolean cadastrarAnimal(Animal a, Fazenda f) {
        return false;
    }

    @Override
    public boolean compra(int comprado, int fazendaCompra, int fazendaVenda) {
        return false;
    }

    @Override
    public boolean venda(int vendido, int fazendaVenda, int fazendaCompra) {
        return false;
    }

    @Override
    public boolean abate(int numeroAnimal, int identificadorFazenda) {
        return false;
    }

    @Override
    public boolean morte(int numeroAnimal, int identificadorFazenda) {
        return false;
    }

    @Override
    public boolean vacina(int numeroAnimal, int identificadorFazenda) {
        return false;
    }

    @Override
    public int listarResumoDeAnimais(int fazenda, int tipo, boolean jovem, boolean macho) {
        return 0;
    }

    @Override
    public double faturamentoAnual(int fazenda, int tipo) {
        return 0;
    }

    @Override
    public double perdaAnual(int fazenda, int tipo) {
        return 0;
    }
}
