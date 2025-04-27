package ProblemasSimples;
public class vetor {
    public static void main(String[] args) {
        double[] vetor = new double[10];
        vetor[0] = 10.4;
        vetor[1] = 111.5;
        vetor[2] = 53.3;
        vetor[3] = 99.9;

        System.out.println("Usando for-each:");
        for(double n: vetor){
            System.out.println(n);
        }
        System.out.println("\nUsando for tradicional:");
        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }

    }
}
