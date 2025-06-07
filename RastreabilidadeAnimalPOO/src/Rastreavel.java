public interface Rastreavel {   // --- Grupo 1 ---
    boolean cadastrarFazenda(Fazenda f);
    boolean cadastrarAnimal(Animal a, Fazenda f);

    // --- Grupo 2 ---
    boolean compra(int comprado, int fazendaCompra, int fazendaVenda);
    boolean venda(int vendido, int fazendaVenda, int fazendaCompra);
    boolean abate(int numeroAnimal, int identificadorFazenda);
    boolean morte(int numeroAnimal, int identificadorFazenda);
    boolean vacina(int numeroAnimal, int identificadorFazenda);

    // --- Grupo 3 ---
    int listarResumoDeAnimais(int fazenda, int tipo, boolean jovem, boolean macho);
    double faturamentoAnual(int fazenda, int tipo); // só vendas de animais
    double perdaAnual(int fazenda, int tipo); // só mortes de animais (não inclui abate!)
}