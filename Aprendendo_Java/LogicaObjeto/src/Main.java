public class Main {
    public static void main(String[] args) {
        Caneta c1 = new Caneta();
        c1.cor = "Azul";
        c1.ponta = 0.5f; // referencia a atributo
        c1.tampar();

        c1.status(); // referencia a metodo
        c1.rabiscar();

        Caneta c2 = new Caneta();
        c2.modelo = "Hostnet";
        c2.cor = "Preta";

        c2.destampar();
        c2.status();
        c2.rabiscar();

    }
}