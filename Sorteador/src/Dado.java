import java.util.Random;

public class Dado implements Sorteador {

    private static Random random;

    public Dado() {
        if (random == null) {
            random = new Random();
        }
    }

    @Override
    public int sortear() {
        return 1 + random.nextInt(6);
    }
}
