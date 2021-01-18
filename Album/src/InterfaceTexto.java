public class InterfaceTexto {


    /**
     * Main apenas para testes muito rápidos. Melhor seria escrever unit tests de verdade.
     * Na prática, o seu "main()" abriria uma interface de texto de verdade,
     * apresentando um menu, etc.
     *
     * @param args
     */
    public static void main(String[] args) {

        RepositorioSelos repositorioSelos = new RepositorioSelos("AlbumFigurinhas Teste", 200);
        AlbumSelos albumSelos = new AlbumSelos(repositorioSelos, 3);

        PacotinhoSelos p1 = new PacotinhoSelos(repositorioSelos, new int[] {1, 6, 18});

        albumSelos.receberNovoPacotinho(p1);

        System.out.println("Possui selo 1? " + albumSelos.possuiSeloColado(1));
        System.out.println("Possui selo 6? " + albumSelos.possuiSeloColado(6));
        System.out.println("Possui selo 18? " + albumSelos.possuiSeloColado(18));
        System.out.println("Possui selo 60? " + albumSelos.possuiSeloColado(60));

        System.out.println("Quant selos coladas? " + albumSelos.getQuantFigurinhasColadas());

        PacotinhoSelos p2 = new PacotinhoSelos(repositorioSelos, new int[] {3, 6, 44});
        albumSelos.receberNovoPacotinho(p2);

        System.out.println("Tem selo repetida 6? " + albumSelos.possuiFigurinhaRepetida(6));
        System.out.println("Quant selos coladas? " + albumSelos.getQuantFigurinhasColadas());
    }
}
