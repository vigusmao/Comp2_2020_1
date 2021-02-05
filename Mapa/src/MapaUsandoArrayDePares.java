import java.util.*;

public abstract class MapaUsandoArrayDePares<C extends Comparable<C>, V> implements Map<C, V> {

    protected ArrayList<ParChaveValor> minhaListaDePares;

    public MapaUsandoArrayDePares() {
        this.minhaListaDePares = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.minhaListaDePares.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return obterParChaveValor(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (ParChaveValor par : this.minhaListaDePares) {
            if (par.getValor().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public abstract V put(C chave, V valor);

    @Override
    public V remove(Object chave) {
        int indiceDoParPreExistente = obterIndiceDoParChaveValor(chave);

        if (indiceDoParPreExistente == -1) {  // chave não existe
            return null;
        }

        ParChaveValor parPreExistente = this.minhaListaDePares.get(indiceDoParPreExistente);
        V valorAnterior = parPreExistente.getValor();
        this.minhaListaDePares.remove(indiceDoParPreExistente);
        return valorAnterior;
    }

    @Override
    public void putAll(Map<? extends C, ? extends V> m) {
        throw new RuntimeException("Operação não suportada!");
    }

    @Override
    public void clear() {
        this.minhaListaDePares.clear();
    }

    @Override
    public Set<C> keySet() {
        throw new RuntimeException("Operação não suportada!");
    }

    @Override
    public Collection<V> values() {
        throw new RuntimeException("Operação não suportada!");
    }

    @Override
    public Set<Map.Entry<C, V>> entrySet() {
        throw new RuntimeException("Operação não suportada!");
    }

    @Override
    public V get(Object chaveDeBusca) {
        ParChaveValor par = obterParChaveValor(chaveDeBusca);
        return par == null
                ? null
                : par.getValor();
    }

    protected ParChaveValor obterParChaveValor(Object chave) {
        int indice = obterIndiceDoParChaveValor(chave);
        return indice < 0 ? null : this.minhaListaDePares.get(indice);
    }

    protected abstract int obterIndiceDoParChaveValor(Object chave);

    protected class ParChaveValor implements Comparable<ParChaveValor> {

        private C chave;
        private V valor;

        public ParChaveValor(C chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        public C getChave() {
            return chave;
        }

        public void setChave(C chave) {
            this.chave = chave;
        }

        public V getValor() {
            return valor;
        }

        public void setValor(V valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "ParChaveValor{" +
                    "chave=" + chave +
                    ", valor=" + valor +
                    '}';
        }

        @Override
        public int compareTo(ParChaveValor outroPar) {
            return this.chave.compareTo(outroPar.getChave());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ParChaveValor that = (ParChaveValor) o;
            return Objects.equals(chave, that.chave);
        }

        @Override
        public int hashCode() {
            return Objects.hash(chave);
        }
    }
}
