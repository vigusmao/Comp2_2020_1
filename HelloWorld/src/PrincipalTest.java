import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrincipalTest {

    @Test
    public void testarCalculoMDC() {

        /* método static, portanto não precisa instanciar antes,
           basta chamar o método precedido pelo NOME da CLASSE */

        assertEquals(13, Principal.calcularMDC(26, 39));
        assertEquals(13, Principal.calcularMDC(39, 26));
        assertEquals(2, Principal.calcularMDC(26, 40));
    }

    @Test
    public void testarCalculoMDCQuandoUmDosNumerosEhNegativo() {

        /* método static, portanto não precisa instanciar antes,
           basta chamar o método precedido pelo NOME da CLASSE */

        assertEquals(0, Principal.calcularMDC(-13432, 3999));
    }

}
