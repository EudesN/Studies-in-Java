package programa;

import java.util.Date;

public class Operacao { // operacao é o equivalente ao metodo transacao
    private Date data;
    private int numero;
    private  double valor;
    private double saldo;
    private String tipo;

    public Operacao(Date dt, int num,double val, double sal, String tp){
        data = dt;
        numero = num;
        valor = val;
        saldo = sal;
        tipo = tp;
    }

    public Date getData(){ return data;}

    public int getNumero(){return numero;}

    public double getSaldo() {return saldo;}

    public double getValor() {return valor;}

    public String getTipo() {return tipo;}

}
