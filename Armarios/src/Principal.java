import java.util.Scanner;

public class Principal {

    public static void listarArmariosAbertos(int contArmarios) {
        boolean[] armarios = new boolean[contArmarios + 1];

        for (int crianca = 1; crianca <= contArmarios; crianca++) {
            for (int indice = 1; indice <= contArmarios; indice++) {
                if (indice % crianca == 0) {  // eh multiplo!
                    armarios[indice] = !armarios[indice];
                }
            }
        }

        for (int indice = 1; indice <= contArmarios; indice++) {
            if (armarios[indice]) {  // está aberto!
                System.out.println(indice);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Quantos armários?");

        Scanner sc = new Scanner(System.in);
        int quantidadeDeArmarios = sc.nextInt();

        listarArmariosAbertos(quantidadeDeArmarios);
    }
}
