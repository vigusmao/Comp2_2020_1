public class Figurinha implements Colecionavel {

    private final int posicao;

    private String urlDaImagem;

    private int alturaEmPixels;

    private int larguraEmPixels;

    public Figurinha(int posicao) {
        this.posicao = posicao;
    }

    /**
     * @return A posição que esta figurinha deve ocupar no álbum
     */
    @Override
    public int getPosicao() {
       return this.posicao;
    }
}
