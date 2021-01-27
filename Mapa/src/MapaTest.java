import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void testeFuncionalidadeBasica() {
        Mapa<Long, String> mapa = new MinhaImplementacaoDeMapa<>();

        mapa.adicionar(1234L, "Qualquer Coisa");
        mapa.adicionar(2222L, "Outra Coisa Qualquer");

        assertEquals("Outra Coisa Qualquer", mapa.recuperarValor(2222L));
        assertEquals("Qualquer Coisa", mapa.recuperarValor(1234L));
        assertNull(mapa.recuperarValor(8798798L));
    }

    @Test
    public void testeAtualizacaoParaChaveExistente() {
        Mapa<Long, String> mapa = new MinhaImplementacaoDeMapa<>();

        mapa.adicionar(1234L, "Qualquer Coisa");
        mapa.adicionar(1234L, "Qualquer Coisa Modificada");

        assertEquals("Qualquer Coisa Modificada", mapa.recuperarValor(1234L));
    }

    @Test
    public void testarPerformance() {
        Mapa<Integer, String> mapa = new MinhaImplementacaoDeMapa<>();

        final int TAMANHO = 160_000;

        for (int i = 0; i < TAMANHO; i++) {
            mapa.adicionar(i, String.format("%d^2 = %d", i, i*i));
        }

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < TAMANHO; i++) {
            assertNotNull(mapa.recuperarValor(i));
        }

        System.out.println("Vou fazer as buscas...");
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\ntamanho = %d --- duracao = %.3f segundos\n",
                TAMANHO, duracao / 1000f);
    }


}