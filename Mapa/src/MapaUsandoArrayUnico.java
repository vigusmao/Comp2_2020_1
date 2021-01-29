import java.util.ArrayList;

public class MapaUsandoArrayUnico<C, V> implements Mapa<C, V> {

    private ArrayList<ParChaveValor<C, V>> minhaListaDePares;

    public MapaUsandoArrayUnico() {
        this.minhaListaDePares = new ArrayList<>();
    }

    @Override
    public void adicionar(C chave, V valor) {
        ParChaveValor<C, V> parPreExistente = obterParChaveValor(chave);

        if (parPreExistente == null) {  // chave inédita!!
            this.minhaListaDePares.add(new ParChaveValor<>(chave, valor));

        } else {  // chave pré-existente
            parPreExistente.setValor(valor);
        }
    }

    @Override
    public V recuperarValor(C chaveDeBusca) {
        ParChaveValor<C, V> par = obterParChaveValor(chaveDeBusca);
        return par == null
                ? null
                : par.getValor();
    }

    private ParChaveValor<C, V> obterParChaveValor(C chave) {
        for (ParChaveValor<C, V> par : this.minhaListaDePares) {
            if (par.getChave().equals(chave)) {
                return par;
            }
        }
        return null;
    }
}
