public class Main {
    public static void main(String[] args) {
        TV televisao1 = new TV();

        System.out.println("Essa televisão é da marca "+ televisao1.fabricante);
        System.out.println("A televisão está " + (televisao1.ligado == true ? "ligada": "desligada"));
        System.out.println("O volume é " + televisao1.volume);
        System.out.println("");

        televisao1.ligar();
        televisao1.aumentarVolume();
        televisao1.aumentarVolume();

        System.out.println("Essa televisão é da marca "+ televisao1.fabricante);
        System.out.println("A televisão está " + (televisao1.ligado == true ? "ligada": "desligada"));
        System.out.println("O volume é " + televisao1.volume);

    }
}