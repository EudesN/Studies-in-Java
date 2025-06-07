import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fazenda {
    int identificador;
    String nome;
    List<Animal> rebanho;

    public Fazenda(int identificador, String nome){
        this.identificador = identificador;
        this.nome = nome;
        this.rebanho = new ArrayList<>();
    }

    public void compra(Animal a){
        this.animais.add(a);
        a.setFazendaAssociada(this);
    }

    public Animal venda(int numAnimal){
        Animal animal = encontrarAnimal(numAnimal);

        if(animal.podeSerComercializado() && animal != null){
            return animal; // desativa o animal na fazenda
        }
        return null;
    }

    public void abate(int numAnimal){
        Animal animal = encontrarAnimal(numAnimal);
        if(animal != null){
            animal.abate();
            animal.dataEvento = new LocalDate.now();
        }
    }


    public boolean cadastrarAnimal(Animal a){
        for(Animal a : animais){
            if(a.getNumero() == a.getNumero()){
                return false;
            }
        }

        this.animais.add(a);
        a.setFazendaAssociada(this);
        return true;
    }



    public void morte(int numAnimal){}

    public Animal encontrarAnimal(int numAnimal){
        Animal animal = encontrarAnimal(numAnimal);
        if(animal != null){
            animal.morte();
        }
    }



}
