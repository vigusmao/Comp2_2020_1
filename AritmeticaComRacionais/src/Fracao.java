public class Fracao {

    private int numerador;  // sempre não-negativo

    private int denominador;  // sempre positivo

    private boolean sinal;  // se false, eh negativa

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

    public void simplificar() {
        // ToDo IMPLEMENT ME!!!!
    }

    @Override
    public String toString() {
        return String.format("%s%d/%d",
                sinal ? "" : "-",
                numerador,
                denominador);
    }
}
