package controle;

import com.sun.tools.javac.util.Position;
import excecoes.LimiteExcedidoException;
import excecoes.SituacaoAleatoriaException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClasseCTest {

    private ClasseC meuObjetoDaClasseC;

    private final static int LIMITE = 100;

    @Before
    public void setUp() {
        meuObjetoDaClasseC = new ClasseC(LIMITE);
    }

    @Test
    public void testeFuncionamentoNormal() throws SituacaoAleatoriaException, LimiteExcedidoException {
        int resultado = meuObjetoDaClasseC.facaAlgoComUmNumero(4);
        // estamos testando o fluxo normal; portanto queremos simplesmente
        // relançar para o chamador (JUnit) quaisquer exceções que ocorram
        // (elas não deveriam ocorrer, portanto queremos mesmo que o teste falhe!)

        assertEquals(116, resultado);
    }

    @Test
    public void testeSituacaoDeLimiteExcedido() throws SituacaoAleatoriaException {
        try {
            meuObjetoDaClasseC.facaAlgoComUmNumero(LIMITE + 1);
            fail("Uma LimiteExcedidoException deve ser produzida quando o parâmetro " +
                    "exceder o limite pré-estabelecido!");


        } catch (LimiteExcedidoException e) {
            // ok, não preciso fazer nada, era o esperado! O teste passou!!!
        }
    }

    @Test
    public void testeSituacaoDeExcecaoAleatoria() throws LimiteExcedidoException {
        boolean aconteceu = false;
        for (int i = 0; i < 5_000; i++) {
            try {
                meuObjetoDaClasseC.facaAlgoComUmNumero(4);
            } catch (SituacaoAleatoriaException e) {
                aconteceu = true;
                // a excecao que deve acontecer com baixa proabilidade
                // acabou de acontecer! ok, era o que queríamos testar!
                System.out.println("Finalmente aconteceu, na tentativa " + i);
                break;
            }
        }
        if (!aconteceu) {
            fail("A exceção aleatória não está acontecendo JAMAIS, o que é um problema!!!");
        }
    }

}