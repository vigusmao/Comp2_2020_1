import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LojaTest {

    Loja loja;
    Livro livro1;
    Livro livro2;
    Usuario comprador;
    Transportadora gatoPreto;

    @Before
    public void setUp() {
        gatoPreto = new Transportadora();

        loja = new Loja(gatoPreto);  // informamos à loja qual a transportadora
                                     // que ela vai usar (agregação)

        livro1 = new Livro(12345, "Da Terra à Lua", "Julio Verne", null, 1865);
        livro1.setPrecoEmReais(25);

        livro2 = new Livro(12446, "Dom Quixote", "Miguel de Cervantes", null, 1605);
        livro2.setPrecoEmReais(42.30f);

        loja.incluirLivro(livro1);
        loja.incluirLivro(livro2);
        comprador = new Usuario(111111, "Maria");
        comprador.setEndereco("Rua Tal, Numero Tal");
    }

    @Test
    public void testarVendaParaLivroExistente() {
        String recibo = loja.receberPedido(livro2, 5, comprador);
        assertNotNull(recibo);
    }

    @Test
    public void testarVendaParaLivroNaoExistente() {
        Livro livroNaoExistente = new Livro(1010101, "Blah", "Qualquer coisa", null, 2000);
        String recibo = loja.receberPedido(livroNaoExistente, 5, comprador);
        assertNull(recibo);
    }

}