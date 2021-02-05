public class MapaUsandoArrayNaoOrdenado<C extends Comparable<C>, V> extends MapaUsandoArrayDePares<C, V> {

    @Override
    public V put(C chave, V valor) {
        ParChaveValor parPreExistente = obterParChaveValor(chave);

        if (parPreExistente == null) {  // chave inédita!!
            this.minhaListaDePares.add(new ParChaveValor(chave, valor));
            return null;
        }

        V valorAnterior = parPreExistente.getValor();
        parPreExistente.setValor(valor);
        return valorAnterior;
    }

    @Override
    protected int obterIndiceDoParChaveValor(Object chave) {
        for (int i = 0; i < this.minhaListaDePares.size(); i++) {
            ParChaveValor par = this.minhaListaDePares.get(i);
            if (par.getChave().equals(chave)) {
                return i;
            }
        }
        return -1;
    }
}
