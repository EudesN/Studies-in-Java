public class UnixTime {
    public static void main(String[] args){
        long totalMilisegundos = System.currentTimeMillis() - 10800000;

        long totalSegundos = totalMilisegundos / 1000;
        long segundoAtual = totalSegundos % 60;

        long totalMinuto = totalSegundos / 60;
        long minutoAtual = totalMinuto % 60;

        long totalHoras = totalMinuto / 60;
        long horaAtual = totalHoras % 24;

        System.out.println("A hora atual é:" + horaAtual + ":" + minutoAtual + ":" + segundoAtual);
    }
}
