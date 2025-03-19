import java.util.Scanner;

import static Metodo.dominio.Retangulo2.retangulo2;

public class Metodo2 {
    public static void main(String[] args) {

        double base, alt;

        Scanner input = new Scanner(System.in);

        System.out.print("Informe a base do retangulo: ");
        base = input.nextDouble();

        System.out.print("Informe a altura do retangulo: ");
        alt = input.nextDouble();

        double areaRetangulo = retangulo2(base, alt);
        System.out.println("A área do retângulo é " + areaRetangulo);

        input.close();
    }
}
