public class DadosDeGamao implements Sorteador {

    private Dado dadoComum;

    public DadosDeGamao() {
        dadoComum = new Dado();
    }

    @Override
    public int sortear() {
        int resultado1 = dadoComum.sortear();
        int resultado2 = dadoComum.sortear();

        int soma = resultado1 + resultado2;

        return resultado1 == resultado2
                ? 2 * soma
                : soma;
    }
}
