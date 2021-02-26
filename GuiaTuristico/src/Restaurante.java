public class Restaurante extends EstabelecimentoAvaliado {

    private static int MAX_PRATOS = 100;

    private float notaMediaDadaPelosClientes;  // de 0 a 10
    private int quantidadeDeClientesQueAvaliaram;

    Comida[] cardapio;
    int contPratos = 0;

    public Restaurante(String nome) {
        super(nome);
        this.cardapio = new Comida[MAX_PRATOS];
    }

    @Override
    public String getTipoEstabelecimento() {
        return "Restaurante";
    }

    public Comida[] getCardapio() {
        return this.cardapio;
    }

    public void incluirPratoCardapio(Comida prato) {
        this.cardapio[this.contPratos++] = prato;
    }

    public void incluirNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota inválida");
        }
        float somatorioNotas = this.notaMediaDadaPelosClientes * this.quantidadeDeClientesQueAvaliaram;
        somatorioNotas += nota;
        this.notaMediaDadaPelosClientes = somatorioNotas / ++this.quantidadeDeClientesQueAvaliaram;
    }

    @Override
    public int getAvaliacao() {
        return (int) Math.ceil(notaMediaDadaPelosClientes / 2);  // Math.ceil arredonda pra cima
    }
}
