import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContadorOcorrenciasUsandoHashMap
        implements ContadorOcorrencias {

    @Override
    public Integer retornarElementoMaisFrequente(List<Integer> lista) {

        Integer elementoMaisFrequenteAteOMomento = null;
        int ocorrenciasDoElementoMaisFrequente = 0;


        Map<Integer, Integer> numeroDeOcorrenciasPorElemento = new HashMap<>();

        for (Integer elementoDaVez : lista) {

            // leio o que já tenho até aqui
            int ocorrenciasAnterioresDoElemento =
                    numeroDeOcorrenciasPorElemento.getOrDefault(elementoDaVez, 0);

            // atualiza no mapa
            final int ocorrenciasPresentesDoElemento = ocorrenciasAnterioresDoElemento + 1;
            numeroDeOcorrenciasPorElemento.put(
                    elementoDaVez, ocorrenciasPresentesDoElemento);

            // atualizo as variáveis locais que estão observando o mais frequente já visto
            if (ocorrenciasPresentesDoElemento > ocorrenciasDoElementoMaisFrequente) {
                elementoMaisFrequenteAteOMomento = elementoDaVez;
                ocorrenciasDoElementoMaisFrequente = ocorrenciasPresentesDoElemento;
            }
        }

        return elementoMaisFrequenteAteOMomento;
    }
}
