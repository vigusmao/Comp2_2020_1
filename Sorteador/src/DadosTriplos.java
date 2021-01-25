public class DadosTriplos implements Sorteador {

    private Dado dadoComum;

    public DadosTriplos() {
        dadoComum = new Dado();
    }

    @Override
    public int sortear() {
        int resultado = 0;
        for (int i = 1; i <= 3; i++) {
            resultado += dadoComum.sortear();
        }
        return  resultado;
    }
}
