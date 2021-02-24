import java.util.Comparator;

public class ComparadorMalucoDeInteiros implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
//        return o1.toString().compareTo(o2.toString()) ;
        return o1*o1 - o2*o2;
    }
}
