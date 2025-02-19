import java.util.Scanner;

public class IntroStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é o seu primeiro nome?");
        String primeiroNome = scanner.next();
        System.out.println("Qual o seu último nome?");
        String ultimoNome = scanner.next();



        System.out.println(primeiroNome + " " + ultimoNome);
    }
    
}
