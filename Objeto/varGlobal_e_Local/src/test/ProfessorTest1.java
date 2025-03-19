package test;

import dominio.Estudante;
import dominio.Professor;

public class ProfessorTest1 {
    public static void main(String[] args){
        Professor professor = new Professor();
        professor.nome = "Márcio";
        professor.idade = 44;
        professor.sexo = 'M';

        System.out.println("Nome do professor: "+ professor.nome);
        System.out.println("Idade do professor: "+ professor.idade);
        System.out.println("Sexo do professor: "+ professor.sexo);
    }
}
