package banco;

import java.util.Date;

public class Operacao {
	
	private Date data;
	private int numero;
	private double valor;
	private double saldo;
	private String tipo;
	

	public Operacao(Date dt, int num, double val, double sal, String tp) {
		data = dt;
		numero = num;
		valor = val;
		saldo = sal;
		tipo = tp;
	}


	public Date getData() {
		return data;
	}

	public int getNumero() {
		return numero;
	}


	public double getValor() {
		return valor;
	}


	public double getSaldo() {
		return saldo;
	}


	public String getTipo() {
		return tipo;
	}
	
}
