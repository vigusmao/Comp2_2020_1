import java.util.ArrayList;

public class MapaUsandoDoisArraysParalelos<C, V> implements Mapa<C, V> {

    private ArrayList<C> minhaListaDeChaves;
    private ArrayList<V> minhaListaDeValores;

    public MapaUsandoDoisArraysParalelos() {
        this.minhaListaDeChaves = new ArrayList<>();
        this.minhaListaDeValores = new ArrayList<>();
    }

    @Override
    public void adicionar(C chave, V valor) {
        int posicaoDaChavePreExistente = obterPosicaoChave(chave);

        if (posicaoDaChavePreExistente == -1) {  // chave inédita!!
            this.minhaListaDeChaves.add(chave);
            this.minhaListaDeValores.add(valor);

        } else {  // chave pré-existente
            this.minhaListaDeValores.set(
                    posicaoDaChavePreExistente, valor);
        }
    }

    private int obterPosicaoChave(C chave) {
        for (int i = 0; i < this.minhaListaDeChaves.size(); i++) {
            if (this.minhaListaDeChaves.get(i).equals(chave)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V recuperarValor(C chaveDeBusca) {
        int posicaoDaChave = obterPosicaoChave(chaveDeBusca);
        return posicaoDaChave == -1
                ? null
                : this.minhaListaDeValores.get(posicaoDaChave);
    }
}
