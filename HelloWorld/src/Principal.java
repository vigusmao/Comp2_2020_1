import java.util.Scanner;

public class Principal {

    /**
     * Calcula oMDC entre dois inteiros positivos
     * @param x um dos inteiros
     * @param y o outro inteiro
     * @return o MDC de x e y; ou 0, caso um deles não seja positivo
     */
    public static int calcularMDC(int x, int y) {

//        if (x <= 0 || y <= 0) {
//            return 0;  // como combinado
//        }

        int resto = x % y;

        while (resto != 0) {
            x = y;
            y = resto;
            resto = x % y;
        }

        return y;
    }


    // psvm
    public static void main(String[] args) {

        // sout
        System.out.println("Oi!!!");

        int minhaVariavelDeTeste = 6;  // Java convention
        System.out.println(minhaVariavelDeTeste);

        int n;
        n = 36;
        int m = 24;

        System.out.println("n = " + n);


        String frase;  // quero ler do teclado

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite algo por favor.");
        frase = scanner.nextLine();
        System.out.printf("Acabei de ler a frase: %s (%d caracteres)\n", frase, frase.length());

        System.out.println("Digite dois inteiros positivos.");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int mdc = calcularMDC(x, y);
        System.out.println("mdc(" + x + "," + y + ") = " + mdc);
        System.out.printf("mdc(%d,%d) = %d\n", x, y, mdc);  // equivalente à linha de cima
        System.out.println(String.format("mdc(%d,%d) = %d", x, y, mdc));  // equivalente novamente

        // novamente equivalente, agora em duas linhas! :-)
        String mensagem = String.format("mdc(%d,%d) = %d", x, y, mdc);  // equivalente novamente
        System.out.println(mensagem);

        boolean v = (9 > 8) && x < mdc || minhaVariavelDeTeste == 1000;
        System.out.println(v);


    }


}
