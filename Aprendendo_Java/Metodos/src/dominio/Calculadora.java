package dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {
    public int n1, n2;
    Scanner input = new Scanner(System.in);
    public void somarDoisNum(int n1, int n2){
        System.out.println(n1 + n2);
    }

    public void subtrairDoisNum(int n1, int n2){
        System.out.println(n1 - n2);
    }

    public void dividirDoisNum(int n1, int n2){
        if(n2 == 0){
            System.out.println("Não existe divisão por 0.");
            return;
        }
        System.out.println(n1 / n2);
    }

    public void multiplicarDoisNum(int n1, int n2){
        System.out.println(n1 * n2);
    }

    public void alterarDoisNum(int n1, int n2){
        System.out.print("Informe o novo primeiro número: ");
        n1 = input.nextInt();
        System.out.print("Informe o novo segundo número: ");
        n2 = input.nextInt();

    }
    public void somarArray(){
        ArrayList<Integer> numeros = new ArrayList<>();
        while (true){
            System.out.print("Informe um número: ");
            int n = input.nextInt();
            numeros.add(n);
            System.out.print("Deseja adicionar mais um número a soma[S/N]?");
            char op = input.next().charAt(0);
            if(op == 'N' || op == 'n'){break;}
            else if (op != 'S' || op != 's') {
                System.out.println("Opção inválida.");
                break;
            }
        }
        int soma = 0;
        for(int num : numeros){
            soma += num;
        }
        System.out.println("A soma total dos números é: " + soma);
    }

    public void somarVarArgs(){

    }

}
