import java.util.HashMap;
import java.util.Map;

public class Banco {

    Map<Long, ContaCorrente> contaPorNumero;
    Map<Long, Pessoa> correntistaPorCpf;

    private Agencia agenciaUnica;

    public Banco() {
        contaPorNumero = new HashMap<>();
        correntistaPorCpf = new HashMap<>();
        agenciaUnica = new Agencia();
    }

    public Pessoa cadastrarCorrentista(String nome, long cpf) {
        Pessoa p = localizarCorrentista(cpf);
        if (p != null) {
            // Localizei o correntista! Não é preciso recriá-lo! Podemos atualizar o nome, se for o caso.
            p.setNome(nome);
        } else {
            // Correntista novo
            p = new Pessoa(nome, cpf);
            correntistaPorCpf.put(cpf, p);
        }
        return p;
    }

    public ContaCorrente cadastrarConta(Pessoa correntista) {
        // verifica correntista
        if (localizarCorrentista(correntista.getCpf()) == null) {
            // correntista não existe!!
            // ToDo lançar uma exceção!
            return null;  // não vou criar conta coisíssima nenhuma!
        }

        // aceitamos mais de uma conta para o mesmo correntista

        ContaCorrente novaConta = new ContaCorrente(correntista, this.agenciaUnica);
        this.contaPorNumero.put(novaConta.getNumeroDaConta(), novaConta);

        return novaConta;
    }

    public Pessoa localizarCorrentista(long cpf) {
        return this.correntistaPorCpf.get(cpf);
    }

    public ContaCorrente localizarConta(long numeroDaConta) {
        return this.contaPorNumero.get(numeroDaConta);
    }
}
