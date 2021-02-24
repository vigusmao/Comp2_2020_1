import java.util.List;

public interface ContadorOcorrencias<T> {

    /**
     * Retorna o elemento que aparece mais vezes na lista.
     *
     * @param lista uma lista de inteiros
     * @return o elemento mais frequente; ou null, caso a lista esteja vazia
     */
    T retornarElementoMaisFrequente(List<T> lista);
}
