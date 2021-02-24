public enum DiaDaSemana {

    DOMINGO("domingo", "Sun"),
    SEGUNDA("segunda-feira", "Mon"),
    TERCA("terça-feira", "Tue"),
    QUARTA("quarta-feira", "Wed"),
    QUINTA("quinta-feira", "Thu"),
    SEXTA("sexta-feira", "Fri"),
    SABADO("sábado", "Sat");

    private String nomePorExtenso;
    private String abreviacaoEmIngles;

    DiaDaSemana(String nomePorExtenso, String abreviacaoEmIngles) {
        this.nomePorExtenso = nomePorExtenso;
        this.abreviacaoEmIngles = abreviacaoEmIngles;
    }

    public String getNomePorExtenso() {
        return nomePorExtenso;
    }

    public String getAbreviacaoEmIngles() {
        return abreviacaoEmIngles;
    }
}
