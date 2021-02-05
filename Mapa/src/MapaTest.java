import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class MapaTest {

    private Random random = new Random();

    private Map<Long, String> mapaUsandoDoisArraysParalelos;
    private Map<Long, String> mapaUsandoArrayNaoOrdenado;
    private Map<Long, String> mapaUsandoArrayOrdenado;
    private Map<Long, String> hashMap;

    @Before
    public void setUp() {
        mapaUsandoDoisArraysParalelos = new MapaUsandoDoisArraysParalelos<>();
        mapaUsandoArrayNaoOrdenado = new MapaUsandoArrayNaoOrdenado<>();
        mapaUsandoArrayOrdenado = new MapaUsandoArrayOrdenado<>();
        hashMap = new HashMap<>();
    }

    @Test
    public void testeFuncionalidadeBasica() {
        rodarTesteDaFuncionalidadeBasica(mapaUsandoArrayNaoOrdenado);
        rodarTesteDaFuncionalidadeBasica(mapaUsandoArrayOrdenado);
        rodarTesteDaFuncionalidadeBasica(mapaUsandoDoisArraysParalelos);
        rodarTesteDaFuncionalidadeBasica(hashMap);
    }

    private void rodarTesteDaFuncionalidadeBasica(Map<Long, String> mapa) {
        mapa.put(1234L, "Qualquer Coisa");
        mapa.put(2222L, "Outra Coisa Qualquer");

        assertEquals("Outra Coisa Qualquer", mapa.get(2222L));
        assertEquals("Qualquer Coisa", mapa.get(1234L));
        assertNull(mapa.get(8798798L));
    }

    @Test
    public void testeIsEmpty() {
        rodarTesteParaClearEIsEmpty(mapaUsandoArrayNaoOrdenado);
        rodarTesteParaClearEIsEmpty(mapaUsandoArrayOrdenado);
        rodarTesteParaClearEIsEmpty(mapaUsandoDoisArraysParalelos);
        rodarTesteParaClearEIsEmpty(hashMap);
    }

    private void rodarTesteParaClearEIsEmpty(Map<Long, String> mapa) {
        mapa.put(1L, "Um");
        mapa.put(2L, "Dois");

        mapa.clear();

        assertTrue(mapa.isEmpty());
    }

    @Test
    public void testeRemove() {
        rodarTesteParaRemove(mapaUsandoArrayNaoOrdenado);
        rodarTesteParaRemove(mapaUsandoArrayOrdenado);
        rodarTesteParaRemove(mapaUsandoDoisArraysParalelos);
        rodarTesteParaRemove(hashMap);
    }

    private void rodarTesteParaRemove(Map<Long, String> mapa) {
        mapa.put(1L, "Um");
        mapa.put(2L, "Dois");
        mapa.put(3L, "Três");
        mapa.put(4L, "Quatro");

        mapa.remove(3L);

        assertTrue(mapa.containsKey(1L));
        assertTrue(mapa.containsKey(2L));
        assertFalse(mapa.containsKey(3L));
        assertTrue(mapa.containsKey(4L));
    }

    @Test
    public void testeAtualizacaoParaChaveExistente() {
        rodarTesteAtualizacaoParaChaveExistente(mapaUsandoArrayNaoOrdenado);
        rodarTesteAtualizacaoParaChaveExistente(mapaUsandoArrayOrdenado);
        rodarTesteAtualizacaoParaChaveExistente(mapaUsandoDoisArraysParalelos);
        rodarTesteAtualizacaoParaChaveExistente(hashMap);
    }

    private void rodarTesteAtualizacaoParaChaveExistente(Map<Long, String> mapa) {
        mapa.put(1234L, "Qualquer Coisa");
        mapa.put(1234L, "Qualquer Coisa Modificada");

        assertEquals("Qualquer Coisa Modificada", mapa.get(1234L));
    }

    @Test
    public void testarPerformance() {
        rodarTesteDePerformance(mapaUsandoArrayNaoOrdenado);
        rodarTesteDePerformance(mapaUsandoArrayOrdenado);
        rodarTesteDePerformance(mapaUsandoDoisArraysParalelos);
        rodarTesteDePerformance(hashMap);
    }

    private void rodarTesteDePerformance(Map<Long, String> mapa) {
        System.out.println("\nRodando teste de performance para a classe " +
                mapa.getClass().getName() + "...");

        final int QUANT_ELEMENTOS = 400_000;
        final int QUANT_BUSCAS = 10_000;

        System.out.println("Vou fazer as inserções...");

        long inicio = System.currentTimeMillis();
        for (long i = 0; i < QUANT_ELEMENTOS; i++) {
            long x = random.nextInt(1_000_000);
            mapa.put(x, String.format("%d^2 = %d", x, x*x));
        }
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("tamanho = %d --- duracao = %.3f segundos\n",
                QUANT_ELEMENTOS, duracao / 1000f);

        System.out.println("Vou fazer as buscas...");
        inicio = System.currentTimeMillis();
        for (long i = 0; i < QUANT_BUSCAS; i++) {
            mapa.get(random.nextLong());
        }
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf("tamanho = %d --- duracao = %.3f segundos\n",
                QUANT_ELEMENTOS, duracao / 1000f);
    }
}