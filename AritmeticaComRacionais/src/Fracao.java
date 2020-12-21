public class Fracao {

    private int numerador;  // sempre não-negativo

    private int denominador;  // sempre positivo

    private boolean sinal;  // se false, eh negativa

    public final static String SEPARADOR = ":";

    public Fracao(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("Fração com denominador zero!!!");
        }

        this.numerador = Math.abs(numerador);
        this.denominador = Math.abs(denominador);

        this.sinal = numerador * denominador >= 0;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public boolean getSinal() {
        return sinal;
    }

    public void simplificar() {
        Fracao fracaoGeratriz = getFracaoGeratriz();
        numerador = fracaoGeratriz.getNumerador();
        denominador = fracaoGeratriz.getDenominador();
    }

    public Fracao getFracaoGeratriz() {
        int mdc = CalculosBasicos.calcularMDC(numerador, denominador);

        if (mdc == 1) {
            return this;
        }

        int novoNumerador = (numerador / mdc) * (sinal ? 1 : -1);
        int novoDenominador = denominador / mdc;
        Fracao fracaoGeratriz = new Fracao(novoNumerador, novoDenominador);
        return fracaoGeratriz;
    }

    @Override
    public String toString() {
        String sinalComoString = sinal ? "" : "-";

        if (denominador == 1) {
            return String.format("%s%d",
                    sinalComoString,
                    numerador);
        }
        return String.format("%s%d%s%d",
                sinalComoString,
                numerador,
                SEPARADOR,
                denominador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fracao outraFracao = (Fracao) o;

        Fracao fracaoGeratriz = getFracaoGeratriz();
        Fracao outraFracaoGeratriz = outraFracao.getFracaoGeratriz();

        return fracaoGeratriz.getNumerador() == outraFracaoGeratriz.getNumerador() &&
                fracaoGeratriz.getDenominador() == outraFracaoGeratriz.getDenominador() &&
                fracaoGeratriz.getSinal() == outraFracaoGeratriz.getSinal();

    }
}
