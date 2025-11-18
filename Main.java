import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int optMenu;
        Teatro mackTeatro = new Teatro();

        do {
            System.out.print(
                    "\n*** MACK THEATER ***\n" +
                            "1) Cadastrar Espetáculo\n" +
                            "2) Cadastrar Cliente\n" +
                            "3) Compra de Entradas\n" +
                            "4) Sair\n" +
                            "Selecione uma opção: ");
            optMenu = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (optMenu) {
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

                    System.out.print("\nSelecione um espetáculo: ");
                    int espSelect = sc.nextInt();
                    sc.nextLine();

                    mackTeatro.selecionaEspetaculo(espSelect);
                    boolean optNovaEnt = true;

                    do {
                        mackTeatro.getEspetaculoSelecionado().apresentaAssentos();
                        System.out.print("\nSelecione um assento: ");
                        int assentoSelect = sc.nextInt();
                        sc.nextLine();

                        if (
                            assentoSelect < 1 || 
                            assentoSelect > 50 ||
                            mackTeatro.getEspetaculoSelecionado().getAssentos()[assentoSelect - 1]
                        ) {System.out.println("ERRO: Assento inserido é inválido ou já está ocupado!");}

                        else {
                            System.out.println("\n||| Tipos de Entrada |||");
                            System.out.println("1) Inteira");
                            System.out.printf("2) Meia %35s", "50% do valor da entrada\n");
                            System.out.printf("3) Professor %30s", "40% do valor da entrada\n");

                            System.out.print("Selecione um tipo de entrada: ");
                            int tipo = sc.nextInt(); sc.nextLine();

                            mackTeatro.novaEntrada(tipo, assentoSelect);

                            System.out.print("\nDeseja comprar outra entrada (S/N)?: ");
                            String opt = sc.nextLine(); // opt é a variavel se a pessoa quer ou não comprar mais entradas

                            if (opt.toLowerCase().equals("n")) {
                                optNovaEnt = false;
                            }
                        }

                    } while (optNovaEnt);

                    System.out.print("\nInforme o CPF do Cliente Cadastrado: ");
                    String recebeCpf = sc.nextLine();

                    double total = mackTeatro.finalizaCompra(recebeCpf);
                    System.out.printf("Valor total: R$ %.2f\n\n", total);
                    break;
            }
        } while (optMenu != 4);
        System.out.println("Encerrando programa...");
    }
}
