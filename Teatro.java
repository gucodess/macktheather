import java.util.ArrayList;
import java.util.Scanner;

public class Teatro {
    private Pedido carrinho;
    private ArrayList<Espetaculo> listaEspetaculos;
    private Espetaculo espetaculoSelecionado;
    private ArrayList<Cliente> clientes; 

    public Teatro() {
        this.listaEspetaculos = new ArrayList<>(); // Define lista vazia sem parâmetros no constructor
    }

    public void novaCompra() {
        this.carrinho = new Pedido();
    }

    public void cadastraEspetaculo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do espetáculo: ");
        String espetaculoNome = sc.nextLine();

        System.out.print("Data: ");
        String espetaculoData = sc.nextLine();

        System.out.print("Hora: ");
        String espetaculoHora = sc.nextLine();

        System.out.print("Preço da Entrada Inteira: ");
        Double espetaculoPreco = sc.nextDouble();

        Espetaculo novoEspetaculo = new Espetaculo(espetaculoNome, espetaculoData, espetaculoHora, espetaculoPreco);
        listaEspetaculos.add(novoEspetaculo);
    }

    public void apresentaEspetaculos() {
        if(listaEspetaculos.size() > 0){
            for (Espetaculo esp : listaEspetaculos) {
                int index = listaEspetaculos.indexOf(esp) + 1;
                System.out.printf(
                    "%d) %s %s %s R$%.2f\n", 
                    index, esp.getNome(), esp.getData(), esp.getHora(), esp.getPreco()
                );
            }
        } else {System.out.println("ERRO: Não há espetáculos cadastrados!");}
    }

    public void selecionaEspetaculo(int numero){
        Scanner sc = new Scanner(System.in);
        System.out.print("Selecione um espetáculo: ");
        int espSelect = sc.nextInt();

        for(int i = 0; i<listaEspetaculos.size(); i++){
            if(espSelect - 1 == i){
                this.espetaculoSelecionado = listaEspetaculos.get(i);
                espetaculoSelecionado.apresentaAssentos();
            }
        }
    }

    public void novaEntrada(int tipo, int assento){
        Entrada novaEnt = espetaculoSelecionado.novaEntrada(tipo, assento);
        carrinho.adicionaEntrada(novaEnt);
    }

    public double finalizaCompra(String cpf){
        double valorTotal = 0.0;
        for (Cliente cliente : clientes) {
            if(cpf.equals(cliente.getCpf())){
                cliente.adicionaPedido(carrinho);
                valorTotal = carrinho.calculaValorTotal();
                this.carrinho = null;
                return valorTotal;
            }
        }
    return 0.0;
    }
}
