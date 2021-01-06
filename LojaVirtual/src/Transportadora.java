import java.util.ArrayList;

public class Transportadora {

    private String nome;

    public void transportar(ArrayList<Livro> livros, String endereco) {
        System.out.println(
                String.format("Transportando %d livros para o endereço: %s",
                        livros.size(), endereco));
        // ToDo chamar de fato o serviço da transportadora física, emitindo OS
    }
}
