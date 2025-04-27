package franciscoEudes.banco.test.aplicacao;

import franciscoEudes.banco.main.aplicacao.Conta;
import franciscoEudes.banco.main.aplicacao.Pessoa;

public class UsoDeConta {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "Raimundo");
		
		Conta c1 = new Conta(1, p1);
		Conta c2 = new Conta(2, p2);


		c1.credito(100);
		c1.debito(20);
		c1.credito(8);
		c1.debito(77.50);


		System.out.println(c1.getExtrato());


	}
}
