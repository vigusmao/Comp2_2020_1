import java.util.ArrayList;

public class MapaUsandoArrayOrdenado<C extends Comparable<C>, V> implements Mapa<C, V> {

    private ArrayList<ParChaveValor<C, V>> minhaListaOrdenadaDePares;

    public MapaUsandoArrayOrdenado() {
        this.minhaListaOrdenadaDePares = new ArrayList<>();
    }

    @Override
    public void adicionar(C chave, V valor) {
        int posicaoParaInsercao = -1;

        for (int i = 0; i < this.minhaListaOrdenadaDePares.size(); i++) {
            ParChaveValor<C, V> par = this.minhaListaOrdenadaDePares.get(i);
            if (par.getChave().equals(chave)) {
                par.setValor(valor);
                return;  // chave já existia; nada mais a ser feito!
            }

            if (par.getChave().compareTo(chave) > 0) {
                // a chave da posição que estou olhando é maior do que a chave que quero adicionar

                posicaoParaInsercao = i;
                break;  // saio do for, pois já encontrei a posição para inserir
            }
        }

        if (posicaoParaInsercao == -1) {
            // minha chave é maior do que todas que existiam na lista,
            // então quero adicioná-la de fato no final da lista ordenada
            this.minhaListaOrdenadaDePares.add(new ParChaveValor<>(chave, valor));

        } else {
            // preciso inserir "no meio" da lista ordenada, então
            // antes vou mover os pares pré-existentes uma casa para a direita
            final ParChaveValor<C, V> ultimoParDaLista =
                    this.minhaListaOrdenadaDePares.get(getTamanho() - 1);

            this.minhaListaOrdenadaDePares.add(ultimoParDaLista);
            // isso abrirá uma nova posição no fim da lista,
            // repetindo a referência àquele mesmo último objeto ParChaveValor

            for (int i = getTamanho() - 3; // a penúltimo posição da lista ANTES do add
                 i >= posicaoParaInsercao;
                 i--) {

                // shift right
                this.minhaListaOrdenadaDePares.set(i + 1,
                        this.minhaListaOrdenadaDePares.get(i));
            }

            // agora sim posso setar o meu elemento na posição desejada
            this.minhaListaOrdenadaDePares.set(posicaoParaInsercao,
                    new ParChaveValor<>(chave, valor));
        }
    }

    @Override
    public V recuperarValor(C chaveDeBusca) {
        ParChaveValor<C, V> par = obterParChaveValor(chaveDeBusca);
        return par == null
                ? null
                : par.getValor();
    }

    private ParChaveValor<C, V> obterParChaveValor(C chave) {
        for (ParChaveValor<C, V> par : this.minhaListaOrdenadaDePares) {
            if (par.getChave().equals(chave)) {
                return par;
            }
        }
        return null;
    }

    public int getTamanho() {
        return this.minhaListaOrdenadaDePares.size();
    }
}
