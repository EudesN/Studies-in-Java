package test;

import dominio.Calculadora;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora01 {
    public static void main(String[] args) {
        int op, n1 = 0, n2 = 0;
        Scanner input = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.print("Informe o primeiro número: ");
        n1 = input.nextInt();
        System.out.print("Informe o segundo número: ");
        n2 = input.nextInt();

        while(true) {
            System.out.println("-------------------------");
            System.out.println("1- somar");
            System.out.println("2- subtrair");
            System.out.println("3- dividir");
            System.out.println("4- multiplicar");
            System.out.println("5- alterar números");
            System.out.println("6- soma arrays");
            System.out.println("0- sair");
            System.out.println("-------------------------");
            op = input.nextInt();


            if (op == 1) {
                calculadora.somarDoisNum(n1, n2);
            } else if (op == 2) {
                calculadora.subtrairDoisNum(n1, n2);
            }
            else if (op == 3) {
                calculadora.dividirDoisNum(n1, n2);
            }
            else if (op == 4) {
                calculadora.multiplicarDoisNum(n1, n2);
            }
            else if (op == 5) {
                calculadora.alterarDoisNum();
            }
            else if (op == 6) {
                calculadora.somarArray();
            }
            else if (op == 0) {
                System.out.println("encerrando...");
                break;
            }
        }
    }

}
