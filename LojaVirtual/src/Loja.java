import java.util.ArrayList;

/**
 * Loja virtual para a venda de livros (a princípio).
 */
public class Loja {

    private String nomeDaLoja;

    private ArrayList<Produto> catalogo;

    private Transportadora frete;

    public Loja(Transportadora transportadora) {
        catalogo = new ArrayList<>();  // COMPOSIÇÃO
        setFrete(transportadora);      // AGREGAÇÃO
    }

    public void setFrete(Transportadora transportadora) {
        frete = transportadora;
    }

    public String receberPedido(Produto produto, int quantidade, Usuario usuario) {

        // verifica se existe no catálogo da loja
        if (buscarProduto(produto.getId()) == null) {
            // ToDo lançar uma exceção específica
            return null;
        }

        // verifica se o usuário tem um endereço de entrega válido
        if (usuario.getEndereco() == null) {
            // Todo lançar uma exceção específica
            return null;
        }

        float precoTotal = quantidade * produto.getPrecoEmReais();

        if (!processarPagamento(precoTotal)) {
            // ToDo lançar uma exceção específica
            return null;
        }

        // cria um array com todos os livros que precisarão ser entregues
        // (possivelmente várias unidades do mesmo produto)
        ArrayList<Produto> pedido = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            pedido.add(produto);
        }

        frete.transportar(pedido, usuario.getEndereco());

        String recibo = String.format("Recibo no valor de R$%.2f referente à " +
                "compra de %d unidades do produto: %s",
                precoTotal, quantidade, produto);

        return recibo;
    }

    public void incluirProduto(Produto produto) {
        if (buscarProduto(produto.getId()) != null) {
            // produto já existe no catálogo -- nada a fazer
            return;
        }
        catalogo.add(produto);
    }

    /**
     * Busca um produto no catálogo da loja a partir de sua descrição.
     *
     * @param descricao a descrição do produto desejado (ou parte dela)
     * @return o primeiro Produto que case com a descrição fornecida, caso encontre;
     *         ou null, caso contrário
     */
    public Produto buscarProduto(String descricao) {
        for (Produto produto : catalogo) {
            if (produto.getDescricao().contains(descricao)) {
                return produto;
            }
        }
        return null;
    }

    /**
     * Busca um produto no catálogo da loja a partir de seu código.
     *
     * @param id o código de identificação do produto desejado
     * @return o Produto cujo código seja igual ao código fornecido, caso encontre;
     *         ou null, caso contrário
     */
    public Produto buscarProduto(long id) {
        for (Produto produto : catalogo) {
            if (produto.getId() == id) {
                return produto;
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
