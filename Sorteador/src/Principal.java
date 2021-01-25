public class Principal {

    public static void main(String[] args) {

        for (int numeroRodadas = 1; numeroRodadas <= 100; numeroRodadas++) {
            JogoMalucoComSorteadores jogo = new JogoMalucoComSorteadores(
                    "Jogo Maluco", "Andre", "Beatriz", numeroRodadas,
                    new DadosDeGamao(), new DadosTriplos());
            System.out.println("rodadas: " + numeroRodadas + " ---> " + jogo.jogar());
        }
    }
}
