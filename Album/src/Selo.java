public class Selo {

    private String pais;

    private float valorMonetario;

    private int anoLancamento;

    private String urlDaImagem;

    private final int posicao;

    public Selo(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return this.posicao;
    }
}
