public class Album {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;  // 90%

    private int quantFigurinhasPorPacotinho;

    public Album(int tamanhoDoAlbum, int quantFigurinhasPorPacotinho) {
        // ToDo IMPLEMENT ME!!!!
    }

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        for (Figurinha fig : pacotinho) {


            // ToDo IMPLEMENT ME!!
        }
    }

    public void autoCompletar() {
        // verifica se o álbum já está suficientemente cheio

        // ToDo IMPLEMENT ME!!
    }

    public int getTamanho() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    public int getQuantFigurinhasPorPacotinho() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    public int getQuantFigurinhasColadas() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    public int getQuantFigurinhasRepetidas() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }

    public boolean possuiFigurinhaColada(int posicao) {
        // ToDo IMPLEMENT ME!!!
        return false;
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        // ToDo IMPLEMENT ME!!!
        return false;
    }

    public int getQuantFigurinhasFaltantes() {
        // ToDo IMPLEMENT ME!!!
        return 0;
    }
}
