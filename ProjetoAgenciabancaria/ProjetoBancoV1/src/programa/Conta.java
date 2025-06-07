package programa;

import utilitarios.Utils;

public class Conta {

    private int num;
    private double saldo = 0.0;
    private Pessoa dono;
    // protected Extrato extrato = new Extrato();

    public Conta(int n, Pessoa p){
        this.num = n;
        this.dono = p;
    }
    public int getNum(){return num;}
    public double getSaldo(){return saldo;}
    public Pessoa getDono(){return dono;}
    // public Extrato getExtrato(){extrato.toString();}

    public String toString(){
        return "\nConta: " +this.getNum() +
                "\nNome: " +this.dono.getNome() +
                "\nCPF: " +this.dono.getCPF() +
                "\nEmail: " + this.dono.getEmail() +
                "\nSaldo: " + Utils.doubleToString(saldo)+
                "\n";
    }

    public void depositar(double valor){
        if(valor > 0){
            this.saldo = getSaldo() + valor;
            //System.out.println("Deposito realizado com sucesso.");
        }
        else{
            // System.out.println("Não foi possível realizar o depósito.");
        }
    }

    public void sacar(double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            this.saldo = getSaldo() - valor;
        }
        else{
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void transferir(Conta destinatario, double valor){
        if(valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            destinatario.saldo = destinatario.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso.");
        }
        else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

}
