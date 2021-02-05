import java.util.List;

public class ContadorOcorrenciasPercorrendoAListaInteiraParaCadaElemento
        implements ContadorOcorrencias {

    @Override
    public Integer retornarElementoMaisFrequente(List<Integer> lista) {

        Integer elementoMaisFrequenteAteOMomento = null;
        int ocorrenciasDoElementoMaisFrequente = 0;


        for (int i = 0; i < lista.size(); i++) {
            Integer elementoDaVez = lista.get(i);

            int ocorrenciasDoElementoDaVez = 0;
            for (int j = 0; j < lista.size(); j++) {
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
