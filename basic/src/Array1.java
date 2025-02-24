public class Array1 {
    public static void main(String[] args) {
        int numAlunos = 5;
        double[] notaAlunos = new double[numAlunos];

        notaAlunos[0] = 6.7;
        notaAlunos[1] = 5.7;
        notaAlunos[2] = 7.8;
        notaAlunos[3] = 9.9;
        notaAlunos[4] = 1.0;

        for(int i = 0; i < numAlunos;i++){
            System.out.println("Nota do "+ (i+1)+ "° aluno é: " + notaAlunos[i]);
        }
    }
}