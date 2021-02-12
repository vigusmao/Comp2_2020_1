package controle;

import excecoes.LimiteExcedidoException;
import excecoes.SituacaoAleatoriaException;

import java.util.Random;

public class ClasseC {

    private int limite;

    private Random random;

    public ClasseC(int limite) {
        this.random = new Random();
        this.limite = limite;
    }

    /**
     * Retorna o quadrado do número mais 100.
     *
     * @param x o número desejado
     * @return x^2 + 100
     *
     * @throws SituacaoAleatoriaException lança esta exceção aleatoriamente
     *           com probabilidade 0.5%
     * @throws LimiteExcedidoException é lançada se x for maior do que o limite
     *           pré-estabelecido (passado no construtor deste objeto)
     */
    public int facaAlgoComUmNumero(int x)
            throws SituacaoAleatoriaException, LimiteExcedidoException {

        System.out.println("ClasseC: executando facaAlgoComUmNumero...");

        if (random.nextInt() % 200 == 1) {
            System.out.println("ClasseC: vou lançar SituacaoAleatoriaException...");
            throw new SituacaoAleatoriaException();
        }

        if (x < 0) {
            System.out.println("ClasseC: vou lançar IllegalArgumentException(RUNTIME!!!!!)...");
            throw new IllegalArgumentException();  // runtime exception
        }

        if (x > limite) {
            System.out.println("ClasseC: vou lançar LimiteExcedidoException...");
            throw new LimiteExcedidoException();
        }

        System.out.println("ClasseC: cheguei ao final do facaAlgoComUmNumero sem lançar exceção.");

        return x*x + 100;

    }
}
