import java.util.ArrayList;

public class AlbumFigurinhas {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;  // 90%

    private ArrayList<Figurinha> figurinhasColadas;

    private RepositorioFigurinhas repositorioFigurinhas;

    private int contRepetidas[];

    private int totalFigurinhasColadas;

    private int totalFigurinhasRepetidas;

    private int quantFigurinhasPorPacotinho;

    private int tamanhoDoAlbum;

    public AlbumFigurinhas(RepositorioFigurinhas repositorioFigurinhas, int quantFigurinhasPorPacotinho) {

        this.repositorioFigurinhas = repositorioFigurinhas;
        this.tamanhoDoAlbum = repositorioFigurinhas.getTamanhoDoAlbum();

        figurinhasColadas = new ArrayList<>();
        /* inaugre as posições do ArrayList para que possam ser
           acessadas diretamente via set() */
        for (int i = 1; i <= tamanhoDoAlbum + 1; i++) {
            figurinhasColadas.add(null);
        }

        contRepetidas = new int[tamanhoDoAlbum + 1];
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        this.tamanhoDoAlbum = tamanhoDoAlbum;
    }

    public void receberNovoPacotinho(PacotinhoFigurinhas pacotinhoFigurinhas) {
        for (Figurinha fig : pacotinhoFigurinhas) {
            int posicao = fig.getPosicao();
            if (figurinhasColadas.get(posicao) == null) {
                // figurinha inédita!
                colarFigurinhaInedito(fig);
            } else {
                // figurinha repetida!
                contRepetidas[posicao]++;
                totalFigurinhasRepetidas++;
            }
        }
    }

    private void colarFigurinhaInedito(Figurinha figurinha) {
        figurinhasColadas.set(figurinha.getPosicao(), figurinha);
        totalFigurinhasColadas++;
    }


    public void autoCompletar() {
        // verifica se o álbum já está suficientemente cheio
        if (this.totalFigurinhasColadas >=
                this.tamanhoDoAlbum * PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f) {
            for (int i = 1; i <= this.tamanhoDoAlbum; i++) {
                if (this.figurinhasColadas.get(i) == null) {
                    Figurinha figurinha = repositorioFigurinhas.obterFigurinhaDoRepositorio(i);
                    colarFigurinhaInedito(figurinha);
                }
            }
        }

    }

    public int getTamanho() {
        return this.tamanhoDoAlbum;
    }

    public int getQuantFigurinhasPorPacotinho() {
        return this.quantFigurinhasPorPacotinho;
    }

    public int getQuantFigurinhasColadas() {
        return this.totalFigurinhasColadas;
    }

    public int getQuantFigurinhasRepetidas() {
        return this.totalFigurinhasRepetidas;
    }

    public boolean possuiFigurinhaColada(int posicao) {
        if (posicao < 1 || posicao > this.tamanhoDoAlbum) {
            return false;
        }
        return this.figurinhasColadas.get(posicao) != null;
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        if (posicao < 1 || posicao > this.tamanhoDoAlbum) {
            return false;
        }
        return this.contRepetidas[posicao] > 0;
    }

    public int getQuantFigurinhasFaltantes() {
        return this.tamanhoDoAlbum - this.totalFigurinhasColadas;
    }

    public Figurinha getFigurinhaColada(int posicao) {
        return this.figurinhasColadas.get(posicao);
    }
}
