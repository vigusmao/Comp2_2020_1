import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContadorOcorrenciasTest {

    private ContadorOcorrencias<String> contadorOcorrencias;

    @Before
    public void setUp() {
        contadorOcorrencias = new ContadorOcorrenciasUsandoHashMap<>();
    }

    @Test
    public void testarFuncionamentoBasico() {
        List<String> minhaLista = new ArrayList<>();
        minhaLista.add("10");
        minhaLista.add("-555");
        minhaLista.add("11");
        minhaLista.add("12");
        minhaLista.add("10");
        minhaLista.add("100");
        minhaLista.add("100");
        minhaLista.add("100");
        minhaLista.add("3");
        minhaLista.add("10");
        minhaLista.add("10");
        minhaLista.add("10");
        minhaLista.add("3");

        assertEquals("10", contadorOcorrencias.retornarElementoMaisFrequente(minhaLista));
    }

    @Test
    public void testarPerformance() {
        int EXPOENTE = 10;
        int TAMANHO = (int) Math.pow(2, EXPOENTE) - 1;

        List<String> lista = new ArrayList<>();

        for (int i = 1; i <= TAMANHO; i++) {
            lista.add("" + (int) (Math.log(i) / Math.log(2)));
        }

        long inicio = System.currentTimeMillis();
        assertEquals("" + (EXPOENTE - 1),
                contadorOcorrencias.retornarElementoMaisFrequente(lista));
        final long duracaoEmMilis = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuração (%s) = %.3f",
                contadorOcorrencias.getClass().getName(), duracaoEmMilis / 1000f);
    }

}