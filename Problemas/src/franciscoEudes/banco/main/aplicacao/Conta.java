package franciscoEudes.banco.main.aplicacao;

public class Conta {

	private int numero;
	private double saldo;
	private Pessoa dono;
	private String extratoConta = "";

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

	public void credito(double valor) {
		if (valor > 0) {
			saldo = saldo + valor;
			extratoConta +=  "Conta " + numero + " Credito: " + valor + " Saldo: " + saldo + "\n";
		}
	}

	public void debito(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo = saldo - valor;
			extratoConta +=  "Conta " + numero + " Debito: " + valor + " Saldo: " + saldo + "\n";
		} else {
			System.out.println("Valor debitado invalido.");
		}
	}

	public String getExtrato() {
		return extratoConta;


	}
}
