import java.util.ArrayList;

public class Transportadora {

    private String nome;

    public void transportar(ArrayList<Produto> produtos, String endereco) {
        System.out.println(
                String.format("Transportando %d produtos para o endereço: %s",
                        produtos.size(), endereco));
        // ToDo chamar de fato o serviço da transportadora física, emitindo OS
    }
}
