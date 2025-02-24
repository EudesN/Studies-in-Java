import java.util.Scanner;

public class Break_Continue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe um número de 0 a 100:");
        int n = input.nextInt();

        for(int i = 0; i < 100; i++){
            if(i == n){ 
                System.out.println("O seu número é "+ i);
                // break; // Sai do loop quando encontrar o número
            }
            else{
                System.out.println("O seu não número é "+ i);
                continue; // Volta para o início do loop
            }
            System.out.println("XXXXXXXXXXXX");
        }
        input.close();
    }
}
