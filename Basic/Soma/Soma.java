package Basic.Soma;

import java.util.Scanner; // Importa a classe Scanner para capturar entrada do usuário

public class Soma {
    public static void main(String[] args) {
        // Cria um objeto Scanner para leitura dos dados do teclado
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o primeiro número
        System.out.print("Digite o primeiro número: ");
        int numero1 = scanner.nextInt(); // Lê um número inteiro

        // Solicita ao usuário o segundo número
        System.out.print("Digite o segundo número: ");
        int numero2 = scanner.nextInt(); // Lê outro número inteiro

        // Realiza a soma dos dois números
        int soma = numero1 + numero2;

        // Exibe o resultado da soma
        System.out.println("A soma de " + numero1 + " e " + numero2 + " é: " + soma);

        // Fecha o scanner
        scanner.close();
    }
}
