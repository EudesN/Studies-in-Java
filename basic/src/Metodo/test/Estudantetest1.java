package Metodo.test;

import Metodo.dominio.Estudante;
import Metodo.dominio.ImpressoraEstudante;

public class Estudantetest1 {
    public static void main(String[] args){
        Estudante estudante1 = new Estudante();
        Estudante estudante2 = new Estudante();
        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante1.nome = "Pedro";
        estudante1.idade = 19;
        estudante1.sexo = 'M';

        estudante2.nome = "Maria";
        estudante2.idade = 14;
        estudante2.sexo = 'F';

        estudante1.imprime();
        System.out.println("-----------------------------------------");
        estudante2.imprime();

        impressora.imprime(estudante1); // um metodo para imprimir as informações
    }
}
