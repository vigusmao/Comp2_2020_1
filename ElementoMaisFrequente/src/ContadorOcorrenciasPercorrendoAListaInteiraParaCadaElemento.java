import java.util.List;

public class ContadorOcorrenciasPercorrendoAListaInteiraParaCadaElemento<T>
        implements ContadorOcorrencias<T> {

    @Override
    public T retornarElementoMaisFrequente(List<T> lista) {

        T elementoMaisFrequenteAteOMomento = null;
        int ocorrenciasDoElementoMaisFrequente = 0;


        for (int i = 0; i < lista.size(); i++) {
            T elementoDaVez = lista.get(i);

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
