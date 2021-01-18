import java.util.ArrayList;
import java.util.Random;

public class PacotinhoSelos extends ArrayList<Selo> {

    private RepositorioSelos repositorioSelos;

    private int quantFigurinhasNoPacotinho;

    private static Random random = new Random();

    // ToDo atributo que seja uma estrutura para guardar as figurinhas deste pacotinho

    public PacotinhoSelos(RepositorioSelos repositorioSelos, int quantFigurinhasNoPacotinho) {
        this.repositorioSelos = repositorioSelos;
        this.quantFigurinhasNoPacotinho = quantFigurinhasNoPacotinho;

        adicionarSelosAleatorios();
    }

    // sobrecarga no costrutor, passando aqui as posições desejadas
    public PacotinhoSelos(RepositorioSelos repositorioSelos, int[] posicoes) {
        this.repositorioSelos = repositorioSelos;

        for (int posicao : posicoes) {
            Selo selo = repositorioSelos.obterSeloDoRepositorio(posicao);
            add(selo);
        }
    }

    private void adicionarSelosAleatorios() {
        int maxPosicao = repositorioSelos.getTamanhoDoAlbum();
        int quantFigurinhasPorPacotinho = this.quantFigurinhasNoPacotinho;

        for (int i = 1; i <= quantFigurinhasPorPacotinho; i++) {
            // ToDo sorteia uma posição entre 1 e o tamanho do álbum
            int posicao = 1 + random.nextInt(maxPosicao);


            // ToDo cria um novo objeto Selo informando a posição sorteada
            Selo figurinha = repositorioSelos.obterSeloDoRepositorio(posicao);

            // ToDo adiciona ao pacotinho
            add(figurinha);
        }
    }
}
