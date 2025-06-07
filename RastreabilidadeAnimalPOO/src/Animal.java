import java.time.LocalDate;

public abstract class Animal {
    protected int numero;
    protected String nome;
    protected int diaNascimento, mesNascimento, anoNascimento;
    protected int genero;
    protected LocalDate ultimaVacinacao;
    protected Fazenda fazendaAssociada;
    protected double valorCompra;
    protected double valorVenda;
    protected boolean status;

    public Animal(int numero, String nome, LocalDate dataNascimento, int genero, double valorCompra, double valorVenda, boolean status){
        this.numero = numero;
        this.nome = nome;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.genero = genero;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.status = true;
    }

    public Animal() {
    }

    public void vacina(){
        LocalDate hoje = LocalDate.now();
        this.diaNascimento = hoje.getDayOfMonth();
        this.mesNascimento = hoje.getMonthValue();
        this.anoNascimento = hoje.getYear();
    }

    public void abate(){
        this.status = false;
    }

    public void morte(){
        this.status = false;
    }

    public boolean podeSerComercializado(){
        boolean Adulto = this.isAdulto();
        boolean vacidoEsteAno = (this.anoVacinacao == LocalDate.now().getYear());
        return isAdulto() && vacidoEsteAno && this.status;
    }

    public abstract boolean isAdulto();

    public int getIdadeEmMeses(){
        LocalDate hoje = LocalDate.now();
        LocalDate dataNasc = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);
        return (int) java.time.temporal.ChronoUnit.MONTHS.between(dataNasc, hoje);
    }

    public String getNome() {
        return nome;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public Fazenda getFazendaAssociada() {
        return fazendaAssociada;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public int getGenero() {
        return genero;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getUltimaVacinacao() {
        return ultimaVacinacao;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
