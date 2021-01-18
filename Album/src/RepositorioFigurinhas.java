import java.util.ArrayList;

public class RepositorioFigurinhas {

    private ArrayList<Figurinha> todasAsFigurinhasDoAlbum;

    private String nomeDoAlbum;
    private int tamanhoDoAlbum;

    RepositorioFigurinhas(String nomeDoAlbum, int tamanhoDoAlbum) {
        this.tamanhoDoAlbum = tamanhoDoAlbum;
        todasAsFigurinhasDoAlbum = new ArrayList<>();

        todasAsFigurinhasDoAlbum.add(null);  // posição 0

        for (int i = 1; i <= tamanhoDoAlbum; i++) {
            Figurinha fig = new Figurinha(i);
            todasAsFigurinhasDoAlbum.add(fig);  // Figurinha x na posição x
        }
    }

    Figurinha obterFigurinhaDoRepositorio(int posicao) {
        return todasAsFigurinhasDoAlbum.get(posicao);
    }

    int getTamanhoDoAlbum() {
        return tamanhoDoAlbum;
    }
}
