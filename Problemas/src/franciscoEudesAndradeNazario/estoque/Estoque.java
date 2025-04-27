package estoque;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Estoque {
    private ArrayList <Produto> listaProdutos;
    private ArrayList <Produto> estoqueAbaixoMin;

    private static final SimpleDateFormat DATE_FORMAT_MOV = new SimpleDateFormat("dd/MM/yyyy");

    public Estoque(){ // Contrutor padrão do estoque
        this.listaProdutos = new ArrayList<>();
        this.estoqueAbaixoMin = new ArrayList<>();
    }

    private Produto buscarProduto(int cod){ //  Auxiliar: busca linear do produto a partir do código
        for(Produto p: this.listaProdutos){
            if(p.getCodigo() == cod){
                return p; // se encotrado retorna o produto relacionado ao código
            }
        }
        return null; // se não retorna null
    }

    public void incluir(Produto p){ // Verifica se o produto já existe no estoque baseado no código
        if(p == null){
            System.out.println("Error: Tentativa de incluir produto null");
            return;
        }
        if(buscarProduto(p.getCodigo()) != null){
            System.out.println("Error: Produto com código " + p.getCodigo() + " já adicionado ao estoque");
            return;
        }
        listaProdutos.add(p);
    }

    public void comprar(int cod, int quant, double preco){
        if(quant <= 0){
            System.out.println("Error: Quantidade de itens deve ser positiva");
            return;
        }
        if(preco < 0 ){
            System.out.println("Error: Preço com valor negativo");
            return;
        }

        Produto p = buscarProduto(cod);
        if(p == null){
            System.out.println("Error: Código inexistente.");
            return;
        }
        else{
            p.compra(quant, preco);

            // Cria o registro de movimentação (usando a classe interna de Produto)
            p.adicionarMovimentacao("Compra", quant, preco, quant * preco);
        }
    }

    public double vender(int cod, int quant){
        if(quant <= 0){
            System.out.println("Error: Quantidade de itens deve ser positiva");
            return -1;
        }
        Produto p = buscarProduto(cod);
        if(p == null){
            System.out.println("Produto com código "+ cod +" não encontrado");
            return -1;
        }
        double totVenda = p.venda(quant);

        if(totVenda != -1){
            // Venda bem-sucedida, registrar movimentação
            double valorVendaTot = totVenda;

            p.adicionarMovimentacao("Venda", quant, p.getPrecoVenda(), valorVendaTot);

            System.out.println("Venda registrada para o produto " + cod + ": " + quant + " unidades. Valor total: R$" + String.format("%.2f", valorVendaTot));
            return valorVendaTot;
        } else {
            // Venda falhou (produto já emitiu log de erro internamente ou quantidade inválida)
            return -1;
        }
    }

    public int quantidade(int cod){
        Produto p = buscarProduto(cod);
        if(p != null){
            return p.getQuant();
        }
        else{
            System.out.println("Aviso Quantidade: Produto com código " + cod + " não encontrado.");
            return 0;
        }
    }

    // o método deve retornar uma string com todas as movimentações ocorridas no estoque de um produto
    // mostrando a compra, valor comprado, venda, valor vendido e o estoque final do produto.

    public String movimentacao(int cod, Date inicio, Date fim) {
        Produto produto = buscarProduto(cod);
        if (produto == null) {
            return "Produto não encontrado";
        }
    
        StringBuilder movimentacao = new StringBuilder();
        long inicioMillis = inicio.getTime();
        long fimMillis = fim.getTime();
    
        for (String m : produto.getMovimentacoes()) {
            // m = "dd/MM/yyyy - Tipo - X unidades - R$ YY.YY"
            String[] partes = m.split(" - ");
            if (partes.length >= 4) {
                try {
                    Date dataMov = DATE_FORMAT_MOV.parse(partes[0]);
                    long movMillis = dataMov.getTime();
    
                    if (movMillis >= inicioMillis && movMillis <= fimMillis) {
                        movimentacao.append(m).append("\n"); // <-- agora mostra a movimentação!
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao analisar data da movimentação: " + m);
                }
            }
        }
    
        if (movimentacao.length() == 0) {
            return "Sem movimentações no período.";
        }
    
        // Adiciona o estoque final no final do relatório
        movimentacao.append("Estoque final: ").append(produto.getQuant()).append(" unidades.");
    
        return movimentacao.toString();
    }



    public ArrayList<Fornecedor> fornecedores(int cod) {
        Produto produto = buscarProduto(cod);
        if (produto != null) {
            return produto.getFornecedores();
        } else {
            return null;
        }
    }


    public ArrayList<Produto> estoqueAbaixoDoMinimo(){
        estoqueAbaixoMin.clear();
        for (Produto p : listaProdutos) {
            if (p.getQuant() < p.getEstoqueMinimo()) {
                estoqueAbaixoMin.add(p);
            }
        }
        return estoqueAbaixoMin;

    }

    public void adicionarFornecedor(int cod, Fornecedor f){
        Produto produto = buscarProduto(cod);
        if(produto == null){
            System.out.println("Produto não encontrado");
            return;
        }
        produto.adicionarFornecedor(f);
    }

    public double precoDeVenda(int cod) {
        Produto produto = buscarProduto(cod);
        if (produto != null) {
            return produto.getPrecoVenda();
        } else {
            return 0.0;
        }
    }

    public double precoDeCompra(int cod) {
        Produto produto = buscarProduto(cod);
        if (produto != null) {
            return produto.getPrecoCompra();
        } else {
            return 0.0;
        }
    }

}
