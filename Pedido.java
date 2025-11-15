import java.util.ArrayList;

public class Pedido {
    private ArrayList<Entrada> entradas = new ArrayList<>();

    public Pedido(){}

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public void adicionaEntrada(Entrada entrada){
        entradas.add(entrada);
    }

    public double calculaValorTotal(){
        
    }
}
