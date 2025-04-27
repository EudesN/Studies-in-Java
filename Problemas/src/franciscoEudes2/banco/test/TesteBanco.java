package pedroSantosNeto.banco.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pedroSantosNeto.banco.main.Banco;
import pedroSantosNeto.banco.main.Conta;
import pedroSantosNeto.banco.main.Pessoa;

class TesteBanco {

	@Test
	void testarCadastroDeContas() {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "Raimundo");
		
		Conta c1 = new Conta(1, p1);
		Conta c2 = new Conta(2, p2);
		
		Banco b = new Banco();
		
		b.inserir(c1);
		b.inserir(c2);
		
		assertEquals(0, b.saldo(1));
		assertEquals(0, b.saldo(2));
		assertEquals(-9999999, b.saldo(3));
	}
	
	@Test
	void testarCreditoDebitoDeContas() {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new Conta(1, p1);		
		Banco b = new Banco();
		
		b.inserir(c1);
		b.deposito(1, 100);
		assertEquals(100, b.saldo(1));
		b.saque(1, 99);
		assertEquals(1, b.saldo(1));
		b.saque(1, 2);
		assertEquals(1, b.saldo(1));
		System.out.println(b.extrato(1));
		assertEquals("\nConta: 1. Credito: 100.0. Saldo: 100.0\n" + 
				"Conta: 1. Debito: 99.0. Saldo: 1.0", b.extrato(1));
		
		b.deposito(3, 100);
		assertEquals(-9999999, b.saldo(3));
		b.saque(3, 100);
		assertEquals(-9999999, b.saldo(3));
		assertEquals("", b.extrato(3));

	}
	@Test
	void testarTransferencia(){
		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "Raimundo");

		Conta c1 = new Conta(1, p1);
		Conta c2 = new Conta(2, p2);

		Banco b = new Banco();

		b.inserir(c1);
		b.inserir(c2);

		b.deposito(1, 200);

		b.transferencia(1, 2, 200);
		assertEquals(0, b.saldo(1));
		assertEquals(200, b.saldo(2));

		b.transferencia(1, 2, 1000); // valores não é alterado pq o saldo é insuficiente
		assertEquals(0, b.saldo(1));
		assertEquals(200, b.saldo(2));
	}
}
