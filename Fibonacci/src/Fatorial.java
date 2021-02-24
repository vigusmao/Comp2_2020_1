public class Fatorial {

    public static long fatorialRecursivo(int n) {
        // validação do parâmetro
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        // base da recursão
        if (n <= 1) {
            return 1;
        }

        // recursão
        return (n * fatorialRecursivo(n-1)) % Integer.MAX_VALUE;

    }

    public static long fatorialNaoRecursivo(int n) {
        // validação do parâmetro
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        long resultado = 1;

        for (long x = 2; x <= n; x++) {
            resultado = (resultado * x) % Integer.MAX_VALUE;
        }

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("MAX_LONG = " + Long.MAX_VALUE);

        for (int n = 0; n <= 2000; n++) {
            System.out.printf("\nfatorial(%d)\t=\t%d", n, fatorialNaoRecursivo(n));
        }
    }
}
