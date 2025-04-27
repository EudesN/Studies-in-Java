package Metodo.dominio;

public class OrdenacaoDecrescente {
    public static int[] vetorDecrescente(int[] vetor) {
        int aux;
        for(int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] < vetor[j + 1]) {
                    aux = vetor[j + 1];
                    vetor[j + 1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        return vetor;
    }
}
