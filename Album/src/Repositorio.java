import java.util.ArrayList;

public class Repositorio<T extends Colecionavel> {

    private ArrayList<T> todosOsItensDoAlbum;

    private String nomeDoAlbum;
    private int tamanhoDoAlbum;

    Repositorio(String nomeDoAlbum, int tamanhoDoAlbum, String tipoDoItem) {
        this.tamanhoDoAlbum = tamanhoDoAlbum;
        todosOsItensDoAlbum = new ArrayList<>();

        todosOsItensDoAlbum.add(null);  // posição 0

        for (int i = 1; i <= tamanhoDoAlbum; i++) {
            T item;
            switch (tipoDoItem.toLowerCase()) {
                case "selo":
                    item = (T) new Selo(i);
                    break;
                case "figurinha": default:
                    item = (T) new Figurinha(i);
                    break;
            }  // ToDo instanciar de forma mais elegante

            todosOsItensDoAlbum.add(item);  // Figurinha x na posição x
        }
    }

    T obterItem(int posicao) {
        return todosOsItensDoAlbum.get(posicao);
    }

    int getTamanhoDoAlbum() {
        return tamanhoDoAlbum;
    }
}
