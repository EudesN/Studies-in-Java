package ProblemasSimples;
import java.util.Scanner;

public class Matriz {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double[][] vetor = new double[3][3];

        for(int i = 0; i < vetor.length; i++){
            for(int j = 0; j < vetor[i].length; j++){
                vetor[i][j] = input.nextDouble();
                
            }
        }

        for(int i = 0; i < vetor.length; i++){
            for(int j = 0; j < vetor[i].length; j++){
                System.out.print(vetor[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        input.close();
    }
}
