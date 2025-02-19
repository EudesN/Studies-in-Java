import java.util.Scanner;

public class VariavelConstante {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final double PI = 3.14159; // não pode ser alterada
        double r;

        System.out.println("Informe o valor do raio: ");
        r = scanner.nextDouble();

        double area = r * r * PI;
        System.out.println("A area é "+ area);
        scanner.close();
    }
}
