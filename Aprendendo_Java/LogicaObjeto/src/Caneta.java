public class Caneta {
    String modelo;
    String cor;
    Float ponta;
    int carga;
    boolean tampada;

    void status(){
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Uma caneta " + this.cor );
        System.out.println("Ponta: " +  this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Está tampada? " + this.tampada);

    }
    void rabiscar(){
        if(this.tampada == true){
            System.out.println("Erro! Não é possível rabiscar com a caneta tampada.");
        } else{
            System.out.println("Rabiscando...");
        }
    }
    void tampar(){
        this.tampada = true;
    }
    void destampar(){
        this.tampada = false;
    }

}
