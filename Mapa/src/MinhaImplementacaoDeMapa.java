import java.util.ArrayList;

public class MinhaImplementacaoDeMapa<C, V> implements Mapa<C, V> {

    private ArrayList<C> minhaListaDeChaves;
    private ArrayList<V> minhaListaDeValores;

    public MinhaImplementacaoDeMapa() {
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
        return this.minhaListaDeChaves.indexOf(chave);
    }

    @Override
    public V recuperarValor(C chaveDeBusca) {
        int posicaoDaChave = obterPosicaoChave(chaveDeBusca);
        return posicaoDaChave == -1
                ? null
                : this.minhaListaDeValores.get(posicaoDaChave);
    }
}
