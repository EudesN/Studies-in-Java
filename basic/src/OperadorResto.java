import java.util.Scanner;

public class OperadorResto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        
        System.out.println("Informe um número: ");
        x = scanner.nextInt();

        if(x % 2 == 0){
            System.out.println("O numero " + x + " é par");
        }
        else{
            System.out.println("O número " + x + " é ímpar");
        }
        scanner.close();
    }
}
