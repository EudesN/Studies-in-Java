package pedroSantosNeto.banco.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pedroSantosNeto.banco.main.Conta;
import pedroSantosNeto.banco.main.Pessoa;

class TesteConta {

	@Test
	void testeCreditoDebitoEmConta() {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new Conta(1, p1);
		assertEquals(1, c1.getNumero());
		
		c1.credito(100);
		assertEquals(100, c1.getSaldo(), 0.001);
		c1.credito(9);
		assertEquals(109, c1.getSaldo(), 0.001);
		c1.credito(-9);
		assertEquals(109, c1.getSaldo(), 0.001);
		
		c1.debito(108);
		assertEquals(1, c1.getSaldo(), 0.001);
		
		c1.debito(2);
		assertEquals(1, c1.getSaldo(), 0.001);
		
		c1.debito(-1);
		assertEquals(1, c1.getSaldo(), 0.001);
		
		c1.debito(1);
		assertEquals(0, c1.getSaldo(), 0.001);
	}
	
	@Test
	void testeDonoDaConta() {
		Pessoa p1 = new Pessoa(1, "Pedro");		
		Conta c1 = new Conta(1, p1);
		
		assertEquals("Pedro", c1.getDono().getNome());
		assertEquals(1, c1.getDono().getCpf());
	}
	
	@Test
	void testeExtrato() {
		Pessoa p1 = new Pessoa(1, "Pedro");		
		Conta c1 = new Conta(1, p1);
		
		c1.credito(100);
		c1.debito(99);
		System.out.println(c1.getExtrato());
		
		assertEquals("\nConta: 1. Credito: 100.0. Saldo: 100.0\n" + 
				"Conta: 1. Debito: 99.0. Saldo: 1.0", c1.getExtrato());
	}
	
	@Test
	void testeTotalDeLancamentosExtrato() {
		Pessoa p1 = new Pessoa(1, "Pedro");		
		Conta c1 = new Conta(1, p1);
		
		c1.credito(100);
		c1.credito(20);
		c1.credito(10);
		c1.credito(1);
		
		double total = c1.totalDeLancamentos("Credito");
		
		assertEquals(131, total);
		
		c1.debito(90);
		c1.debito(10);
		c1.debito(5);
		c1.debito(1);
		
		total = c1.totalDeLancamentos("Debito");
		
		assertEquals(106, total);
	}
}
