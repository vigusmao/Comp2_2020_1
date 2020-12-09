import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

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
     * Força bruta para cada elemento do intervalo.
     *
     * @param limite O número que fecha o limite desejado.
     * @return um ArrayList de inteiros contendo os primos.
     */
    public static ArrayList<Integer> obterPrimos(int limite) {
        ArrayList<Integer> primos = new ArrayList<>();
        for (int x = 1; x <= limite; x++) {
            if (ehPrimo(x)) {
                primos.add(x);
            }
        }
        return primos;
    }

    /**
     * Retorna todos os primos em [1, limite] em ordem crescente.
     * Usa o crivo de Eratóstenes.
     *
     * @param limite O número que fecha o limite desejado.
     * @return um ArrayList de inteiros contendo os primos.
     */
    public static ArrayList<Integer> obterPrimosViaCrivo(int limite) {
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

        ArrayList<Integer> result = new ArrayList<>();
        for (int numero = 2; numero <= limite; numero++) {
            if (!numerosCompostos[numero]) {
                result.add(numero);
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
        ArrayList<Integer> primos = obterPrimos(limite);
        return primos.size();
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
            ArrayList<Integer> primos = obterPrimos(x);
            long duracao = System.currentTimeMillis() - inicio;
            System.out.println(String.format(
                    "Quantidade de primos em [1, %d] = %d (duração: %.3f segundos via força bruta)",
                    x, primos.size(), duracao / 1000f));
            System.out.println(primos);

            inicio = System.currentTimeMillis();
            primos = obterPrimosViaCrivo(x);
            duracao = System.currentTimeMillis() - inicio;
            System.out.println(String.format(
                    "Quantidade de primos em [1, %d] = %d (duração: %.3f segundos via crivo)",
                    x, primos.size(), duracao / 1000f));
            System.out.println(primos);
        }
    }
}
