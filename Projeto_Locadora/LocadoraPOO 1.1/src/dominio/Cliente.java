package dominio;

public class Cliente {
    private int cpf;
    private String nome;


    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
