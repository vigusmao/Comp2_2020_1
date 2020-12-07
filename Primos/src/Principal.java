import java.util.Scanner;

public class Principal {

    public static void imprimirArray(boolean[] array) {
        for (int pos = 0; pos < array.length; pos++) {
            System.out.printf("[%d]: %s\n", pos, array[pos]);
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
     * Retorna a quantidade de números primos existentes no intervalo [1, limite].
     * Força bruta para cada número do intervalo.
     *
     * @param limite o maior número desejado, fechando o intervalo.
     * @return a quantidade de primos naquele intervalo
     */
    public static int contarPrimos(int limite) {
        int cont = 0;
        for (int x = 1; x <= limite; x++) {
            if (ehPrimo(x)) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Retorna a quantidade de números primos existentes no intervalo [1, limite].
     * Internamente utiliza o crivo de Eratóstenes.
     *
     * @param limite o maior número desejado, fechando o intervalo.
     * @return a quantidade de primos naquele intervalo
     */
    public static int contarPrimosViaCrivo(int limite) {
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

//        imprimirArray(numerosCompostos);
        return contPrimos;
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
            int quantPrimos = contarPrimos(x);
            long duracao = System.currentTimeMillis() - inicio;
            System.out.println(String.format(
                    "Quantidade de primos em [1, %d] = %d (duração: %.3f segundos via força bruta)",
                    x, quantPrimos, duracao / 1000f));

            inicio = System.currentTimeMillis();
            quantPrimos = contarPrimosViaCrivo(x);
            duracao = System.currentTimeMillis() - inicio;
            System.out.println(String.format(
                    "Quantidade de primos em [1, %d] = %d (duração: %.3f segundos via crivo)",
                    x, quantPrimos, duracao / 1000f));
        }
    }
}
