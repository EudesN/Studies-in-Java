import java.util.Scanner;
import java.text.DecimalFormat;

public class DescontoInteligente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valorOriginal = scanner.nextDouble();
        double desconto = scanner.nextDouble();

        if (desconto < 0 || desconto > 100) {
            System.out.println("Desconto invalido");
        } else {
            double valorFinal = valorOriginal * (1 - desconto / 100);

            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(valorFinal));
        }

        scanner.close();
    }
}
