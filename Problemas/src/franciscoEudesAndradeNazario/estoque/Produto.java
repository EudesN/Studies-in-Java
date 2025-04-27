package estoque;
import java.util.ArrayList;

public class Produto {
    private int numItens;
    private int codigo;
    private String descricao; // descrição do produto
    private double precoCompra;
    private double precoVenda;
    private double lucro;
    private int quant;
    private int estoqueMinimo; // estoque minimo
    private ArrayList<String> movimentacoes = new ArrayList<>();
    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();

    public Produto(int cod, String desc, int min, double lucro) {
        this.codigo = cod;
        this.descricao = desc;
        this.estoqueMinimo = min;
        this.lucro = lucro;

        this.quant = 0;
        this.precoCompra = 0.0; // atualizado na primeira compra
        this.precoVenda = 0.0; // atualizado na primeira compra
    }

    public void compra(int quant, double val) {
        if(quant <= 0 || val < 0){
            System.out.println("Error: Valores negativos.");
            return;
        }
        double custoAtual = this.quant * this.precoCompra; //custo total atual = quantidade atual × preço de compra atual
        double custoNovo = quant *  val; // custo da nova compra = quantidade comprada × preço unitário informado
        int novaQuant = this.quant + quant; // nova quantidade total

        this.precoCompra = (custoAtual + custoNovo) / novaQuant; // preço médio ponderado
        this.quant = novaQuant;

        this.precoVenda = this.precoCompra * (1 + this.lucro); // atualiza preço de venda aplicando lucro
    }

    public  double venda(int quant){
        if(quant <= 0 || quant > this.quant){
            return -1;
        }
        this.quant -= quant;
        return quant * this.precoVenda;
    }

    public int getQuant(){
        return quant;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecoCompra(){
        return precoCompra;
    }

    public double getPrecoVenda(){
        return precoVenda;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public String getDescricao(){
        return descricao;
    }

    public void adicionarFornecedor(Fornecedor f){
        for(Fornecedor fornecedor : fornecedores){
            if(fornecedor.getCnpj() == f.getCnpj()){ // interrompe e não adiciona duplicata
                return;
            }
        }
            fornecedores.add(f);
            f.adicionaritem(this); // Adiciona este produto na lista do fornecedor
    }

    public ArrayList<Fornecedor> getFornecedores(){
        return fornecedores;
    }

    public void adicionarMovimentacao(String tipo, int quantidade, double valorUnitario, double valorTotal) {
        String data = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
        String registro = data + " - " + tipo + " - " + quantidade + " unidades - R$" + String.format("%.2f", valorTotal);
        movimentacoes.add(registro);
    }

    public ArrayList<String> getMovimentacoes() {
        return movimentacoes;
    }
}
