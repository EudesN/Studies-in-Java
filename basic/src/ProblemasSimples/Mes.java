package ProblemasSimples;

import java.util.Scanner;

public class Mes {
    public static void main(String[] args) {
        int opcao;
        Scanner input = new Scanner(System.in);
        String[] meses = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        opcao = input.nextInt();
        
        for(int i = 0; i < meses.length; i++){
            if(opcao == i + 1){
                System.out.println(meses[i]);
            }
        }
        input.close();
    }
}
