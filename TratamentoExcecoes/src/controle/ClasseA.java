package controle;

import excecoes.ControleException;
import excecoes.LimiteExcedidoException;

public class ClasseA {

    public void facaAlgo() throws ControleException {

        System.out.println("ClasseA: facaAlgo()...");

        ClasseB objetoClasseB = new ClasseB(10);

        try {
            System.out.println("ClasseA: vou chamar classeB.executarUmaRotinaQualquer(12, 1.50f)...");
            objetoClasseB.executarUmaRotinaQualquer(12, 1.50f);
        } catch (ControleException e) {
            System.out.println("ClasseA: capturei uma ControleException...");
            System.out.println("ClasseA: vou agora printar o stack trace...");
            e.printStackTrace();
        }

        System.out.println("ClasseA: cheguei ao fim.");
    }
}
