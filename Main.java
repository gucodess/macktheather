import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int optMenu;
        Teatro mackTeatro = new Teatro();

        do{
            System.out.print(
                "*** MACK THEATER ***\n" +
                "1) Cadastrar Espetáculo\n" +
                "2) Cadastrar Cliente\n" +
                "3) Compra de Entradas\n" +
                "4) Sair\n" +
                "Selecione uma opção: "
            );
            optMenu = sc.nextInt();
            sc.nextLine();

            switch(optMenu){
                case 1:
                    mackTeatro.cadastraEspetaculo();
                    break;
                case 2:
                    System.out.print("Nome do Cliente: ");
                    String clienteNome = sc.nextLine();

                    System.out.print("CPF do Cliente: ");
                    String clienteCpf = sc.nextLine();

                    Cliente novoCliente = new Cliente(clienteNome, clienteCpf);
                    mackTeatro.novoCliente(novoCliente);
                    break;
                case 3:
                    mackTeatro.novaCompra();
                    System.out.println("*** VENDA DE ENTRADAS - ESPETÁCULOS ***");
                    mackTeatro.apresentaEspetaculos();

                    System.out.print("Selecione um espetáculo: ");
                    int espSelect = sc.nextInt();
                    sc.nextLine();

                    mackTeatro.selecionaEspetaculo(espSelect);
                    boolean optNovaEnt = true;

                    Pedido pedido = new Pedido(); // CRIANDO O PEDIDO

                    do {
                        System.out.print("Selecione um assento: ");
                        int assentoSelect = sc.nextInt(); sc.nextLine();

                        if(assentoSelect < 1 || assentoSelect > 50 || mackTeatro.getEspetaculoSelecionado().getAssentos()[assentoSelect - 1]){
                            System.out.println("ERRO: Assento inserido é inválido ou já está ocupado!");
                        } 
                        
                        else {
                            System.out.println("||| Tipos de entrada:");
                            System.out.println("1) Inteira");
                            System.out.println("2) Meia");
                            System.out.println("3) Professor");

                            System.out.print("Selecione o tipo: ");
                            int tipo = sc.nextInt();
                            sc.nextLine();

                            mackTeatro.novaEntrada(tipo, assentoSelect);
                            mackTeatro.getEspetaculoSelecionado().getAssentos()[assentoSelect - 1] = true;

                            System.out.println("Assento comprado com sucesso !");
                            mackTeatro.getEspetaculoSelecionado().apresentaAssentos();

                            System.out.println("Deseja comprar outra entrada ? (s/n): ");
                            String opt = sc.nextLine(); // opt é a variavel se a pessoa quer ou não comprar mais entardas

                            if (opt.equals("n")){
                                optNovaEnt = false;
                            }
                        }
                        
                    } while (optNovaEnt);

                    System.out.println("Digite o CPF do cliente: ");
                    String recebeCpf = sc.nextLine();
                    
                    double total = pedido.calculaValorTotal();

                    System.out.println("Compra finalizada no CPF: " + recebeCpf);
                    System.out.printf("Valor total: R$ %.2f\n", total);
                    break;
            }


        } while(optMenu != 4);

    }
}
