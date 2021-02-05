import java.util.Collections;

public class MapaUsandoArrayOrdenado<C extends Comparable<C>, V>
        extends MapaUsandoArrayDePares<C, V> {

    @Override
    public V put(C chave, V valor) {

        int indice = obterIndiceDoParChaveValor(chave);

        if (indice >= 0) {
            // chave já existia; nada mais a ser feito!
            ParChaveValor par = this.minhaListaDePares.get(indice);
            V valorAnterior = par.getValor();
            par.setValor(valor);
            return valorAnterior;
        }

        int posicaoParaInsercao = -(indice + 1);
        // inversa da função aplicada pela binarySearch para elementos não encontrados

        ParChaveValor novoPar = new ParChaveValor(chave, valor);
        this.minhaListaDePares.add(posicaoParaInsercao, novoPar);

        return null;
    }

    @Override
    protected int obterIndiceDoParChaveValor(Object chave) {
        ParChaveValor parAlvo = new ParChaveValor((C) chave, null);
        return Collections.binarySearch(this.minhaListaDePares, parAlvo);
    }
}
