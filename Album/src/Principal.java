import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {


        ArrayList<Integer> meuArrayList = new ArrayList<>();
//        /* "inauguro" as 200 primeiras posições do ArrayList,
//            para que possam ser diretamente acessadas */
//        for (int i = 0; i < 200; i++) {
//            meuArrayList.add(null);
//        }

        System.out.println("Tamanho do array (pré-inserções) = " + meuArrayList.size());

        for (int i = 1; i <= 2000; i++) {

            int posicao = 50 + i;

            /* "esticando" sob demanda o tamanho lógico do ArrayList até disponibilizar
               a posição desejada */
            while (meuArrayList.size() <= posicao) {
                meuArrayList.add(null);
            }
            meuArrayList.set(posicao, i*i);
        }

        System.out.println("Tamanho do array (pós-inserções) = " + meuArrayList.size());

        for (Integer x : meuArrayList) {
            if (x == null) {
                continue;
            }
            System.out.println(x);
        }

//        for (int i = 0; i <= 2050; i++) {
//            System.out.println("posicao " + i + " ---> " + meuArrayList.get(i));
//        }
    }
}
