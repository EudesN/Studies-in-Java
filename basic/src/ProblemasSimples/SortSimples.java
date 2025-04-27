package ProblemasSimples;
import java.util.Scanner;

public class SortSimples {
    public static void main(String[] args) {
        int n1, n2, n3, temp;
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o primeiro valor: ");
        n1 = input.nextInt();

        System.out.println("Informe o segunda valor: ");
        n2 = input.nextInt();

        System.out.println("Informe o terceira valor: ");
        n3 = input.nextInt();

        int orgN1, orgN2, orgN3;
        orgN1 = n1;
        orgN2 = n2;
        orgN3 = n3;

        if(n1 > n2 ){
            temp = n1;  
            n1 = n2;
            n2 = temp;
        }
        if(n1 > n3){
            temp = n1;
            n1 = n3;
            n3 = temp;
        }
        if(n2 > n3){
            temp = n2;
            n2 = n3;
            n3 = temp;
        }


        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println("");
        System.out.println(orgN1);
        System.out.println(orgN2);
        System.out.println(orgN3);
    }
}
