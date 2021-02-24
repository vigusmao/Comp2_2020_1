import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Conta {

    // o banco já te dá algo como estímulo :-)
    public static final float SALDO_INICIAL_DE_NOVAS_CONTAS = 10.0f;

    //limite comum a todas as contas
    public static final float LIMITE_CHEQUE_ESPECIAL = 200.0f;

    // não é permitido investir em doses homeopáticas! :-)
    public static final float APORTE_MINIMO_PARA_INVESTIMENTOS = 500.0f;

    private final long numeroDaConta;

    private final Agencia agencia;

    private float saldoEmReais;

    private Date dataDeCriacao;

    private Pessoa correntista;

    private Pessoa gerenteDaConta;

    private final TipoDeConta tipo;

    private ArrayList<String> historicoDeOperacoes;

    private DiaDaSemana diaDaSemanaParaSorteio;

    static int numeroDeContasCriadas = 0;

    /**
     *
     * @param correntista
     * @param agencia
     * @param tipo o tipo
     */
    public Conta(Pessoa correntista, Agencia agencia, TipoDeConta tipo) {
        this.historicoDeOperacoes = new ArrayList<>();
        this.dataDeCriacao = new Date();  // data corrente
        this.saldoEmReais = SALDO_INICIAL_DE_NOVAS_CONTAS;

        this.tipo = tipo;

        this.numeroDaConta = ++numeroDeContasCriadas;

        this.correntista = correntista;
        this.agencia = agencia;

//        this.diaDaSemanaParaSorteio = "Segunda";
//        this.diaDaSemanaParaSorteio = "segunda";
//        this.diaDaSemanaParaSorteio = "2a";
//        this.diaDaSemanaParaSorteio = "segunda-feira";
//        this.diaDaSemanaParaSorteio = "Mon";
//        this.diaDaSemanaParaSorteio = "Monday";
//        this.diaDaSemanaParaSorteio = "sdlkdsksdfkjhdsf";

        this.diaDaSemanaParaSorteio = DiaDaSemana.DOMINGO;  // domingo ??
        this.diaDaSemanaParaSorteio = DiaDaSemana.SEGUNDA;  // segunda ??
//        this.diaDaSemanaParaSorteio = 1;
//        this.diaDaSemanaParaSorteio = 2;
//        this.diaDaSemanaParaSorteio = -999;
//        this.diaDaSemanaParaSorteio = "segunda";

    }

    public DiaDaSemana getDiaDaSemanaParaSorteio() {
        return diaDaSemanaParaSorteio;
    }

    public void setDiaDaSemanaParaSorteio(DiaDaSemana diaDaSemana) {
        this.diaDaSemanaParaSorteio = diaDaSemana;
    }

    public TipoDeConta getTipo() {
        return this.tipo;
    }

    public long getNumeroDaConta() {
        return numeroDaConta;
    }

    public float getSaldoEmReais() {  // getter (métodos de acesso para leitura)
        return saldoEmReais;
    }

    private void setSaldoEmReais(float novoSaldo) {
        this.saldoEmReais = novoSaldo;
        if (novoSaldo < 0) {
            this.agencia.getBanco().registrarCorrentistaComSaldoNegativo(
                    this.correntista);
        }
    }

    public void depositarEmDinheiro(Map<Dinheiro, Integer> contagemPorCedulaOuMoeda) {
        float totalADepositar = 0;

//        for (Dinheiro cedulaOuMoeda : contagemPorCedulaOuMoeda.keySet()) {
//            int contagem = contagemPorCedulaOuMoeda.get(cedulaOuMoeda);
//            totalADepositar += contagem * cedulaOuMoeda.getValorMonetario();
//        }

        /* jeito mais elegante (e performático!) de iterar pelas chaves
                 e valores de um mapa */
        for (Map.Entry<Dinheiro, Integer> itemDoMapa : contagemPorCedulaOuMoeda.entrySet()) {
            Dinheiro cedulaOuMoeda = itemDoMapa.getKey();
            Integer contagem = itemDoMapa.getValue();
            totalADepositar += contagem * cedulaOuMoeda.getValorMonetario();
        }

        depositar(totalADepositar);
    }

    public void depositar(float valor) {
        // valida o parâmetro
        if (valor <= 0) {
            return;  // ToDo lançar uma exceção!!!!
        }

        if (tipo == TipoDeConta.CONTA_INVESTIMENTO &&
                valor < APORTE_MINIMO_PARA_INVESTIMENTOS) {
            return;  // ToDo lançar exceção específica (checked)
        }

        // altera o saldo
        setSaldoEmReais(this.saldoEmReais + valor);

        historicoDeOperacoes.add(String.format(
                "Deposito em dinheiro: R$%.2f na data %s",
                valor, new Date()));
    }

    public void sacar(float valor)
            throws SaqueDeValorNaoPositivoException, SaldoInsuficienteException {

        // valida o parâmetro
        if (valor <= 0) {
            throw new SaqueDeValorNaoPositivoException();
        }

        // verifica se há fundos na conta
        float valorAlemDoLimite = valor - (saldoEmReais + LIMITE_CHEQUE_ESPECIAL);
        if (valorAlemDoLimite > 0) {
            throw new SaldoInsuficienteException(valorAlemDoLimite);
        }

        setSaldoEmReais(this.saldoEmReais - valor);

        historicoDeOperacoes.add(String.format(
                "Saque em dinheiro: R$%.2f na data %s",
                valor, new Date()));
    }

    /**
     * Transfere um valor desta conta para a conta destino informada, se houver saldo suficiente
     * nesta conta.
     *
     * @param valor o valor desejado
     * @param contaDestino a conta de destino
     */
    public void transferir(float valor, Conta contaDestino) {
        // valida o parâmetro
        if (valor <= 0) {
            return;  // ToDo lançar uma exceção!!!!
        }

        // verifica se há fundos na conta
        if (valor > saldoEmReais + LIMITE_CHEQUE_ESPECIAL) {
            return;  // ToDo lançar uma exceção!!!!
        }

        setSaldoEmReais(this.saldoEmReais - valor);
        contaDestino.saldoEmReais += valor;

        historicoDeOperacoes.add(String.format(
                "Transferência efetuada para a conta %d: R$%.2f na data %s",
                contaDestino.numeroDaConta, valor, new Date()));

        contaDestino.historicoDeOperacoes.add(String.format(
                "Transferência recebida da conta %d: R$%.2f na data %s",
                this.numeroDaConta, valor, new Date()));
    }

    public String getUltimoItemHistorico() {
        return historicoDeOperacoes.size() > 0 ?
                historicoDeOperacoes.get(historicoDeOperacoes.size() - 1) :
                null;
    }

    public Agencia getAgencia() {
        return agencia;
    }
}
