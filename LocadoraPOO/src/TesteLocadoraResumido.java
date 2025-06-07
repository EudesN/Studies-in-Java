import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TesteLocadoraResumido {

	@Test
	public void testeInserirVeiculo() throws VeiculoJaCadastrado, VeiculoNaoCadastrado, SQLException {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();
		Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 300);
		locadora.inserir(carro1);
		Veiculo recuperado = locadora.pesquisar("LVF-1000");
		assertEquals("Ford", recuperado.getMarca());
		assertEquals("F-1000", recuperado.getModelo());
		assertEquals(1980, recuperado.getAnoDeFabricacao());
		assertEquals(10000, recuperado.getValorAvaliado(), 0.0001);
		assertEquals(50, recuperado.getValorDiaria(), 0.001);
		assertEquals(300, ((Carro) recuperado).getAutonomia());
	}

	@Test
	public void testeInserirCliente() throws ClienteJaCadastrado, ClienteNaoCadastrado, SQLException, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();
		Cliente cli1 = new Cliente(1234, "Zé Carlos");
		locadora.inserir(cli1);
		Cliente cli2 = locadora.pesquisarCliente(1234);
		assertEquals("Zé Carlos", cli2.getNome());
	}


	@Test
	public void testePesquisarMoto() throws VeiculoJaCadastrado, VeiculoNaoCadastrado, SQLException {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "AXQ-9111", 50);
		Veiculo moto2 = new Moto("Joca Motores", "Zulu", 1978, 10000, 30, "QUX-1234", 40);
		Veiculo moto3 = new Moto("Cálcio Motores", "Molar", 1985, 18000, 50, "WAA-3121", 50);

		locadora.inserir(moto1);
		locadora.inserir(moto2);
		locadora.inserir(moto3);

		ArrayList<Veiculo> motos50c = locadora.pesquisarMoto(50);

		assertEquals(2, motos50c.size());
	}

	@Test
	public void testePesquisarCaminhao() throws VeiculoJaCadastrado, VeiculoNaoCadastrado, SQLException {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, 30000, 70, "XXX-9111", 199);
		Veiculo caminhao2 = new Caminhao("Joca Motores", "Malbará", 1978, 45000, 80, "QQQ-1234", 300);
		Veiculo caminhao3 = new Caminhao("Cálcio Motores", "Incisivo", 1985, 60000, 90, "WWW-3210", 200);

		locadora.inserir(caminhao1);
		locadora.inserir(caminhao2);
		locadora.inserir(caminhao3);

		ArrayList<Veiculo> caminhoesCarga200 = locadora.pesquisarCaminhao(200);

		assertEquals(2, caminhoesCarga200.size());
	}

	@Test
	public void testeCalcularAluguel() throws VeiculoJaCadastrado, SQLException, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "XXX-9111", 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "ABC-1000",  400);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, 30000, 70, "SSS-1234", 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebara", 1975, 30000, 60, "III-4121", 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);

		double aluguelMoto = locadora.calcularAluguel("XXX-9111", 5);
		double aluguelCarro = locadora.calcularAluguel("ABC-1000", 5);
		double aluguelCaminhao = locadora.calcularAluguel("SSS-1234", 5);
		double aluguelOnibus = locadora.calcularAluguel("III-4121", 5);

		assertEquals(222.6, aluguelMoto, 0.01);
		assertEquals(258.22, aluguelCarro, 0.01);
		assertEquals(382.88, aluguelCaminhao, 0.01);
		assertEquals(382.19, aluguelOnibus, 0.01);

		try {
			assertEquals(0, locadora.calcularAluguel("X-999", 10), 0.01);
			fail("Não deveria calcular");
		} catch (VeiculoNaoCadastrado e) {
		}
	}

	@Test
	public void testeRegistrarAluguel() throws VeiculoJaCadastrado, VeiculoNaoCadastrado, ClienteNaoCadastrado, ClienteJaCadastrado, VeiculoAlugado, SQLException {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "AAA-1000",  400);
		Cliente cli1 = new Cliente(1234, "Zé Carlos");
		locadora.inserir(carro1);
		locadora.inserir(cli1);

		Date hoje = new Date();

		try {
			locadora.registrarAluguel("AAA-1000", hoje, 5, 1111);
			fail("Registrar aluguel indevido");
		} catch (ClienteNaoCadastrado e) {
		}

		locadora.registrarAluguel("AAA-1000", hoje, 5, 1234);

		try {
			locadora.registrarAluguel("AAA-1000", hoje, 5, 1234);
			fail("Registrar aluguel indevido");
		} catch (VeiculoAlugado e) {
		}

		try {
			locadora.registrarAluguel("AAA-1111", hoje, 5, 1234);
			fail("Registrar aluguel indevido");
		} catch (VeiculoNaoCadastrado e) {
		}
	}

	@Test
	public void testeRegistrarDevolucao()
			throws VeiculoJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado, ClienteJaCadastrado, VeiculoNaoAlugado, SQLException {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "AAA-1000",  400);
		Cliente cli1 = new Cliente(1234, "Zé Carlos");
		locadora.inserir(carro1);
		locadora.inserir(cli1);

		Date hoje = new Date();
		Date dev = new Date();
		dev.setDate(hoje.getDate()+5);

		locadora.registrarAluguel("AAA-1000", hoje, 5, 1234);
		locadora.registrarDevolucao("AAA-1000", dev, 1234);

		try {
			locadora.registrarDevolucao("AAA-1000", dev, 1234);
		} catch (VeiculoNaoAlugado e){

		}

		try {
			locadora.registrarDevolucao("AAA-1111", dev, 1234);
		} catch (VeiculoNaoCadastrado e) {

		}

	}

	@Test
	public void testeDepreciarVeiculos() throws VeiculoJaCadastrado, VeiculoNaoCadastrado, SQLException {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100",  400);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, 30000, 70, "S-123", 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebarã", 1975, 30000, 60, "I-412", 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);

		locadora.depreciarVeiculos(1, 0.1);
		locadora.depreciarVeiculos(2, 0.2);
		locadora.depreciarVeiculos(3, 0.05);
		locadora.depreciarVeiculos(4, 0.15);

		assertEquals(13500, locadora.pesquisar("X-911").getValorAvaliado(), 0.01);
		assertEquals(16000, locadora.pesquisar("A-100").getValorAvaliado(), 0.01);
		assertEquals(28500, locadora.pesquisar("S-123").getValorAvaliado(), 0.01);
		assertEquals(25500, locadora.pesquisar("I-412").getValorAvaliado(), 0.01);

		locadora.depreciarVeiculos(0, 0.1);

		assertEquals(12150, locadora.pesquisar("X-911").getValorAvaliado(), 0.01);
		assertEquals(14400, locadora.pesquisar("A-100").getValorAvaliado(), 0.01);
	}

	@Test
	public void testeQuantidadeTotalDeDiarias() throws VeiculoJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado, SQLException, ClienteJaCadastrado, VeiculoNaoAlugado {
		MinhaLocadora locadora = new MinhaLocadora();
		locadora.removerTudo();

		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100",  400);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, 30000, 70, "S-123", 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebarã", 1975, 30000, 60, "I-412", 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);

		Cliente cli1 = new Cliente(1234, "Zé Carlos");
		locadora.inserir(cli1);

		Date hoje = new Date();
		Date ontem = new Date(hoje.getTime() - 1);
		Date amanha = new Date(hoje.getTime() + 1);

		locadora.registrarAluguel("X-911", ontem, 5, 1234);
		locadora.registrarAluguel("A-100", ontem, 10, 1234);
		locadora.registrarAluguel("S-123", ontem, 7, 1234);
		locadora.registrarAluguel("I-412", ontem, 2, 1234);
		locadora.registrarDevolucao("X-911",  amanha, 1234);
		locadora.registrarDevolucao("A-100",  amanha, 1234);
		locadora.registrarDevolucao("S-123",  amanha, 1234);
		locadora.registrarDevolucao("I-412",  amanha, 1234);

		assertEquals(0, locadora.quantidadeTotalDeDiarias(1, hoje, amanha));
		assertEquals(0, locadora.quantidadeTotalDeDiarias(2, hoje, amanha));
		assertEquals(0, locadora.quantidadeTotalDeDiarias(3, hoje, amanha));
		assertEquals(0, locadora.quantidadeTotalDeDiarias(4, hoje, amanha));
		assertEquals(0, locadora.quantidadeTotalDeDiarias(0, hoje, amanha));
	}

}