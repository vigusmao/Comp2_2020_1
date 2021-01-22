import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    private Album<Figurinha> albumFigurinhas;
    private Repositorio<Figurinha> repositorioFigurinhas;

    private Album<Selo> albumSelos;
    private Repositorio<Selo> repositorioSelos;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int ITENS_POR_PACOTE = 3;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.repositorioFigurinhas = new Repositorio<>(
                "Repositorio Teste", TAMANHO_DO_ALBUM, "figurinha");

        this.albumFigurinhas = new Album<>(repositorioFigurinhas, ITENS_POR_PACOTE);

        this.repositorioSelos = new Repositorio<>(
                "Repositorio Teste", TAMANHO_DO_ALBUM, "selo");

        this.albumSelos = new Album<>(repositorioSelos, ITENS_POR_PACOTE);
    }

    private void popularAlbuns(int[] posicoesDesejadas) {
        Pacotinho<Figurinha> pacoteFigurinhas = new Pacotinho<>(
                this.repositorioFigurinhas, posicoesDesejadas);
        this.albumFigurinhas.receberNovoPacotinho(pacoteFigurinhas);

        Pacotinho<Selo> pacoteSelos = new Pacotinho<>(
                this.repositorioSelos, posicoesDesejadas);
        this.albumSelos.receberNovoPacotinho(pacoteSelos);
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasExistentes() {
        popularAlbuns(new int[] {1, 2, 3});

        for (int i = 1; i <= ITENS_POR_PACOTE; i++) {
            assertTrue("Figurinhas já inseridas devem ser encontradas",
                    this.albumFigurinhas.possuiItemColado(i));
        }
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasAusentes() {
        popularAlbuns(new int[] {1, 2, 3});

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.albumFigurinhas.possuiItemColado(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.albumFigurinhas.possuiItemColado(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.albumFigurinhas.possuiItemColado(TAMANHO_DO_ALBUM + 1));
    }

    @Test
    public void testarPossuiRepetidaParaFigurinhaRepetida() {
        popularAlbuns(new int[] {1, 2, 3});

        assertFalse(this.albumFigurinhas.possuiItemRepetido(2));  // sanity check

        popularAlbuns(new int[] {2, 8, 9});
        assertTrue(this.albumFigurinhas.possuiItemRepetido(2));
    }

    @Test
    public void testarGetTamanhoAlbum() {
        assertEquals(TAMANHO_DO_ALBUM, this.albumFigurinhas.getTamanho());
    }

    @Test
    public void testarGetContFigurinhas() {
        popularAlbuns(new int[] {1, 2, 3});
        assertEquals(ITENS_POR_PACOTE, this.albumFigurinhas.getQuantItensColados());

        // vou agora abrir outro pacotinho com as mesmas figurinhas
        // e verificar que o álbum terá ainda 3 figurinhas

        popularAlbuns(new int[] {1, 2, 3});
        assertEquals(ITENS_POR_PACOTE, this.albumFigurinhas.getQuantItensColados());
    }

    @Test
    public void testarGetQuantasFaltam() {
        popularAlbuns(new int[] {1, 2, 3});
        assertEquals(TAMANHO_DO_ALBUM - ITENS_POR_PACOTE,
                this.albumFigurinhas.getQuantItensFaltantes());
    }

    @Test
    public void testarAutoCompletar() {
        albumFigurinhas.autoCompletar();
        assertEquals("Não deve ser possível auto-completar um álbum que esteja vazio",
                TAMANHO_DO_ALBUM, albumFigurinhas.getQuantItensFaltantes());

        // agora vamos adicionar pacotinhos aleatório até o álbum ficar quase cheio

        int minimoFigurinhasColadasParaAutoCompletar =
                (int) (TAMANHO_DO_ALBUM * Album.PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f);

        while (albumFigurinhas.getQuantItensColados() < minimoFigurinhasColadasParaAutoCompletar) {
            Pacotinho<Figurinha> novoPacotinho = new Pacotinho<>(
                    this.repositorioFigurinhas, ITENS_POR_PACOTE);  // aleatório
            albumFigurinhas.receberNovoPacotinho(novoPacotinho);
        }

        // sanity check
        assertTrue(albumFigurinhas.getQuantItensFaltantes() > 0);

        albumFigurinhas.autoCompletar();

        assertEquals(0, albumFigurinhas.getQuantItensFaltantes());  // álbum completo!
    }

    @Test
    public void testarGetItemColado() {
        popularAlbuns(new int[] {1, 2, 3});
        Figurinha figurinha = albumFigurinhas.getItemColado(2);
        Selo selo = albumSelos.getItemColado(2);

        assertNotNull(figurinha);
        assertNotNull(selo);

        assertEquals(2, figurinha.getPosicao());
        assertEquals(2, selo.getPosicao());

        assertNull(albumFigurinhas.getItemColado(4));
        assertNull(albumSelos.getItemColado(4));
    }

}
