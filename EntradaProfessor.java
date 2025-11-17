public class EntradaProfessor extends Entrada {
    public double calculaValor(){
        return getEspetaculo().getPreco() * 0.4;
    }
}