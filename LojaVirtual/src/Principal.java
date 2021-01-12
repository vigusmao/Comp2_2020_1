import java.util.Scanner;

/**
 * Interface de texto com o usuário
 */
public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Loja loja = null;
        Transportadora transportadora = new Transportadora();

        while (loja == null) {
            System.out.println("O que usar como serviço de impressão? " +
                    "\n Impressora (J)ato de Tinta\n Impressora (M)atricial");
            String resposta = sc.nextLine();

            switch (resposta.toUpperCase().charAt(0)) {
//                case 'G':
//                    Grafica grafica = new Grafica();
//                    loja = new Loja(transportadora, grafica);
//                    break;

                case 'M':
                    ImpressoraMatricial impressoraMatricial = new ImpressoraMatricial();
                    loja = new Loja(transportadora, impressoraMatricial);
                    break;

                case 'J':
                    ImpressoraJatoDeTinta impressoraJato = new ImpressoraJatoDeTinta("Epson", 2020);
                    loja = new Loja(transportadora, impressoraJato);
                    break;

                case 'S':
                    return;  // sai do main()

                default:
                    System.out.println("\nOpção inválida!");
            }
        }

        Usuario usuario = new Usuario(123456, "Vinícius Gusmão");
        usuario.setEndereco("Rua Taltaltal, 10000 apto 501");

        CD cd = new CD(1234, "Fragile", "Yes", 1974);
        cd.setPrecoEmReais(35);

        loja.incluirItem(cd);
        loja.receberPedido(cd, 5, usuario);
    }
}
