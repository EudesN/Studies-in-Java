package programa;

public class Pessoa {
    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String oCpf, String nm, String eml){
        this.cpf = oCpf;
        this.nome = nm;
        this.email = eml;
    }

    public String getNome() {
        return nome;
    }
    public String getCPF(){
        return cpf;
    }
    //public Conta getConta(){
    //    return conta;
    //}
    public String getEmail(){
        return email;
    }
    public String toString(){
        return "\nNome: "+ getNome() +
                "\nCpf: "+ getCPF() +
                "\nEmail: "+ getEmail();
    }
}
