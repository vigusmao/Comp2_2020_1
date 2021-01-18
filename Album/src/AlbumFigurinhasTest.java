import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumFigurinhasTest {

    private AlbumFigurinhas albumFigurinhas;
    private RepositorioFigurinhas repositorioFigurinhas;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int FIGURINHAS_POR_PACOTE = 3;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.repositorioFigurinhas = new RepositorioFigurinhas(
                "Repositorio Teste", TAMANHO_DO_ALBUM);

        this.albumFigurinhas = new AlbumFigurinhas(repositorioFigurinhas, FIGURINHAS_POR_PACOTE);
    }

    private void popularAlbum(int[] posicoesDesejadas) {
        PacotinhoFigurinhas pacote = new PacotinhoFigurinhas(
                this.repositorioFigurinhas, posicoesDesejadas);
        this.albumFigurinhas.receberNovoPacotinho(pacote);
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasExistentes() {
        popularAlbum(new int[] {1, 2, 3});

        for (int i = 1; i <= FIGURINHAS_POR_PACOTE; i++) {
            assertTrue("Figurinhas já inseridas devem ser encontradas",
                    this.albumFigurinhas.possuiFigurinhaColada(i));
        }
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasAusentes() {
        popularAlbum(new int[] {1, 2, 3});

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.albumFigurinhas.possuiFigurinhaColada(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.albumFigurinhas.possuiFigurinhaColada(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.albumFigurinhas.possuiFigurinhaColada(TAMANHO_DO_ALBUM + 1));
    }

    @Test
    public void testarPossuiRepetidaParaFigurinhaRepetida() {
        popularAlbum(new int[] {1, 2, 3});

        assertFalse(this.albumFigurinhas.possuiFigurinhaRepetida(2));  // sanity check

        popularAlbum(new int[] {2, 8, 9});
        assertTrue(this.albumFigurinhas.possuiFigurinhaRepetida(2));
    }

    @Test
    public void testarGetTamanhoAlbum() {
        assertEquals(TAMANHO_DO_ALBUM, this.albumFigurinhas.getTamanho());
    }

    @Test
    public void testarGetContFigurinhas() {
        popularAlbum(new int[] {1, 2, 3});
        assertEquals(FIGURINHAS_POR_PACOTE, this.albumFigurinhas.getQuantFigurinhasColadas());

        // vou agora abrir outro pacotinho com as mesmas figurinhas
        // e verificar que o álbum terá ainda 3 figurinhas

        popularAlbum(new int[] {1, 2, 3});
        assertEquals(FIGURINHAS_POR_PACOTE, this.albumFigurinhas.getQuantFigurinhasColadas());
    }

    @Test
    public void testarGetQuantasFaltam() {
        popularAlbum(new int[] {1, 2, 3});
        assertEquals(TAMANHO_DO_ALBUM - FIGURINHAS_POR_PACOTE,
                this.albumFigurinhas.getQuantFigurinhasFaltantes());
    }

    @Test
    public void testarAutoCompletar() {
        albumFigurinhas.autoCompletar();
        assertEquals("Não deve ser possível auto-completar um álbum que esteja vazio",
                TAMANHO_DO_ALBUM, albumFigurinhas.getQuantFigurinhasFaltantes());

        // agora vamos adicionar pacotinhos aleatório até o álbum ficar quase cheio

        int minimoFigurinhasColadasParaAutoCompletar =
                (int) (TAMANHO_DO_ALBUM * AlbumFigurinhas.PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f);

        while (albumFigurinhas.getQuantFigurinhasColadas() < minimoFigurinhasColadasParaAutoCompletar) {
            PacotinhoFigurinhas novoPacotinho = new PacotinhoFigurinhas(
                    this.repositorioFigurinhas, FIGURINHAS_POR_PACOTE);  // aleatório
            albumFigurinhas.receberNovoPacotinho(novoPacotinho);
        }

        // sanity check
        assertTrue(albumFigurinhas.getQuantFigurinhasFaltantes() > 0);

        albumFigurinhas.autoCompletar();

        assertEquals(0, albumFigurinhas.getQuantFigurinhasFaltantes());  // álbum completo!

    }

}
