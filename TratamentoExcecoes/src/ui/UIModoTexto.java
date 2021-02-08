package ui;

import controle.ClasseA;
import excecoes.LimiteExcedidoException;

public class UIModoTexto {

    public static void main(String[] args) throws LimiteExcedidoException {
        System.out.println("Oi!");

        ClasseA objetoClasseA = new ClasseA();
        objetoClasseA.facaAlgo();
    }
}
