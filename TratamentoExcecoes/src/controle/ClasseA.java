package controle;

import excecoes.LimiteExcedidoException;

public class ClasseA {

    public void facaAlgo() {

        ClasseB objetoClasseB = new ClasseB();

        try {
            objetoClasseB.executarUmaRotinaQualquer(12, 1.50f);
        } catch (Exception e) {

            throw new ControleException("Deu ruim!");
        }


    }
}
