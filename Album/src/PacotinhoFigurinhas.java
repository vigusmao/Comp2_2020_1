import java.util.ArrayList;
import java.util.Random;

public class PacotinhoFigurinhas extends ArrayList<Figurinha> {

    private RepositorioFigurinhas repositorioFigurinhas;

    private int quantFigurinhasNoPacotinho;

    private static Random random = new Random();

    // ToDo atributo que seja uma estrutura para guardar as figurinhas deste pacotinho

    public PacotinhoFigurinhas(RepositorioFigurinhas repositorioFigurinhas, int quantFigurinhasNoPacotinho) {
        this.repositorioFigurinhas = repositorioFigurinhas;
        this.quantFigurinhasNoPacotinho = quantFigurinhasNoPacotinho;

        adicionarFigurinhasAleatorias();
    }

    // sobrecarga no costrutor, passando aqui as posições desejadas
    public PacotinhoFigurinhas(RepositorioFigurinhas repositorioFigurinhas, int[] posicoes) {
        this.repositorioFigurinhas = repositorioFigurinhas;

        for (int posicao : posicoes) {
            Figurinha fig = repositorioFigurinhas.obterFigurinhaDoRepositorio(posicao);
            add(fig);
        }
    }

    private void adicionarFigurinhasAleatorias() {
        int maxPosicao = repositorioFigurinhas.getTamanhoDoAlbum();
        int quantFigurinhasPorPacotinho = this.quantFigurinhasNoPacotinho;

        for (int i = 1; i <= quantFigurinhasPorPacotinho; i++) {
            // ToDo sorteia uma posição entre 1 e o tamanho do álbum
            int posicao = 1 + random.nextInt(maxPosicao);


            // ToDo cria um novo objeto Figurinha informando a posição sorteada
            Figurinha figurinha = repositorioFigurinhas.obterFigurinhaDoRepositorio(posicao);

            // ToDo adiciona ao pacotinho
            add(figurinha);
        }
    }
}
