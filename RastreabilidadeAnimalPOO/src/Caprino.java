import java.time.LocalDate;
import java.time.Period;

public class Caprino extends Animal{

    public Caprino(int numero, String nome, LocalDate dataNascimento, int genero, double valorCompra, double valorVenda, boolean status) {
        super(numero, nome, dataNascimento, genero, valorCompra, valorVenda, status);
    }

    public boolean isAdulto(){
        return Period.between(dataNascimento, LocalDate.now()).toTotalMonths() >= 18;
    }
}
