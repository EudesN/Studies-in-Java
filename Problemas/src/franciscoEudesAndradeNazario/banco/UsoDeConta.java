package banco;

public class UsoDeConta {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "Raimundo");
		
		Conta c1 = new Conta(1, p1);
		Conta c2 = new Conta(2, p2);
		
		c1.credito(100);
		c1.credito(9);
		c1.debito(10);
		c1.debito(-1);
		c1.debito(1);

		System.out.println(c1.getDono().getNome());
		
		c2.credito(100);
		c2.credito(22);
		c2.debito(21);
		c2.debito(11);
		c2.debito(150);
		
		System.out.println(c1.getExtrato());
		System.out.println("Creditos C1:" + c1.totalDeLancamentos("Credito"));
		System.out.println("Debitos C1:" + c1.totalDeLancamentos("Debito"));
		System.out.println(c2.getExtrato());		
		System.out.println("Creditos C2:" + c2.totalDeLancamentos("Credito"));
		System.out.println("Debitos C2:" + c2.totalDeLancamentos("Debito"));
	}
}
