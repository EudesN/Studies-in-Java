package ProblemasSimples;
public class IncrementoDecremento {
    public static void main(String[] args) {
        int a = 10;
        int b = a++;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        b = ++a;
        System.out.println("b = " + b);


    }
}
