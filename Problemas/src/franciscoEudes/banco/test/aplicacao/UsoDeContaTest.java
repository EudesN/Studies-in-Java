package franciscoEudes.banco.test.aplicacao;

import franciscoEudes.banco.main.aplicacao.Conta;
import franciscoEudes.banco.main.aplicacao.Pessoa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsoDeContaTest {

    @Test
    public void testOperacao() {
        Pessoa p1 = new Pessoa(1, "Pedro");
        assertEquals("Pedro", p1.getNome());
        Pessoa p2 = new Pessoa(2, "Raimundo");
        assertEquals("Raimundo", p2.getNome());

        Conta c1 = new Conta(1, p1);
        Conta c2 = new Conta(2, p2);

        c1.credito(100);
        assertEquals(100, c1.getSaldo(), 0.01);

        c1.debito(20);
        assertEquals(80, c1.getSaldo(), 0.01);

        c1.credito(8);
        assertEquals(88, c1.getSaldo(), 0.01);

        c1.debito(77.50);
        assertEquals(10.5, c1.getSaldo(), 0.01);

        String extrato = c1.getExtrato();
        assertNotNull(extrato); // confere se a string n é nula
        System.out.println(extrato);
    }
}
