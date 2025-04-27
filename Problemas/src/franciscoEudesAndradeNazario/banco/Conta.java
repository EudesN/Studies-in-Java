package banco;

public class Conta {

	private int numero;
	private double saldo;
	private Pessoa dono;
	private Extrato extrato = new Extrato();

	
	public Conta(int n, Pessoa p) {
		if (n > 0) { 
		  numero = n;	
		  dono = p;
		}
	}
	
	public Pessoa getDono() {
		return dono;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getExtrato() {
		return extrato.toString();
	}
	
	public double totalDeLancamentos(String tp) {
		return extrato.totalDeLancamentos(tp);
	}
		
	public void credito(double valor) {
		if (valor > 0) {
		   saldo = saldo + valor;
		   extrato.adicionarOperacao(null, numero, valor, saldo, "Credito");
//		   extrato = extrato + "\nConta: " + numero + 
//				   ". Credito: " + valor + 
//				   ". Saldo: " + saldo + ".";
		}
	}
	
	public void debito(double valor) {
		if (valor > 0 && valor <= saldo) {
		   saldo = saldo - valor;
		   extrato.adicionarOperacao(null, numero, valor, saldo, "Debito");
//		   extrato = extrato + "\nConta: " + numero + 
//				   ". Debito: " + valor + 
//				   ". Saldo: " + saldo + ".";
		} else {
			System.out.println("Valor debitado invalido.");
		}
	}
}
