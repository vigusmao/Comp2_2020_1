/**
 * Guia turístico para determinada cidade.
 * Possui uma lista de estabelecimentos, todos eles devidamente pontuados.
 * Possui a funcionalidade de indicar o estabelecimento melhor pontuado
 * dentre aqueles do tipo desejado (hotel, restaurante, etc.).
 *
 * @param <T> O tipo de estabelecimento de que o guia vai tratar.
 *            Pode-se desejar um guia apenas de restaurantes, por exemplo.
 */
public class GuiaTuristico<T extends EstabelecimentoAvaliado> {

    private static final int MAX_ESTABELECIMENTOS = 1000;

    private final String cidade;

    private EstabelecimentoAvaliado[] estabelecimentos;

    private int contEstabelecimentos;

    public static int quantidadeGuias = 0;

    public GuiaTuristico(String cidade) {
        this.cidade = cidade;
        this.estabelecimentos = new EstabelecimentoAvaliado[MAX_ESTABELECIMENTOS];
        quantidadeGuias++;
    }

    public void incluirEstabelecimento(T estabelecimento) throws EnderecoInvalidoException {
        if (estabelecimento == null) {
            throw new IllegalArgumentException("Estabelecimento nulo");
        }
        if (estabelecimento.getEndereco() == null) {
            throw new EnderecoInvalidoException("Estabelecimento sem endereço cadastrado");
        }
        if (!estabelecimento.getEndereco().getCidade().equals(this.cidade)) {
            throw new EnderecoInvalidoException("Estabelecimento de cidade não coberta por este Guia");
        }
        this.estabelecimentos[this.contEstabelecimentos++] = estabelecimento;
    }

    /**
     * Retorna o estabelecimento (do tipo desejado) de melhor avaliação
     * @param tipo o tipo desejado de estabelecimento
     * @return o estabelecimento sugerido
     */
    @SuppressWarnings("unchecked")
    public T sugerirEstabelecimento(String tipo) {
        T melhorAvaliado = null;
        int pontuacaoDoMelhorAvaliado = -1;
        for (int i = 0; i < this.contEstabelecimentos; i++) {

            T estabelecimento = (T) this.estabelecimentos[i];

            if (estabelecimento.getTipoEstabelecimento().equals(tipo)) {
                int nota = estabelecimento.getAvaliacao();
                if (nota > pontuacaoDoMelhorAvaliado) {
                    pontuacaoDoMelhorAvaliado = nota;
                    melhorAvaliado = estabelecimento;
                }
            }
        }
        return melhorAvaliado;
    }

    public static int getQuantidadeGuias() {
        return quantidadeGuias;
    }
}