package controle;

import excecoes.LimiteExcedidoException;
import excecoes.SituacaoAleatoriaException;

public class ClasseB {

    private ClasseC objetoDaClasseC;

    private int contSituacoesAleatorias;

    public ClasseB() {
        contSituacoesAleatorias = 0;
        objetoDaClasseC = new ClasseC(300);   // composição
    }

    public void executarUmaRotinaQualquer(int idade, float alturaEmMetros)
            throws LimiteExcedidoException {

        // faça algo

        // agora faça essa outra coisa


        boolean concluido = false;

        while (!concluido) {

            // agora chame o método do objeto da ClasseC
            try {
                this.objetoDaClasseC.facaAlgoComUmNumero(idade - 10);
                concluido = true;

            } catch (SituacaoAleatoriaException e) {
                contSituacoesAleatorias++;
                // vou deixar tentar novamente, basta seguir sem sair do while
            }
        }
    }


}
