import java.util.Scanner;

public class IntroStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é o seu primeiro nome?");
        String primeiroNome = scanner.nextLine();

        System.out.println("Qual o seu último nome?");
        String ultimoNome = scanner.nextLine();

        System.out.println("Qual sua idade?");
        int idade = scanner.nextInt();

        System.out.println("Olá, " + primeiroNome + " " + ultimoNome + " de " + idade + " anos");
        scanner.close();
    }
}
