package ProblemasSimples;
public class Array2 {
    public static void main(String[] args) {
        double[] notaAlunos = new double[5];
        

        notaAlunos[0] = 6.7;
        notaAlunos[1] = 5.7;
        notaAlunos[4] = 10.0;
        java.util.Arrays.fill(notaAlunos, 2,4, 1 );

        for(int i = 0; i < notaAlunos.length;i++){
            System.out.println("Nota do "+ (i+1)+ "° aluno é: " + notaAlunos[i]);
        }
    }
}