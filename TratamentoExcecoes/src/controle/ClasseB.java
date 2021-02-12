package controle;

import excecoes.ControleException;
import excecoes.LimiteExcedidoException;
import excecoes.SituacaoAleatoriaException;

public class ClasseB {

    private ClasseC objetoDaClasseC;

    private int contSituacoesAleatorias;

    public ClasseB(int limite) {
        contSituacoesAleatorias = 0;
        objetoDaClasseC = new ClasseC(limite);   // composição
    }

    public void executarUmaRotinaQualquer(
            int idade, float alturaEmMetros)
            throws ControleException {

        System.out.println("ClasseB: executarUmaRotinaQualquer()...");

        // faça algo

        // agora faça essa outra coisa


        boolean concluido = false;

        while (!concluido) {

            // agora chame o método do objeto da ClasseC
            try {
                final int parametro = idade - 10;
                System.out.println(
                        "ClasseB: vou chamar classeC.facaAlgoComUmNumero(" +
                        parametro + ")...");
                this.objetoDaClasseC.facaAlgoComUmNumero(parametro);

                System.out.println("ClasseB: continuando no bloco try depois da chamada ao método crítico...");

                return;


            } catch (SituacaoAleatoriaException e) {
                System.out.println("ClasseB: capturei uma SituacaoAleatoriaException!!");
                contSituacoesAleatorias++;

                // vou deixar tentar novamente, basta seguir sem sair do while

            } catch (Exception e) {
                System.out.println("ClasseB: capturei uma exceção no catch genérico: " + e.getClass());
                System.out.println("ClasseB: vou agora lançar uma ControleException...");
                throw new ControleException();

            } finally {
                System.out.println("ClasseB: Entrando no bloco finally...");
            }

            System.out.println("ClasseB: continuando depois do try...catch");
        }

        System.out.println("ClasseB: saí do while, chegando ao final do método.");
    }
}
