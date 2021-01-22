import java.util.ArrayList;

public class Album<T extends Colecionavel> {  // generic type

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;  // 90%

    private ArrayList<T> itensColados;

    private Repositorio<T> repositorio;

    private int contRepetidos[];

    private int totalItensColados;

    private int totalItensRepetidos;

    private int quantItensPorPacotinho;

    private int tamanhoDoAlbum;

    public Album(Repositorio<T> repositorio, int quantItensPorPacotinho) {

        this.repositorio = repositorio;
        this.tamanhoDoAlbum = repositorio.getTamanhoDoAlbum();

        itensColados = new ArrayList<>();
        /* inaugre as posições do ArrayList para que possam ser
           acessadas diretamente via set() */
        for (int i = 1; i <= tamanhoDoAlbum + 1; i++) {
            itensColados.add(null);
        }

        contRepetidos = new int[tamanhoDoAlbum + 1];
        this.quantItensPorPacotinho = quantItensPorPacotinho;
        this.tamanhoDoAlbum = tamanhoDoAlbum;
    }

    public void receberNovoPacotinho(Pacotinho<T> pacotinho) {
        for (T item : pacotinho) {
            int posicao = item.getPosicao();
            if (itensColados.get(posicao) == null) {
                // item inédito!
                colarItemInedito(item);
            } else {
                // item repetido!
                contRepetidos[posicao]++;
                totalItensRepetidos++;
            }
        }
    }

    private void colarItemInedito(T item) {
        itensColados.set(item.getPosicao(), item);
        totalItensColados++;
    }


    public void autoCompletar() {
        // verifica se o álbum já está suficientemente cheio
        if (this.totalItensColados >=
                this.tamanhoDoAlbum * PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f) {
            for (int i = 1; i <= this.tamanhoDoAlbum; i++) {
                if (this.itensColados.get(i) == null) {
                    T item = repositorio.obterItem(i);
                    colarItemInedito(item);
                }
            }
        }

    }

    public int getTamanho() {
        return this.tamanhoDoAlbum;
    }

    public int getQuantItensPorPacotinho() {
        return this.quantItensPorPacotinho;
    }

    public int getQuantItensColados() {
        return this.totalItensColados;
    }

    public int getQuantItensRepetidos() {
        return this.totalItensRepetidos;
    }

    public boolean possuiItemColado(int posicao) {
        if (posicao < 1 || posicao > this.tamanhoDoAlbum) {
            return false;
        }
        return getItemColado(posicao) != null;
    }

    public boolean possuiItemRepetido(int posicao) {
        if (posicao < 1 || posicao > this.tamanhoDoAlbum) {
            return false;
        }
        return this.contRepetidos[posicao] > 0;
    }

    public int getQuantItensFaltantes() {
        return this.tamanhoDoAlbum - this.totalItensColados;
    }

    public T getItemColado(int posicao) {
        return this.itensColados.get(posicao);
    }
}
