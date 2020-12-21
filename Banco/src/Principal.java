import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Pessoa fulano = new Pessoa("Fulano de Tal", 12345);

        System.out.println("cpf = " + fulano.getCpf());

        System.out.println(fulano.toString());


        Funcionario paiva;
        paiva = new Funcionario("Paiva", 234567, 1111);

        Pessoa beltrano;
        beltrano = criarFuncionario();

        beltrano.setEndereco("Rua Tal, numero 1");

        //beltrano.receberAumento(10);   // essa linha não compilaria!!!!

        paiva.receberAumento(10);

        System.out.println(beltrano.toString());


    }

    private static Pessoa criarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("CPF: ");
        long cpf = sc.nextLong();

        // consome o "\n" que o nextLong não irá consumir
        sc.nextLine();

        System.out.println("É funcionário (S|N)? ");
        String resposta = sc.nextLine();
        boolean ehFuncionario = resposta.equals("S") ||
                resposta.equals("s");

        if (ehFuncionario) {
            System.out.println("Matrícula: ");
            int matricula = sc.nextInt();
            return new Funcionario(nome, cpf, matricula);
        }

        //return new Object();    // não compilaria!!!!!

        return new Pessoa(nome, cpf);
    }
}
