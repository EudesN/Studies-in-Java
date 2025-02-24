import java.util.Scanner;
import java.util.Random;

public class AcerteNumero{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        boolean acertou = false;
        int tentativas = 10;
        int numeroSecreto = random.nextInt(100);
        long chute = 0;

        while (tentativas > 0 && acertou == false){
            System.out.println("Qual seu palpite?");
            chute = input.nextLong();

            if(numeroSecreto == chute){
                System.out.println("Você acertou!");
                acertou = true;
            }
            else if(chute < numeroSecreto){
                --tentativas;
                System.out.println("Número muito pequeno");
            }
            else{
                --tentativas;
                System.out.println("Número muito grande");
            }
        }
        if(acertou == false){
            System.out.println("Você perdeu!");
        }
        input.close();
    }
}
