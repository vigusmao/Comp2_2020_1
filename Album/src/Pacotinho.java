import java.util.ArrayList;
import java.util.Random;

public class Pacotinho<T extends Colecionavel> extends ArrayList<T> {

    private Repositorio<T> repositorio;

    private int quantItensNoPacotinho;

    private static Random random = new Random();

    // ToDo atributo que seja uma estrutura para guardar os itens deste pacotinho

    public Pacotinho(Repositorio repositorio, int quantItensNoPacotinho) {
        this.repositorio = repositorio;
        this.quantItensNoPacotinho = quantItensNoPacotinho;

        adicionarFigurinhasAleatorias();
    }

    // sobrecarga no costrutor, passando aqui as posições desejadas
    public Pacotinho(Repositorio<T> repositorio, int[] posicoes) {
        this.repositorio = repositorio;

        for (int posicao : posicoes) {
            T item = repositorio.obterItem(posicao);
            add(item);
        }
    }

    private void adicionarFigurinhasAleatorias() {
        int maxPosicao = repositorio.getTamanhoDoAlbum();
        int quantFigurinhasPorPacotinho = this.quantItensNoPacotinho;

        for (int i = 1; i <= quantFigurinhasPorPacotinho; i++) {
            // ToDo sorteia uma posição entre 1 e o tamanho do álbum
            int posicao = 1 + random.nextInt(maxPosicao);


            // ToDo cria um novo item informando a posição sorteada
            T item = repositorio.obterItem(posicao);

            // ToDo adiciona ao pacotinho
            add(item);
        }
    }
}
