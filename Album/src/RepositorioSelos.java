import java.util.ArrayList;

public class RepositorioSelos {

    private ArrayList<Selo> todosOsSelosDoAlbum;

    private String nomeDoAlbum;
    private int tamanhoDoAlbum;

    RepositorioSelos(String nomeDoAlbum, int tamanhoDoAlbum) {
        this.tamanhoDoAlbum = tamanhoDoAlbum;
        todosOsSelosDoAlbum = new ArrayList<>();

        todosOsSelosDoAlbum.add(null);  // posição 0

        for (int i = 1; i <= tamanhoDoAlbum; i++) {
            Selo selo = new Selo(i);
            todosOsSelosDoAlbum.add(selo);  // Selo x na posição x
        }
    }

    Selo obterSeloDoRepositorio(int posicao) {
        return todosOsSelosDoAlbum.get(posicao);
    }

    int getTamanhoDoAlbum() {
        return tamanhoDoAlbum;
    }
}
