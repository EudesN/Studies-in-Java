public class MetodoVetor {
    public static void main(String[] args){
        int[] abc ={1, 2, 3, 4, 5};
        int x = 10;

         vetor(abc);
         System.out.println(abc[0]);
        System.out.println(x);
    }

    public static void vetor(int[] x){
        x[0] = 200;
    }
    public static void variavelPrimitiva(int x){
        x = 200;
    }
}
