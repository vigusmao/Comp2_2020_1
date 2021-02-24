import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    // memo: chave n, valor fib(n)
    private static Map<Integer, Long> memo = new HashMap<>();

    /**
     * @param n um inteiro não-negativo
     * @return Retorna o n-ésimo elemento da sequência de Fibonacci,
     *         começando com n=0
     */
    public static long fibRecursivo(int n) {
        // validação do parâmetro
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        // base da recursão
        if (n <= 1) {
            return 1;
        }

        // verifica se já tem o resultado no memo
        Long resultadoMemoizado = memo.get(n);
        if (resultadoMemoizado != null) {
            return resultadoMemoizado;
        }

        // recursão
        long resultadoCalculado = fibRecursivo(n-1) + fibRecursivo(n-2);

        // salvo no memo o resultado calculado
        memo.put(n, resultadoCalculado);

        return resultadoCalculado;
    }

    public static long fibNaoRecursivo(int n) {
        // validação do parâmetro
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        long a = 1;   // fib(0)
        long b = 1;   // fib(1)

        if (n <= 1) {
            return 1;
        }

        int x = 1;  // o x diz qual a posição da sequência apontada pela variável b

        while (x < n) {
            long soma = a + b;
            a = b;
            b = soma;
            x++;
        }

        // ao sair do while, x será igual a n, portanto b apontará para fib(n)
        return b;
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 200; n++) {
            System.out.printf("\nfib(%d)\t=\t%d", n, fibRecursivo(n));
        }
    }


    /**
     *                        46
     *                      45 44*
     *                      ...
     *                    8  7*
     *                  7  6*
     *                6  5*
     *              5  4*
     *            4  3*
     *          3  2*
     *        2  1
     *      1  0
     *
     *                   .............. etc ............
     *
     *            1 1    1  1 1  1 1 1 1 1
     *
     *      # fib(46) = 1
     *      # fib(45) = 1
     *      # fib(44) = 2
     *      # fib(43) = 3
     *      # fib(42) = 5
     *          ...
     *      # fib(1) = fib(45)
     */
}
