public class PostoDeGasolina extends Estabelecimento {

    public PostoDeGasolina(String nome) {
        super(nome);
    }

    @Override
    public String getTipoEstabelecimento() {
        return "Posto de gasolina";
    }

    @Override
    public String getNome() { return "Posto " + super.getNome(); }
}
