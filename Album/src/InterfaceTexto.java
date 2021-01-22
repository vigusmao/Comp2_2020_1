public class InterfaceTexto {


    /**
     * Main apenas para testes muito rápidos. Melhor seria escrever unit tests de verdade.
     * Na prática, o seu "main()" abriria uma interface de texto de verdade,
     * apresentando um menu, etc.
     *
     * @param args
     */
    public static void main(String[] args) {

        Repositorio repositorioSelos = new Repositorio("Album Teste", 200, "selo");

        Album albumSelos = new Album(repositorioSelos, 3);

        Pacotinho p1 = new Pacotinho(repositorioSelos, new int[] {1, 6, 18});

        albumSelos.receberNovoPacotinho(p1);

        System.out.println("Possui selo 1? " + albumSelos.possuiItemColado(1));
        System.out.println("Possui selo 6? " + albumSelos.possuiItemColado(6));
        System.out.println("Possui selo 18? " + albumSelos.possuiItemColado(18));
        System.out.println("Possui selo 60? " + albumSelos.possuiItemColado(60));

        System.out.println("Quant selos coladas? " + albumSelos.getQuantItensColados());

        Pacotinho p2 = new Pacotinho(repositorioSelos, new int[] {3, 6, 44});
        albumSelos.receberNovoPacotinho(p2);

        System.out.println("Tem selo repetida 6? " + albumSelos.possuiItemRepetido(6));
        System.out.println("Quant selos coladas? " + albumSelos.getQuantItensColados());
    }
}
