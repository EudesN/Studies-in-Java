package Metodo.dominio;

public class Calculadora {

    public void somaDoisNum(double num1, double num2){
        System.out.println(num1 + num2);
    }

    public void subtraiDoisNum(double num1, double num2){
        System.out.println(num1 - num2);

    }

    public void multiDoisNum(double num1, double num2){
        System.out.println(num1 * num2);

    }

    public void dividirDoisNum(double num1, double num2){
        System.out.println(num1 / num2);

    }
    public double maiorDoisNum(double num1, double num2){
        if(num1 > num2){
            return num1;
        }
        else{
            return num2;
        }
    }
}
