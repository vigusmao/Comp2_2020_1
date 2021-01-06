import java.util.ArrayList;

/**
 * Loja virtual para a venda de livros (a princípio).
 */
public class Loja {

    private String nomeDaLoja;

    private ArrayList<Livro> catalogo;

    private Transportadora frete;

    public Loja(Transportadora transportadora) {
        catalogo = new ArrayList<>();  // COMPOSIÇÃO
        setFrete(transportadora);      // AGREGAÇÃO
    }

    public void setFrete(Transportadora transportadora) {
        frete = transportadora;
    }

    public String receberPedido(Livro livro, int quantidade, Usuario usuario) {

        // verifica se existe no catálogo da loja
        if (buscarLivro(livro.getTitulo(), livro.getAutor()) == null) {
            // ToDo lançar uma exceção específica
            return null;
        }

        // verifica se o usuário tem um endereço de entrega válido
        if (usuario.getEndereco() == null) {
            // Todo lançar uma exceção específica
            return null;
        }

        float precoTotal = quantidade * livro.getPrecoEmReais();

        if (!processarPagamento(precoTotal)) {
            // ToDo lançar uma exceção específica
            return null;
        }

        // cria um array com todos os livros que precisarão ser entregues
        // (possivelmente várias unidades do mesmo livro)
        ArrayList<Livro> pedido = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            pedido.add(livro);
        }

        frete.transportar(pedido, usuario.getEndereco());

        String recibo = String.format("Recibo no valor de R$%.2f referente à " +
                "compra de %d unidades do livro: %s",
                precoTotal, quantidade, livro);

        return recibo;
    }

    public void incluirLivro(Livro livro) {
        if (buscarLivro(livro.getTitulo(), livro.getAutor()) != null) {
            // livro já existe no catálogo -- nada a fazer
            return;
        }
        catalogo.add(livro);
    }

    /**
     * Busca um livro no catálogo da loja a partir do título e do autor informados.
     *
     * @param titulo o título
     * @param autor o autor
     * @return um Livro, caso encontre; ou null, caso contrário
     */
    public Livro buscarLivro(String titulo, String autor) {
        for (Livro livro : catalogo) {
            if (livro.getTitulo().equals(titulo) &&
                    livro.getAutor().equals(autor)) {
                return livro;
            }
        }
        return null;
    }

    private boolean processarPagamento(float valor) {
        // ToDo passar o cartão de crédito, ou emitir boleto, etc.
        System.out.println(String.format(
                "Processando pagamento no valor de R$%.2f...",
                valor));
        return true;  // ToDo retornar false caso o pagamento falhe
    }
}
