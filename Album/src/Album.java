import java.util.ArrayList;

public class Album {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;  // 90%

    private ArrayList<Figurinha> figurinhasColadas;

    private int contRepetidas[];

    private int totalFigurinhasColadas;

    private int totalFigurinhasRepetidas;

    private int quantFigurinhasPorPacotinho;

    private int tamanhoDoAlbum;

    public Album(int tamanhoDoAlbum, int quantFigurinhasPorPacotinho) {
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

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        for (Figurinha fig : pacotinho) {
            int posicao = fig.getPosicao();
            if (figurinhasColadas.get(posicao) == null) {
                // figurinha inédita!
                colarFigurinhaInedita(fig);
            } else {
                // figurinha repetida!
                contRepetidas[posicao]++;
                totalFigurinhasRepetidas++;
            }
        }
    }

    private void colarFigurinhaInedita(Figurinha fig) {
        figurinhasColadas.set(fig.getPosicao(), fig);
        totalFigurinhasColadas++;
    }


    public void autoCompletar() {
        // verifica se o álbum já está suficientemente cheio
        if (this.totalFigurinhasColadas >=
                this.tamanhoDoAlbum * PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f) {
            for (int i = 1; i <= this.tamanhoDoAlbum; i++) {
                if (this.figurinhasColadas.get(i) == null) {
                    Figurinha fig = new Figurinha(i);
                    colarFigurinhaInedita(fig);
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
}
