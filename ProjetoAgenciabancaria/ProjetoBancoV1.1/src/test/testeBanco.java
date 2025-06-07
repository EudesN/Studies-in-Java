package test;

import programa.Conta;
import programa.Pessoa;

import java.awt.event.PaintEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class testeBanco {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> listaContas;

    public static void main(String[] args) {
        listaContas = new ArrayList<>();

        while (true){
            menu();
        }
    }

    public static void menu() {
        System.out.println("*********************************************************");
        System.out.println("* *");
        System.out.println("* ██████╗   █████╗  ███╗   ██╗ ██████╗  ██████╗         *");
        System.out.println("* ██╔══██╗ ██╔══██╗ ████╗  ██║██╔════╝ ██╔═══██╗        *");
        System.out.println("* ██████╔╝ ███████║ ██╔██╗ ██║██║      ██║   ██║        *");
        System.out.println("* ██╔══██╗ ██╔══██║ ██║╚██╗██║██║      ██║   ██║        *");
        System.out.println("* ██████╔╝ ██║  ██║ ██║ ╚████║╚██████╗ ╚██████╔╝        *");
        System.out.println("* ╚═════╝  ╚═╝  ╚═╝ ╚═╝  ╚═══╝ ╚═════╝  ╚═════╝         *");
        System.out.println("* *");
        System.out.println("*********************************************************");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("----------------------------------------------------");
        System.out.println("| Opção 1 - Criar conta                            |");
        System.out.println("| Opção 2 - Depositar                              |");
        System.out.println("| Opção 3 - Sacar                                  |");
        System.out.println("| Opção 4 - Transferir                             |");
        System.out.println("| Opção 5 - Listar                                 |");
        System.out.println("| Opção 0 - Sair                                   |");
        System.out.println("----------------------------------------------------");

        System.out.printf("Informe a opção: ");
        int op = input.nextInt();

        switch (op) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");

        }

    }

    public static void criarConta() {
        System.out.println("Nome: ");
        String nome = input.next();

        System.out.println("Conta: ");
        int numConta = input.nextInt();

        System.out.println("CPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(cpf, nome, email);
        Conta conta = new Conta(numConta, pessoa);

        listaContas.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");
    }

    private static Conta encontrarConta(int numConta) {
        Conta conta = null;
        if (listaContas.size() > 0) {
            for(Conta c : listaContas){
               if(c.getNum() == numConta){
                   return c; // retorna a conta assim q sai do metodo
               }
            }
        }
        return null;
    }

    public static void depositar(){
        System.out.println("Conta: ");
        int numConta = input.nextInt();

        Conta conta = encontrarConta(numConta);

        if(conta != null){
            System.out.println("Qual o valor do deposito?");
            double valDeposito = input.nextDouble();
            conta.depositar(valDeposito);
            System.out.println("Valor depositado com sucesso.");
        }
        else{
            System.out.println("Conta não foi encontrada");

        }
    }

    public static void sacar(){
        System.out.println("Conta: ");
        int numConta = input.nextInt();

        Conta conta = encontrarConta(numConta);

        if(conta != null){
            System.out.println("Qual o valor do sacar?");
            double valSaque = input.nextDouble();
            conta.sacar(valSaque);
            System.out.println("Valor sacado com sucesso.");
        }
        else{
            System.out.println("Conta não foi encontrada");

        }
    }

    public static void transferir(){
        System.out.println("Conta Remetente: ");
        int numContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numContaRemetente);

        if(contaRemetente != null){
            System.out.println("Conta Destinatário: ");
            int numContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numContaDestinatario);

            if(contaDestinatario != null){
                System.out.print("Informe o valor da transferência: R$ ");
                double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }
            else {
                System.out.println("Conta do destinatário não encontrada.");
            }
        }
        else{
            System.out.println("Conta do remetente não encontrada.");
        }
    }

    public static void listarContas(){
        if(listaContas.size() > 0){
            for(Conta conta : listaContas){
                System.out.println(conta);
            }
        }
        else{
            System.out.println("Não há contas cadastradas.");
        }
    }

}