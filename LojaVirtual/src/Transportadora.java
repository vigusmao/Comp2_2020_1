import java.util.ArrayList;

public class Transportadora {

    private String nome;

    public void transportar(ArrayList<Transportavel> itens, String endereco) {
        System.out.println(
                String.format("Transportando %d itens para o endereço: %s",
                        itens.size(), endereco));
        // ToDo chamar de fato o serviço da transportadora física, emitindo OS
    }
}
