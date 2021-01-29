import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MapaUsandoArrayUnico<C, V> implements Map<C, V> {

    private ArrayList<ParChaveValor<C, V>> minhaListaDePares;

    public MapaUsandoArrayUnico() {
        this.minhaListaDePares = new ArrayList<>();
    }

    @Override
    public int size() {
        return 0;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public boolean isEmpty() {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public boolean containsKey(Object key) {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public boolean containsValue(Object value) {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public V put(C chave, V valor) {
        ParChaveValor<C, V> parPreExistente = obterParChaveValor(chave);

        if (parPreExistente == null) {  // chave inédita!!
            this.minhaListaDePares.add(new ParChaveValor<>(chave, valor));

        } else {  // chave pré-existente
            parPreExistente.setValor(valor);
        }

        return null;  // ToDo IMPLEMENT ME!!! (precisa retornar o valor pré-existente!!)
    }

    @Override
    public V remove(Object key) {
        return null;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public void putAll(Map<? extends C, ? extends V> m) {
        throw new RuntimeException("Operação não suportada!");
    }

    @Override
    public void clear() {
        // ToDo IMPLEMENT ME!!!
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
    public Set<Entry<C, V>> entrySet() {
        throw new RuntimeException("Operação não suportada!");
    }

    @Override
    public V get(Object chaveDeBusca) {
        ParChaveValor<C, V> par = obterParChaveValor(chaveDeBusca);
        return par == null
                ? null
                : par.getValor();
    }

    private ParChaveValor<C, V> obterParChaveValor(Object chave) {
        for (ParChaveValor<C, V> par : this.minhaListaDePares) {
            if (par.getChave().equals(chave)) {
                return par;
            }
        }
        return null;
    }
}
