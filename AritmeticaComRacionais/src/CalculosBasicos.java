public class CalculosBasicos {

    public static int codigo = 1234;

    /**
     * Calcula o MDC entre dois inteiros positivos
     * @param x um dos inteiros
     * @param y o outro inteiro
     * @return o MDC de x e y; ou 0, caso um deles não seja positivo
     */
    public static int calcularMDC(int x, int y) {

        if (x <= 0 || y <= 0) {
            return 0;  // como combinado
        }

        int resto = x % y;

        while (resto != 0) {
            x = y;
            y = resto;
            resto = x % y;
        }

        codigo++;

        return y;
    }

    public static void main(String[] args) {
        CalculosBasicos x = new CalculosBasicos();
        CalculosBasicos y = new CalculosBasicos();

        System.out.println("x.codigo = " + x.codigo);
        System.out.println("y.codigo = " + y.codigo);

        x.codigo = 333333;

        System.out.println("x.codigo = " + x.codigo);
        System.out.println("y.codigo = " + y.codigo);

        System.out.println("CalculosBasicos.codigo = " + CalculosBasicos.codigo);
    }
}
