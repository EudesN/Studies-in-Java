package pedroSantosNeto.banco.main;

import java.util.Date;

public class Extrato {
	
	private Operacao[] lancamentos = new Operacao[10];
	private int pos = 0;
	
	public void adicionarOperacao(Date dt, int num, double val, double sal, String tp) {
		   Operacao op = new Operacao(null, num, val, sal, tp);
		   lancamentos[pos++] = op;
	}
		
	public String toString() {
		String resultado = "";
		for (int i = 0; i < pos; i++) {
			resultado = resultado + "\nConta: " + lancamentos[i].getNumero() + 
					". " + lancamentos[i].getTipo() + ": " + lancamentos[i].getValor() + 	
					". Saldo: " + lancamentos[i].getSaldo();
		}
		return resultado;
	}

	public double totalDeLancamentos(String tp) {
		double soma = 0;
		for (int i = 0; i < pos; i++) {
           if (lancamentos[i].getTipo() == tp) {
        	   soma = soma + lancamentos[i].getValor();
           }
		}
		return soma;
	}

}
