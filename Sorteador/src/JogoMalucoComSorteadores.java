public class JogoMalucoComSorteadores extends JogoDeDoisJogadores {

    private Sorteador sorteadorJogador1;
    private Sorteador sorteadorJogador2;

    public JogoMalucoComSorteadores(String nomeJogo, String nomeJogador1,
                                    String nomeJogador2, int numeroDeRodadas,
                                    Sorteador sorteadorJogador1, Sorteador sorteadorJogador2) {
        super(nomeJogo, nomeJogador1, nomeJogador2, numeroDeRodadas);
        this.sorteadorJogador1 = sorteadorJogador1;
        this.sorteadorJogador2 = sorteadorJogador2;
    }

    @Override
    protected int executarRodadaDoJogo() {
        int resultado1 = sorteadorJogador1.sortear();
        int resultado2 = sorteadorJogador2.sortear();

        if (resultado1 > resultado2) {
            return 1;
        } else if (resultado2 > resultado1) {
            return 2;
        } else {
            return 0;
        }
    }
}
