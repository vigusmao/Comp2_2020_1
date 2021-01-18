import java.util.ArrayList;

public class AlbumSelos {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;  // 90%

    private ArrayList<Selo> selosColadas;

    private RepositorioSelos repositorioFigurinhas;

    private int contRepetidas[];

    private int totalFigurinhasColadas;

    private int totalFigurinhasRepetidas;

    private int quantFigurinhasPorPacotinho;

    private int tamanhoDoAlbum;

    public AlbumSelos(RepositorioSelos repositorioSelos, int quantFigurinhasPorPacotinho) {

        this.repositorioFigurinhas = repositorioSelos;
        this.tamanhoDoAlbum = repositorioSelos.getTamanhoDoAlbum();

        selosColadas = new ArrayList<>();
        /* inaugre as posições do ArrayList para que possam ser
           acessadas diretamente via set() */
        for (int i = 1; i <= tamanhoDoAlbum + 1; i++) {
            selosColadas.add(null);
        }

        contRepetidas = new int[tamanhoDoAlbum + 1];
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        this.tamanhoDoAlbum = tamanhoDoAlbum;
    }

    public void receberNovoPacotinho(PacotinhoSelos pacotinhoSelos) {
        for (Selo fig : pacotinhoSelos) {
            int posicao = fig.getPosicao();
            if (selosColadas.get(posicao) == null) {
                // figurinha inédita!
                colarSeloInedito(fig);
            } else {
                // figurinha repetida!
                contRepetidas[posicao]++;
                totalFigurinhasRepetidas++;
            }
        }
    }

    private void colarSeloInedito(Selo selo) {
        selosColadas.set(selo.getPosicao(), selo);
        totalFigurinhasColadas++;
    }


    public void autoCompletar() {
        // verifica se o álbum já está suficientemente cheio
        if (this.totalFigurinhasColadas >=
                this.tamanhoDoAlbum * PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f) {
            for (int i = 1; i <= this.tamanhoDoAlbum; i++) {
                if (this.selosColadas.get(i) == null) {
                    Selo selo = repositorioFigurinhas.obterSeloDoRepositorio(i);
                    colarSeloInedito(selo);
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

    public boolean possuiSeloColado(int posicao) {
        if (posicao < 1 || posicao > this.tamanhoDoAlbum) {
            return false;
        }
        return this.selosColadas.get(posicao) != null;
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

    public Selo getFigurinhaColada(int posicao) {
        return this.selosColadas.get(posicao);
    }
}
