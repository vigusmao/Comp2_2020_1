import org.junit.Test;

import static org.junit.Assert.*;

public class BancoTest {

    @Test
    public void testeDePerformance() {
        final int TAMANHO = 10_000;

        Banco banco = new Banco();

        for (int i = 1; i <= TAMANHO; i++) {
            banco.cadastrarCorrentista("Correntista Numero " + i, i);
        }

        for (int i = 1; i <= TAMANHO; i++) {
            assertNotNull(banco.localizarCorrentista(i));
        }

        for (int i = TAMANHO + 1; i <= 2 * TAMANHO; i++) {
            assertNull(banco.localizarCorrentista(i));
        }
    }
}