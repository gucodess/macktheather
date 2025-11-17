public abstract class Entrada {
    private int numeroDoAssento;
    private Espetaculo espetaculo;
    public abstract double calculaValor();
    
    public Entrada(){}
    
    public int getNumeroDoAssento() {return numeroDoAssento;}
    public void setNumeroDoAssento(int numeroDoAssento) {this.numeroDoAssento = numeroDoAssento;}
    
    public Espetaculo getEspetaculo() {return espetaculo;}
    public void setEspetaculo(Espetaculo espetaculo) {this.espetaculo = espetaculo;}
}
