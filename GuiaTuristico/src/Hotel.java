public class Hotel extends EstabelecimentoAvaliado {

    private int numeroDeEstrelas;

    public Hotel(String nome) {
        super(nome);
    }

    @Override
    public String getTipoEstabelecimento() {
        return "Hotel";
    }

    public int getNumeroDeEstrelas() {
        return numeroDeEstrelas;
    }

    public void setNumeroDeEstrelas(int numeroDeEstrelas) {
        this.numeroDeEstrelas = numeroDeEstrelas;
    }

    @Override
    public int getAvaliacao() {
        return getNumeroDeEstrelas();
    }
}
