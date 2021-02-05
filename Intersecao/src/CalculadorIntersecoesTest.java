import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculadorIntersecoesTest {

    private CalculadorIntersecoes<Integer> calculadorIntersecoes;

    @Before
    public void setUp() {
        calculadorIntersecoes = new CalculadorIntersecoesEsperto<>();
    }

    @Test
    public void testarFuncionalidadeBasica() {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();

        lista1.add(1);
        lista1.add(2);
        lista1.add(3);
        lista1.add(4);
        lista1.add(5);
        lista1.add(6);
        lista1.add(7);

        lista2.add(1);
        lista2.add(3);
        lista2.add(5);
        lista2.add(7);
        lista2.add(9);

        assertEquals(4,
                calculadorIntersecoes.obterQuantidadeElementosComuns(
                        lista1, lista2));

    }

    @Test
    public void testarPerformance() {
        int TAMANHO = 50_000;

        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();

        for (int i = 1; i <= TAMANHO; i++) {
            lista1.add(i);
            lista2.add(2 * i);
        }

        long inicio = System.currentTimeMillis();
        calculadorIntersecoes.obterQuantidadeElementosComuns(
                lista1, lista2);
        long duracaoEmMilis = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuração (%s) = %.3fs",
                calculadorIntersecoes.getClass().getName(),
                duracaoEmMilis / 1000f);

    }

}