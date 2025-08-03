package ObjetoBasico;

public class Caneta {
    String modelo;
    String cor;
    double ponta;
    boolean tampada;

    public void rabiscar(){
        if(this.tampada == true){
            System.out.println("Erro: Não é possivel rabiscar com a tampa fechada.");
        }
        else{
            System.out.println("Estou Rabiscando");
        }
    }

    public void tampar(){
        this.tampada = true;
    }
    public void destampar(){
        this.tampada == false;
    }
}
