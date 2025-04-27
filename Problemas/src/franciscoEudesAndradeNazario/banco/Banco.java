package banco;

public class Banco {
	
	private Conta[] contas = new Conta[50];
	private int pos = 0;
	
	public void inserir(Conta c) {
		contas[pos++] = c;
	}

	public void deposito(int n, double v) {
		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == n) {
				contas[i].credito(v);
			}
		}
	}
	
	public void saque(int n, double v) {
		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == n) {
				contas[i].debito(v);
			}
		}
	}
	
	public double saldo(int n) {
		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == n) {
				return contas[i].getSaldo();
			}
		}
		return -9999999;
	}
	
	public String extrato(int n) {
		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == n) {
				return contas[i].getExtrato();
			}
		}
		return "";
	}

	public void transferencia(int pagador, int benefic,  double valor) {
		Conta origem = null;
		Conta destino = null;

		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == pagador) {
				origem = contas[i];
			}
			if (contas[i].getNumero() == benefic) {
				destino = contas[i];
			}
		}
		if (origem == null || destino == null) {
			System.out.println("Contas Incorretas");
			return;
		}
		if (origem.getSaldo() >= valor) {
			origem.debito(valor);
			destino.credito(valor);
			System.out.println("Transferencia realizada");
		}
		else {
			System.out.println("Saldo Insuficiente");
		}
	}
}
