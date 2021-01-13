import java.util.ArrayList;
import java.util.Random;

public class Pacotinho extends ArrayList<Figurinha> {

    private Album album;

    private static Random random = new Random();

    // ToDo atributo que seja uma estrutura para guardar as figurinhas deste pacotinho

    public Pacotinho(Album album) {
        this.album = album;
        adicionarFigurinhasAleatorias();

    }

    // sobrecarga no costrutor, passando aqui as posições desejadas
    public Pacotinho(Album album, int[] posicoes) {
        this.album = album;

        // verificar se o tamanho do array está correto;
        if (posicoes.length != album.getQuantFigurinhasPorPacotinho()) {
            throw new RuntimeException("Pacotinho no tamanho errado!");
        }

        for (int posicao : posicoes) {
            Figurinha fig = new Figurinha(posicao);
            add(fig);
        }
    }

    private void adicionarFigurinhasAleatorias() {
        int maxPosicao = album.getTamanho();
        int quantFigurinhasPorPacotinho = album.getQuantFigurinhasPorPacotinho();

        for (int i = 1; i <= quantFigurinhasPorPacotinho; i++) {
            // ToDo sorteia uma posição entre 1 e o tamanho do álbum
            int posicao = 1 + random.nextInt(maxPosicao);


            // ToDo cria um novo objeto Figurinha informando a posição sorteada
            Figurinha figurinha = new Figurinha(posicao);

            // ToDo adiciona ao pacotinho
            add(figurinha);
        }
    }

    public Album getAlbum() {
        return this.album;
    }
}
