import java.util.Scanner;

public class Media {
    public static void main(String[] args){
        double nota1, nota2, nota3;
        Scanner scanner = new Scanner(System.in); // cria um objeto scanner

        System.out.println("Informe a primeira nota: ");
        nota1 = scanner.nextDouble();

        System.out.println("Informe a segunda nota: ");
        nota2 = scanner.nextDouble();

        System.out.println("Informe a terceira nota: ");
        nota3 = scanner.nextDouble();

        double mediaFinal = (nota1 + nota2 + nota3) / 3;

        if(mediaFinal < 6){
            System.out.println("Reprovado");
        }
        else if(mediaFinal > 6){
            System.out.println("Aprovado");
        }
        else{
            System.out.println("Aprovado na media");
        }
        scanner.close(); // Fecha o Scanner para evitar vazamento de memória
    }
}
