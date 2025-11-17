public class EntradaMeia extends Entrada {
    public double calculaValor(){
        return getEspetaculo().getPreco() * 0.5;
    }
}
