import java.util.Scanner;

public class AnoBissexto{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Informe o ano: ");
        int ano = scanner.nextInt();

        if((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)){
            System.out.println("Bissexto");;
        }
        scanner.close();    
    }
}
