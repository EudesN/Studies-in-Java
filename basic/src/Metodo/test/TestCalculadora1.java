package Metodo.test;

import Metodo.dominio.Calculadora;
import java.util.Scanner;

public class TestCalculadora1 {
    public static void main(String[] args) {
        int opera, cont = 0;
        double num1 = 0, num2 = 0;

        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        do{
            cont++;

            if(cont == 1){
                System.out.println("Informe o primeiro número: ");
                num1 = scanner.nextDouble();
                System.out.println("Informe o segundo número: ");
                num2 = scanner.nextDouble();
            }

            System.out.println("-----------Menu de opções-----------");
            System.out.println("1- Soma");
            System.out.println("2- Subtração");
            System.out.println("3- Multiplicação");
            System.out.println("4- Divisão");
            System.out.println("5- Número maior");
            System.out.println("6- Alterar números");
            System.out.println("0- Sair");
                    System.out.println("------------------------------------");

            System.out.print("Informe a opção: ");
            opera = scanner.nextInt();

            switch (opera){
                case 1:
                    calculadora.somaDoisNum(num1, num2);
                    break;
                case 2:
                    calculadora.subtraiDoisNum(num1, num2);
                    break;
                case 3:
                    calculadora.multiDoisNum(num1, num2);
                    break;
                case 4:
                    calculadora.dividirDoisNum(num1, num2);
                    break;
                case 5:
                    double maior = calculadora.maiorDoisNum(num1, num2);
                    System.out.println("O maior número é " + maior);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 6:
                    System.out.println("Informe o novo primeiro número: ");
                    num1 = scanner.nextDouble();

                    System.out.println("Informe o novo segundo número: ");
                    num2 = scanner.nextDouble();
                    break;
                default:
                    System.out.println("Operação inválida");
            }
        }while(opera != 0);


        scanner.close();
    }
}
