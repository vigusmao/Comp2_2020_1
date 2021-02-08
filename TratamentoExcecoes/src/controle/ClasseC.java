package controle;

import excecoes.LimiteExcedidoException;
import excecoes.SituacaoAleatoriaException;

public class ClasseC {

    private int limite;

    public ClasseC(int limite) {
        this.limite = limite;
    }

    public int facaAlgoComUmNumero(int x)
            throws SituacaoAleatoriaException, LimiteExcedidoException {

        if (System.currentTimeMillis() % 100 == 1) {
            throw new SituacaoAleatoriaException();
        }

        if (x < 0) {
            throw new IllegalArgumentException();  // runtime exception
        }

        if (x > limite) {
            throw new LimiteExcedidoException();
        }

        return x*x + 100;

    }
}
