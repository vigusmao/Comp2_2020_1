import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MapaTest {

    private Random random = new Random();

    private Mapa<Long, String> mapaUsandoDoisArraysParalelos;
    private Mapa<Long, String> mapaUsandoArrayUnico;
    private Mapa<Long, String> mapaUsandoArrayOrdenado;

    @Before
    public void setUp() {
        mapaUsandoDoisArraysParalelos = new MapaUsandoDoisArraysParalelos<>();
        mapaUsandoArrayUnico = new MapaUsandoArrayUnico<>();
        mapaUsandoArrayOrdenado = new MapaUsandoArrayOrdenado<>();
    }

    @Test
    public void testeFuncionalidadeBasica() {
        rodarTesteDaFuncionalidadeBasica(mapaUsandoArrayUnico);
        rodarTesteDaFuncionalidadeBasica(mapaUsandoDoisArraysParalelos);
    }

    private void rodarTesteDaFuncionalidadeBasica(Mapa<Long, String> mapa) {
        mapa.adicionar(1234L, "Qualquer Coisa");
        mapa.adicionar(2222L, "Outra Coisa Qualquer");

        assertEquals("Outra Coisa Qualquer", mapa.recuperarValor(2222L));
        assertEquals("Qualquer Coisa", mapa.recuperarValor(1234L));
        assertNull(mapa.recuperarValor(8798798L));
    }

    @Test
    public void testeAtualizacaoParaChaveExistente() {
        rodarTesteAtualizacaoParaChaveExistente(mapaUsandoArrayUnico);
        rodarTesteAtualizacaoParaChaveExistente(mapaUsandoDoisArraysParalelos);
    }

    private void rodarTesteAtualizacaoParaChaveExistente(Mapa<Long, String> mapa) {
        mapa.adicionar(1234L, "Qualquer Coisa");
        mapa.adicionar(1234L, "Qualquer Coisa Modificada");

        assertEquals("Qualquer Coisa Modificada", mapa.recuperarValor(1234L));
    }

    @Test
    public void testarPerformance() {
        rodarTesteDePerformance(mapaUsandoArrayOrdenado, false);
        rodarTesteDePerformance(mapaUsandoArrayUnico, false);
//        rodarTesteDePerformance(mapaUsandoDoisArraysParalelos, false);

        rodarTesteDePerformance(mapaUsandoArrayOrdenado, true);
        rodarTesteDePerformance(mapaUsandoArrayUnico, true);
//        rodarTesteDePerformance(mapaUsandoDoisArraysParalelos, true);

    }

    private void rodarTesteDePerformance(Mapa<Long, String> mapa, boolean verboso) {
        if (verboso) System.out.println("\nRodando teste de performance para a classe " +
                mapa.getClass().getName() + "...");

        final int TAMANHO = 60_000;

        if (verboso) System.out.println("Vou fazer as inserções...");

        long inicio = System.currentTimeMillis();
        for (long i = 0; i < TAMANHO; i++) {
            long x = random.nextInt(10000);
            mapa.adicionar(x, String.format("%d^2 = %d", x, x*x));
        }
        long duracao = System.currentTimeMillis() - inicio;
        if (verboso) System.out.printf("tamanho = %d --- duracao = %.3f segundos\n",
                TAMANHO, duracao / 1000f);

//        System.out.println("Vou fazer as buscas...");
//        inicio = System.currentTimeMillis();
//        for (long i = 0; i < TAMANHO; i++) {
//            mapa.recuperarValor(i);
//        }
//        duracao = System.currentTimeMillis() - inicio;
//        System.out.printf("tamanho = %d --- duracao = %.3f segundos\n",
//                TAMANHO, duracao / 1000f);
    }


}