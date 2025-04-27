package estoque;
import java.util.ArrayList;

public class Fornecedor {
    private int cnpj;
    private String nome;
    private ArrayList<Produto> produtosFornecidos = new ArrayList<>();

    public Fornecedor(int cnpj, String nome){ // construtor
        this.cnpj = cnpj;
        this.nome = nome;
    }
    public int getCnpj(){
     return cnpj;

    }
    public String getNome(){
        return nome;
    }

    public void adicionaritem(Produto p){
        produtosFornecidos.add(p);
    }
    public ArrayList<Produto> getProdutosFornecidos() {
        return produtosFornecidos;
    }

}
