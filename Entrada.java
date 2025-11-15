public abstract class Entrada {
    private int numeroDoAssento;
    public abstract double calculaValor();

    public Entrada(){}

    public int getNumeroDoAssento() {
        return numeroDoAssento;
    }

    public void setNumeroDoAssento(int numeroDoAssento) {
        this.numeroDoAssento = numeroDoAssento;
    }

}
