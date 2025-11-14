public class Teatro {
    private Pedido carrinho;
    private Espetaculo espetaculoSelecionado;

    public Teatro(){}

    public void novaCompra(){
        do{
            System.out.println("**** Bem vindo ao MackTheather ****");
            System.out.println("Selecione qual espetáculo você deseja ver: ");
            System.out.println( "1 - Espetáculo 1 \n" + 
                                "2 - Espetáculo 2 \n" +
                                "3 - Espetáculo 3 \n" +
                                "4 - Espetáculo 4");
            System.out.println();
        }
    }

    public void apresentaEspetaculos(){
        System.out.println();
    }
}
