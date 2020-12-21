import org.junit.Test;

import static org.junit.Assert.*;

public class FracaoTest {

    @Test
    public void testarSimplificacao() {
        Fracao fracao = new Fracao(4, 6);

        assertEquals(4, fracao.getNumerador());
        assertEquals(6, fracao.getDenominador());

        fracao.simplificar();

        assertEquals(2, fracao.getNumerador());
        assertEquals(3, fracao.getDenominador());
    }

    @Test
    public void testarToString() {
        Fracao fracao = new Fracao(4, 6);
        assertEquals("4" + Fracao.SEPARADOR + "6", fracao.toString());
    }

    @Test
    public void testarToStringComNumeradorNegativo() {
        Fracao fracao = new Fracao(-4, 6);
        assertEquals("-4" + Fracao.SEPARADOR + "6", fracao.toString());
    }

    @Test
    public void testarToStringComNumeradorEDenominadorNegativos() {
        Fracao fracao = new Fracao(-4, -6);
        assertEquals("4" + Fracao.SEPARADOR + "6", fracao.toString());
    }

    @Test
    public void testarToStringComDenominadorUnitario() {
        Fracao fracao = new Fracao(5, 1);
        final String fracaoComoString = fracao.toString();
        assertEquals("5", fracaoComoString);
        // ou, equivalentemente...
        assertTrue(fracaoComoString.equals("5"));
    }

    @Test
    public void testarFracaoGeratriz() {
        Fracao fracao = new Fracao(-4, 6);

        assertEquals(4, fracao.getNumerador());
        assertEquals(6, fracao.getDenominador());
        assertFalse(fracao.getSinal());

        Fracao fracaoGeratriz = fracao.getFracaoGeratriz();

        assertEquals(fracao, fracaoGeratriz);  // precisam ser equals, uma vez que representam o mesmo
                                               // número racional

        assertEquals(2, fracaoGeratriz.getNumerador());
        assertEquals(3, fracaoGeratriz.getDenominador());
        assertFalse(fracaoGeratriz.getSinal());

        // quero verificar também que a fração original não foi modificada

        assertEquals(4, fracao.getNumerador());
        assertEquals(6, fracao.getDenominador());
        assertFalse(fracao.getSinal());
    }

    @Test
    public void testarFracaoGeratrizParaFracaoIrredutivel() {
        Fracao fracao = new Fracao(2, 7);

        Fracao fracaoGeratriz = fracao.getFracaoGeratriz();

        assertEquals(fracaoGeratriz, fracao);
        // equivalente a...
        assertTrue(fracao.equals(fracaoGeratriz));

        // Queremos, no entanto, algo ainda mais forte do que garantir a igualdade semântica.
        // Neste caso, queremos precisamente verificar que, quando a nossa fração já é,
        // ela própria, irredutível (isto é, não pode ser simplificada), a fração geratriz retornada
        // é ela própria, e não um outro objeto em memória.
        assertTrue(fracao == fracaoGeratriz);

    }

    @Test
    public void testarEqualsParaFracoesIdenticas() {
        Fracao x = new Fracao(-11, 30);
        Fracao y = new Fracao(-11, 30);
        assertEquals(x, y);   // x.equals(y)
    }

    @Test
    public void testarEqualsParaFracoesEquivalentes() {
        Fracao x = new Fracao(1, 3);
        Fracao y = new Fracao(2, 6);
        assertEquals(x, y);   // x.equals(y)
    }

    @Test
    public void testarEqualsParaFracoesComSinalTrocado() {
        Fracao x = new Fracao(1, 3);
        Fracao y = new Fracao(-1, 3);
        assertNotEquals(x, y);   // !x.equals(y)
    }
}