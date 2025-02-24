import java.util.Scanner;

public class Metodo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Criando Scanner no main()
        double areaTotal = 0; // Variável para somar as áreas

        areaTotal += retangulo(input); // Chamando o método e somando a área
        areaTotal += retangulo(input);

        System.out.println("A área total é " + areaTotal);

        input.close(); // Fechando o Scanner no final do programa
    }

    public static double retangulo(Scanner input) { // Passando Scanner como parâmetro
        double alt, base, areaRetangulo;

        System.out.println("Informe a base do retângulo: ");
        base = input.nextDouble();

        System.out.println("Informe a altura do retângulo: ");
        alt = input.nextDouble();

        areaRetangulo = base * alt;
        System.out.println("A área do retângulo é " + areaRetangulo);

        return areaRetangulo; // Retornando a área calculada
    }
}
