import java.util.List;

public class ContadorOcorrenciasPercorrendoAListaAPartirDaPosicaoDeCadaElemento
        implements ContadorOcorrencias {

    @Override
    public Integer retornarElementoMaisFrequente(List<Integer> lista) {

        Integer elementoMaisFrequenteAteOMomento = null;
        int ocorrenciasDoElementoMaisFrequente = 0;


        for (int i = 0; i < lista.size(); i++) {
            Integer elementoDaVez = lista.get(i);

            int ocorrenciasDoElementoDaVez = 1;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j).equals(elementoDaVez)) {
                    ocorrenciasDoElementoDaVez++;
                }
            }

            if (ocorrenciasDoElementoDaVez > ocorrenciasDoElementoMaisFrequente) {
                elementoMaisFrequenteAteOMomento = elementoDaVez;
                ocorrenciasDoElementoMaisFrequente = ocorrenciasDoElementoDaVez;
            }
        }

        return elementoMaisFrequenteAteOMomento;
    }
}
