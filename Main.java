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
                    do {
                        System.out.print("Selecione um assento: ");
                        int assentoSelect = sc.nextInt(); sc.nextLine();
                        if(assentoSelect < 1 || assentoSelect > 50 || mackTeatro.getEspetaculoSelecionado().getAssentos()[assentoSelect - 1]){
                            System.out.println("ERRO: Assento inserido é inválido ou já está ocupado!");
                            continue;
                        }
// POR FAVOR CONTINUEM DAQUI
                    } while (optNovaEnt);
            }


        } while(optMenu != 4);

    }
}
