import java.util.List;

public interface CalculadorIntersecoes<T> {

    /**
     * Computa o tamanho da interseção de duas listas dadas.
     *
     * @param lista1 a primeira lista
     * @param lista2 a segunda lista
     *
     * @return O tamanho da interseção das listas
     */
    int obterQuantidadeElementosComuns(List<T> lista1, List<T> lista2);
}
