public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos;

    // public String getNome() {return nome;}
    // public String getData() {return data;}
    // public String getHora() {return hora;}
    public double getPreco() {return preco;}
    // public boolean[] getAssentos() {return assentos;}

    // public void setNome(String nome) {this.nome = nome;}
    // public void setData(String data) {this.data = data;}
    // public void setHora(String hora) {this.hora = hora;}
    // public void setPreco(double preco) {this.preco = preco;}
    // public void setAssentos(boolean[] assentos) {this.assentos = assentos;}

    public Espetaculo(String nome, String data, String hora, double preco){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50];
    }

    public void apresentaAssentos(){
        for(int i = 0; i < assentos.length; i++){
            System.out.print(assentos[i] + " ");
            if((i + 1) % 10 == 0){
                System.out.println();
            }
        }
    }

    public Entrada novaEntrada(int tipo, int assento){
        Entrada ent;
        switch (tipo) {
            case 1:
                ent = new EntradaInteira();
                break;
            case 2:
                ent = new EntradaMeia();
                break;
            case 3:
                ent = new EntradaProfessor();
                break;
            default:
                ent = new EntradaInteira();
        }
        return ent;
    }

    public String toString(){   
        return  "Nome: " + this.nome + "\n" +
                "Data: " + this.data + "\n" +
                "Hora:" + this.hora + "\n" +
                "Preço: " + getPreco() + "\n";
    }
}
