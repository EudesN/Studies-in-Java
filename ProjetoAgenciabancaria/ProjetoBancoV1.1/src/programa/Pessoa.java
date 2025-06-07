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

    public String getCPF(){
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail(){
        return email;
    }
    
    public String toString(){
        return "\nNome: "+ getNome() +
                "\nCpf: "+ getCPF() +
                "\nEmail: "+ getEmail();
    }
}
