package Metodo.dominio;
import java.util.Scanner;

public class Retangulo{
    public static void retangulo(){
        Scanner input = new Scanner(System.in);
        double alt, base, areaRetangulo, areaTotal = 0;

        System.out.println("Informe a base do retangulo: ");
        base = input.nextDouble();

        System.out.println("Informe a altura do retangulo: ");
        alt = input.nextDouble();

        areaRetangulo = base * alt;

        System.out.println("A área do 1 retângulo é " + areaRetangulo);
        areaTotal += areaRetangulo;

        System.out.println("A área total é " + areaTotal);
        input.close();
    }
}

