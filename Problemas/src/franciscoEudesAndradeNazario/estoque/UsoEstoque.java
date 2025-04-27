package estoque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UsoEstoque {
    private Estoque estoque;
    private Produto p1, p2, p3, p4, p5;
    private Fornecedor f1, f2;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
        p1 = new Produto(1, "pastel", 30, 0.5);
        p2 = new Produto(2, "coxinha", 15, 0.25);
        p3 = new Produto(3, "empadão", 15, 0.25);
        p4 = new Produto(4, "bolo", 15, 0.25);
        p5 = new Produto(5, "pizza", 20, 0.5);

        estoque.incluir(p1);
        estoque.incluir(p2); // Agora será adicionado
        estoque.incluir(p3);
        estoque.incluir(p4);
        estoque.incluir(p5);

        f1 = new Fornecedor(123, "Flavio bolos");
        f2 = new Fornecedor(1234, "Márcia Salgados");
    }

    @Test
    public void testInicializacaoProdutos() {
        assertEquals(0, p1.getQuant());
        assertEquals(0.0, p1.getPrecoCompra());
        assertEquals(0.0, p1.getPrecoVenda());
    }

    @Test
    public void testComprasEPrecos() {
        estoque.comprar(1, 10, 3);
        assertEquals(10, estoque.quantidade(1));
        assertEquals(3.0, estoque.precoDeCompra(1));
        assertEquals(4.5, estoque.precoDeVenda(1)); // 3.0 * 1.5

        estoque.comprar(1, 10, 4);
        assertEquals(20, estoque.quantidade(1));
        assertEquals(3.5, estoque.precoDeCompra(1)); // (10*3 + 10*4) / 20 = 3.5
        assertEquals(5.25, estoque.precoDeVenda(1)); // 3.5 * 1.5
    }

    @Test
    public void testComprarComValoresInvalidos() {
        estoque.comprar(1, -5, 10); // Quantidade negativa
        assertEquals(0, estoque.quantidade(1));


        estoque.comprar(1, 10, -5); // Preço negativo
        assertEquals(0, estoque.quantidade(1));

        estoque.comprar(1, 0, 10); // Quantidade zero
        assertEquals(0, estoque.quantidade(1));
    }

    @Test
    public void testVendas() {
        estoque.comprar(1, 30, 3);
        double total = estoque.vender(1, 30);
        assertEquals(0, estoque.quantidade(1));
        assertEquals(30 * 4.5, total); // 3 + 50%
    }

    @Test
    public void testVenderQuantidadeInvalida() {
        estoque.comprar(1, 10, 5);

        assertEquals(-1, estoque.vender(1, 15)); // Vender mais do que tem

        assertEquals(-1, estoque.vender(1, -5)); // Quantidade negativa

        assertEquals(-1, estoque.vender(1, 0)); // Quantidade zero

        assertEquals(10, estoque.quantidade(1)); // Verifica se o estoque permanece sem alteração
    }

    @Test
    public void testVendaNoLimite() {
        estoque.comprar(2, 15, 2); // quantidade igual ao mínimo
        double total = estoque.vender(2, 15);
        assertEquals(0, estoque.quantidade(2));
        assertEquals(15 * 2.5, total);
    }

    @Test
    public void testEstoqueAbaixoDoMinimo() {
        estoque.comprar(1, 35, 10);
        estoque.comprar(2, 20, 10);
        estoque.comprar(3, 10, 10);
        estoque.comprar(4, 15, 10);
        estoque.comprar(5, 5, 10);

        ArrayList<Produto> abaixo = estoque.estoqueAbaixoDoMinimo();

        assertTrue(abaixo.contains(p3));
        assertTrue(abaixo.contains(p5));

        assertFalse(abaixo.contains(p1));
        assertFalse(abaixo.contains(p2));
        assertFalse(abaixo.contains(p4));

        assertEquals(2, abaixo.size()); // Verificar tamanho da lista
    }

    @Test
    public void testAdicionarFornecedores() {
        estoque.adicionarFornecedor(1, f1);
        estoque.adicionarFornecedor(1, f2);
        ArrayList<Fornecedor> fornecedores = estoque.fornecedores(1);
        assertEquals(2, fornecedores.size());
        assertTrue(fornecedores.contains(f1));
        assertTrue(fornecedores.contains(f2));
    }

    @Test
    public void testFornecedorDuplicado() {
        estoque.adicionarFornecedor(1, f1);
        estoque.adicionarFornecedor(1, f1);  // mesmo fornecedor
        assertEquals(1, estoque.fornecedores(1).size());
    }

    @Test
    public void testProdutosAdicionadosNosFornecedores() {
        estoque.adicionarFornecedor(1, f1);
        ArrayList<Produto> fornecidos = f1.getProdutosFornecidos();
        assertTrue(fornecidos.contains(p1));
        assertEquals(1, fornecidos.size());
    }

    @Test
    public void testMovimentacoes() throws InterruptedException {
        estoque.comprar(4, 15, 2);
        estoque.vender(4, 10);
        estoque.comprar(4, 5, 2);
        estoque.comprar(5, 15, 4);
        estoque.vender(5, 10);

        // intervalo que abrange as movimentaçOes
        Calendar cal = Calendar.getInstance();
        Date fim = cal.getTime();
        cal.add(Calendar.DATE, -1);
        Date inicio = cal.getTime();

        String mov4 = estoque.movimentacao(4, inicio, fim);
        String mov5 = estoque.movimentacao(5, inicio, fim);

        assertTrue(mov4.contains("Compra"));
        assertTrue(mov4.contains("Venda"));
        assertTrue(mov5.contains("Compra"));
        assertTrue(mov5.contains("Venda"));

        // Verificar estoque final
        assertTrue(mov4.contains("Estoque final: 10 unidades"));
        assertTrue(mov5.contains("Estoque final: 5 unidades"));
    }
}