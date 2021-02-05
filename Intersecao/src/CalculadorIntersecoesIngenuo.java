import java.util.List;

public class CalculadorIntersecoesIngenuo<T>
        implements CalculadorIntersecoes<T> {


    @Override
    public int obterQuantidadeElementosComuns(List<T> lista1, List<T> lista2) {
        int cont = 0;

        for (T elementoDaLista1 : lista1) {
            if (lista2.contains(elementoDaLista1)) {
                cont++;
            }
        }

        return cont;
    }
}
