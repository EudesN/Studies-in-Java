public class OrdenarNumeros {
    public static void main(String[] args) {
        
        int total = 0;
        int nTemporario;
        int[] vetor = {37, 92, 28, 55, 64, 1, 70, 14, 8, 94, 3, 42, 82, 29, 16, 89, 30, 76, 63, 87, 43, 46, 26, 67, 53, 99, 21, 31, 71, 97, 
            35, 80, 36, 20, 85, 90, 77, 48, 59, 60, 100, 5, 32, 74, 39, 23, 56, 12, 33, 25, 98, 44, 9, 7, 18, 96, 66, 47, 4, 81, 40, 6, 11, 
            41, 13, 95, 15, 62, 86, 34, 19, 65, 22, 78, 79, 51, 27, 54, 50, 57, 83, 2, 17, 45, 61, 49, 38, 24, 58, 68, 75, 10, 93, 52, 84, 88, 
            72, 91, 73, 69};

        for(int i = 0; i < vetor.length - 1; i++) {
            for(int j = 0; j < vetor.length - 1 - i; j++) {
                if(vetor[j] > vetor[j + 1]) {
                    nTemporario = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = nTemporario;
                }
            }
        }
        for(int i = 0; i < vetor.length - 1; i++){
            if(vetor[i] < vetor[i + 1]){
                total++;    
            }
        }
        if(total == vetor.length - 1){
            System.out.println("Array ordenado:");
            for (int num : vetor) {
                System.out.print(num + ", ");
            }
        }
    }
}
