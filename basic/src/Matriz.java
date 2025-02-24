import java.util.Scanner;

public class Matriz {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double[][] vetor = new double[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                vetor[i][j] = input.nextDouble();
                
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(vetor[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        input.close();
    }
}
