package ProblemasSimples;

import java.util.Scanner;

public class Multiplo {
    public static void main(String[] args) {
        int n1, n2;
        Scanner input = new Scanner(System.in);
        n1 = input.nextInt();
        n2 = input.nextInt();

        if(n1 % n2 == 0 || n2 % n1 == 0){
            System.out.println("Sao Multiplos");
        }
        else{
            System.out.println("Nao sao Multiplos");
        }

        input.close();
    }
}
