package main;
import objetos.Objeto;

public class Main {
    public static void main(String[] args) {
        Objeto objeto1 = new Objeto();
        Objeto objeto2 = new Objeto();

        objeto1.nome = "Geladeira";
        objeto1.modelo = "Eletrolux";
        objeto1.ano = 2016;

        objeto2.nome = "Micro-Ondas";
        objeto2.modelo = "LG";
        objeto2.ano = 2024;

        System.out.println("Informações sobre o Objeto 1:");
        System.out.println("Nome: "+ objeto1.nome);
        System.out.println("Modelo: "+ objeto1.modelo);
        System.out.println("Ano de fabricação: "+ objeto1.ano);

        System.out.println("Informações sobre o Objeto 2:");
        System.out.println("Nome: "+ objeto2.nome);
        System.out.println("Modelo: "+ objeto2.modelo);
        System.out.println("Ano de fabricação: "+ objeto2.ano);

    }
}