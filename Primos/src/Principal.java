import java.util.Scanner;

public class Principal {

    public static void imprimirArray(boolean[] array) {
        for (int pos = 0; pos < array.length; pos++) {
            System.out.printf("[%d]: %s\n", pos, array[pos]);
        }
    }

    // "Overload" (sobrecarga) de método, isto é, métodos com o mesmo nome porém diferentes assinaturas
    public static void imprimirArray(int[] array) {
        for (int pos = 0; pos < array.length; pos++) {
            System.out.printf("[%d]: %d\n", pos, array[pos]);
        }
    }

    /**
     * Retrona se o número dado é primo.
     * @param numero o número desejado.
     * @return true, se o número for primo; false, caso contrário.
     */
    public static boolean ehPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        if (numero == 2) {
            return true;  // 2 é primo (o único primo par)
        }
        if (numero % 2 == 0) {
            return false;  // não é primo, pois é par > 2
        }
        double raiz = Math.sqrt(numero);
        for (int divisor = 3; divisor <= raiz; divisor += 2) {
            if (numero % divisor == 0) {
                return false;  // eh composto
            }
        }
        return true;  // eh primo
    }

    /**
     * Retorna todos os primos em [1, limite] em ordem crescente.
     * Força bruto para cada elemento do intervalo.
     *
     * @param limite O número que fecha o limite desejado.
     * @return um array de inteiros contendo os primos (o tamanho do array será exato)
     */
    public static int[] obterPrimos(int limite) {
        int[] primos = new int[16];  // pré-alocando o array que guardará meus primos de forma bem exagerada
        int contPrimos = 0;
        for (int x = 1; x <= limite; x++) {
            if (ehPrimo(x)) {

                // verifica overflow e redimensiona (via new array + cópia) se for o caso
                if (contPrimos == primos.length) {
                    int[] novoArrayDePrimos = new int[primos.length * 2];
                    for (int pos = 0; pos < primos.length; pos++) {
                        novoArrayDePrimos[pos] = primos[pos];
                    }
                    primos = novoArrayDePrimos;  // "primos" vai agora apontar para a nova região de memória
                }

                primos[contPrimos++] = x;
            }
        }
        int[] result = new int[contPrimos];
        for (int pos = 0; pos < contPrimos; pos++) {
            result[pos] = primos[pos];
        }
        return result;
    }

    /**
     * Retorna todos os primos em [1, limite] em ordem crescente.
     * Usa o crivo de Eratóstenes.
     *
     * @param limite O número que fecha o limite desejado.
     * @return um array de inteiros contendo os primos (o tamanho do array será exato)
     */
    public static int[] obterPrimosViaCrivo(int limite) {
        boolean[] numerosCompostos;  // = null;
        numerosCompostos = new boolean[limite + 1];  // tudo false, a princípio
        numerosCompostos[0] = true;
        numerosCompostos[1] = true;

        // crivo
        int passo = 2;
        while (passo <= limite) {
            for (int numeroASerRiscado = passo + passo; numeroASerRiscado <= limite; numeroASerRiscado += passo) {
                numerosCompostos[numeroASerRiscado] = true;  // o número é composto, porque é múltiplo do passo
            }
            int novoPasso = 0;
            for (int candidato = passo + 1; candidato <= limite; candidato++) {
                if (!numerosCompostos[candidato]) {
                    novoPasso = candidato;  // encontrei o próximo número primo, que será agora o meu próximo "passo"
                    break;
                }
            }
            if (novoPasso == 0) {
                // não há novos primos no intervalo, podemos parar
                break;  // saindo do while
            }
            passo = novoPasso;
        }

        // conta os primos (estão marcados false no array)
        int contPrimos = 0;
        for (int x = 1; x <= limite; x++) {
            if (!numerosCompostos[x]) {
                contPrimos++;
            }
        }

        int[] result = new int[contPrimos];
        int pos = 0;
        for (int numero = 2; numero <= limite; numero++) {
            if (!numerosCompostos[numero]) {
                result[pos++] = numero;
            }
        }
        return result;
    }

    /**
     * Retorna a quantidade de números primos existentes no intervalo [1, limite].
     *
     * @param limite o maior número desejado, fechando o intervalo.
     * @return a quantidade de primos naquele intervalo
     */
    public int contarPrimos(int limite) {
        int[] primos = obterPrimosViaCrivo(limite);
        return primos.length;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Digite um número inteiro positivo");
            int x = sc.nextInt();
            if (x <= 0) {
                return;
            }

            long inicio = System.currentTimeMillis();
            int[] primos = obterPrimos(x);
            long duracao = System.currentTimeMillis() - inicio;
            System.out.println(String.format(
                    "Quantidade de primos em [1, %d] = %d (duração: %.3f segundos via força bruta)",
                    x, primos.length, duracao / 1000f));
            imprimirArray(primos);

            inicio = System.currentTimeMillis();
            primos = obterPrimosViaCrivo(x);
            duracao = System.currentTimeMillis() - inicio;
            System.out.println(String.format(
                    "Quantidade de primos em [1, %d] = %d (duração: %.3f segundos via crivo)",
                    x, primos.length, duracao / 1000f));
            imprimirArray(primos);
        }
    }
}
