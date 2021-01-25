import java.util.ArrayList;

public abstract class JogoDeDoisJogadores {

    private String nomeJogo;
    private String nomeJogador1;
    private String nomeJogador2;
    private int numeroDeRodadas;
    private ArrayList<Integer> historicoResultados;

    public JogoDeDoisJogadores(
            String nomeJogo, String nomeJogador1,
            String nomeJogador2, int numeroDeRodadas) {

        this.nomeJogo = nomeJogo;
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroDeRodadas = numeroDeRodadas;

        this.historicoResultados = new ArrayList<>();
    }

    public String getNomeJogo() {
       return nomeJogo;
    }

    public String getNomeJogador1() {
        return nomeJogador1;
    }

    public String getNomeJogador2() {
        return nomeJogador2;
    }

    public int getNumeroDeRodadas() {
        return numeroDeRodadas;
    }

    public String jogar() {

        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;
        int empates = 0;

        for (int i = 1; i <= this.numeroDeRodadas; i++) {
            int resultadoDaRodada = executarRodadaDoJogo();
            switch (resultadoDaRodada) {
                case 1:
                    vitoriasJogador1++;
                    break;
                case 2:
                    vitoriasJogador2++;
                    break;
                case 0: default:
                    empates++;
            }
        }

        String formatoVitoria = "O jogador %s venceu o jogo por %d a %d.";
        String formatoEmpate = "O jogo terminou em empate após %d rodadas.";

        if (vitoriasJogador1 > vitoriasJogador2) {
            return String.format(formatoVitoria, nomeJogador1, vitoriasJogador1, vitoriasJogador2);
        } else if (vitoriasJogador2 > vitoriasJogador1) {
            return String.format(formatoVitoria, nomeJogador2, vitoriasJogador2, vitoriasJogador1);
        } else {
            return String.format(formatoEmpate, this.numeroDeRodadas);
        }
    }

    protected abstract int executarRodadaDoJogo();
}
