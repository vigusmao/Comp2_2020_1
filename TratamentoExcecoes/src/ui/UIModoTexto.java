package ui;

import controle.ClasseA;
import excecoes.ControleException;
import excecoes.LimiteExcedidoException;

public class UIModoTexto {

    public static void main(String[] args) throws LimiteExcedidoException, ControleException {
        System.out.println("Oi!");

        ClasseA objetoClasseA = new ClasseA();
        objetoClasseA.facaAlgo();
    }
}
