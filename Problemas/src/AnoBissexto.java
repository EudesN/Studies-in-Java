import java.util.Scanner;

public class AnoBissexto{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int ano = scanner.nextInt();

        boolean anoBissexto = false;

        
        if(ano % 400 == 0){
            if(ano % 55 == 0){
                System.out.println("This is bulukulu festival year.");
                return;
            }
            System.out.println("This is leap year.");
            return;
        }
        else{
            if(ano % 4 == 0 && ano % 100 != 0){
                if(ano % 55 == 0){
                    System.out.println("This is bulukulu festival year.");
                    return;
                }
                System.out.println("This is leap year.");
                return;
            }
        }
        if(ano % 15 == 0){
            System.out.println("This is huluculu festival year.");
            return;
        }
        System.out.println("This is a ordinary year.");
    }
}
