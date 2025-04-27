package pedroSantosNeto.banco.main;

public class Pessoa {
	
	private int cpf;
	private String nome;
	private Conta conta;
	
	
	public Pessoa(int oCPF, String nm) {
		cpf = oCPF;
		nome = nm;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
