import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculadorIntersecoesEsperto<T>
        implements CalculadorIntersecoes<T> {


    @Override
    public int obterQuantidadeElementosComuns(List<T> lista1, List<T> lista2) {
        int cont = 0;

        Set<T> conjuntoReferenteALista2 = new HashSet<>();

        for (T elementoDaLista2 : lista2) {
            conjuntoReferenteALista2.add(elementoDaLista2);
        }

        for (T elementoDaLista1 : lista1) {
            if (conjuntoReferenteALista2.contains(elementoDaLista1)) {
                cont++;
            }
        }

        return cont;
    }
}
