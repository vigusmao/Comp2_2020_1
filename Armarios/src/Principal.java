import java.util.Scanner;

public class Principal {

    public static int contarArmariosAbertos(int contArmarios) {
        boolean[] armarios = new boolean[contArmarios + 1];

        for (int crianca = 1; crianca <= contArmarios; crianca++) {
            for (int indice = 1; indice <= contArmarios; indice++) {
                if (indice % crianca == 0) {  // eh multiplo!
                    armarios[indice] = !armarios[indice];
                }
            }
        }

        int contAbertos = 0;
        for (int indice = 1; indice <= contArmarios; indice++) {
            if (armarios[indice]) {  // está aberto!
                contAbertos++;
            }
        }

        return contAbertos;
    }

    public static int contarArmariosAbertos2(int contArmarios) {
        boolean[] armarios = new boolean[contArmarios + 1];

        for (int crianca = 1; crianca <= contArmarios; crianca++) {
            for (int indice = crianca; indice <= contArmarios;
                 indice += crianca) {
                if (indice % crianca == 0) {  // eh multiplo!
                    armarios[indice] = !armarios[indice];
                }
            }
        }

        int contAbertos = 0;
        for (int indice = 1; indice <= contArmarios; indice++) {
            if (armarios[indice]) {  // está aberto!
                contAbertos++;
            }
        }

        return contAbertos;
    }

    public static boolean ehQuadradoPerfeito(int x) {
        double raizQuadrada = Math.sqrt(x);
        return raizQuadrada == (int) raizQuadrada;
    }

    public static int contarArmariosAbertos3(int contArmarios) {
        int resultado = 0;
        for (int armario = 1; armario <= contArmarios; armario++) {
            if (ehQuadradoPerfeito(armario)) {
                resultado++;
            }
        }
        return resultado;
    }

    public static int contarArmariosAbertos4(long contArmarios) {
        long base;
        for (base = 1; base * base <= contArmarios; base++);
        return (int) base - 1;
    }

    public static int contarArmariosAbertos5(long contArmarios) {
        return (int) Math.sqrt(contArmarios);
    }

    public static void main(String[] args) {
        System.out.println("Quantos armários?");

        Scanner sc = new Scanner(System.in);
        long quantidadeDeArmarios = sc.nextLong();

        long inicio;
        int resultado;
        long duracaoEmMillis;
        float duracaoEmSegundos;

//        inicio = System.currentTimeMillis();
//        resultado = contarArmariosAbertos(quantidadeDeArmarios);
//        duracaoEmMillis = System.currentTimeMillis() - inicio;
//        duracaoEmSegundos = duracaoEmMillis / (float) 1000;
//        System.out.println(String.format(
//                "(1) Quant armários abertos = %d (tempo: %.3f segundos)",
//                resultado, duracaoEmSegundos));

//        inicio = System.currentTimeMillis();
//        resultado = contarArmariosAbertos2(quantidadeDeArmarios);
//        duracaoEmMillis = System.currentTimeMillis() - inicio;
//        duracaoEmSegundos = duracaoEmMillis / (float) 1000;
//        System.out.println(String.format(
//                "(2) Quant armários abertos = %d (tempo: %.3f segundos)",
//                resultado, duracaoEmSegundos));

//        inicio = System.currentTimeMillis();
//        resultado = contarArmariosAbertos3(quantidadeDeArmarios);
//        duracaoEmMillis = System.currentTimeMillis() - inicio;
//        duracaoEmSegundos = duracaoEmMillis / (float) 1000;
//        System.out.println(String.format(
//                "(3) Quant armários abertos = %d (tempo: %.3f segundos)",
//                resultado, duracaoEmSegundos));

        inicio = System.currentTimeMillis();
        resultado = contarArmariosAbertos4(quantidadeDeArmarios);
        duracaoEmMillis = System.currentTimeMillis() - inicio;
        duracaoEmSegundos = duracaoEmMillis / (float) 1000;
        System.out.println(String.format(
                "(4) Quant armários abertos = %d (tempo: %.3f segundos)",
                resultado, duracaoEmSegundos));

        inicio = System.currentTimeMillis();
        resultado = contarArmariosAbertos5(quantidadeDeArmarios);
        duracaoEmMillis = System.currentTimeMillis() - inicio;
        duracaoEmSegundos = duracaoEmMillis / (float) 1000;
        System.out.println(String.format(
                "(5) Quant armários abertos = %d (tempo: %.3f segundos)",
                resultado, duracaoEmSegundos));


    }
}
