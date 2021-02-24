import java.util.*;

public class Principal {


    public static void main(String[] args) {

//        ComparadorMalucoDeInteiros meuComparador = new ComparadorMalucoDeInteiros();
//        List<Integer> lista = new ArrayList<>();
//
//        lista.add(9);
//        lista.add(-2879);
//        lista.add(967);
//        lista.add(1239);
//        lista.add(39);
//        lista.add(97);
//
//        printarLista(lista);
//
//        lista.sort(meuComparador);
//
//        printarLista(lista);
//

        ComparadorMalucoDePessoas meuComparador = new ComparadorMalucoDePessoas();
        List<Pessoa> lista = new ArrayList<>();

        Calendar.getInstance().set(1976, 11, 24);
        Date data = Calendar.getInstance().getTime();

        lista.add(new Pessoa("Vinícius", data, 3267327));
        lista.add(new Pessoa("Maria", data, 27));
        lista.add(new Pessoa("João", data, 3267327));
        lista.add(new Pessoa("Fulana", data, 1111));
        lista.add(new Pessoa("Beltrana", data, 2222));

        System.out.println(lista);

        lista.sort(meuComparador);

        System.out.println(lista);
    }

    private static class ComparadorMalucoDePessoas implements Comparator<Pessoa> {

        @Override
        public int compare(Pessoa pessoa1, Pessoa pessoa2) {

            return Long.compare(pessoa1.getCpf(), pessoa2.getCpf());

//        return pessoa1.getNome().compareTo(pessoa2.getNome());
        }
    }

}
