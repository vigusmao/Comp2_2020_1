import java.util.Scanner;

public class Principal {

    public static void imprimirDivisores(int x) {
        int div = 1;
        while (div <= x) {
            if (x % div == 0) {
                System.out.println(div);
            }
            div++;
        }

//      OUTRA MANEIRA:
//
//        for (int div = 1; div <= x; div++) {
//            if (x % div == 0) {
//                System.out.println(div);
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();
        int tamanho = linha.length();

        System.out.println(
                "Você digitou: " + linha + " (contém " + tamanho + " caracteres)");

        // Outro jeito, usando String.format()
        System.out.println(String.format(
                "Você digitou: %s (contém %d caracteres)", linha, tamanho));

        // Outro jeito, usando printf("...\n")
        System.out.printf(
                "Você digitou: %s (contém %d caracteres)\n", linha, tamanho);

        imprimirDivisores(12);

    }
}
